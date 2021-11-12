package fr.diginamic.entities.store;

import fr.diginamic.entities.animals.Animal;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "MAGASIN")
public class PetStore implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOM", length = 50, nullable = false)
    private String name;

    @Column(name = "CADRE", length = 50, nullable = false)
    private String managerName;

    @Embedded
    private Address address = new Address();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private final Set<Animal> animals = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "PRODUIT_VENTE",
            joinColumns = @JoinColumn(name = "ID_MAG", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_PROD", referencedColumnName = "ID"))
    private final Set<Product> products = new HashSet<>();

    public PetStore() {
    }

    public PetStore(String name, String managerName, String number, String street, String zipCode, String city) {
        setName(name);
        setManagerName(managerName);
        setAddress(new Address(number, street, zipCode, city));
    }

    //  ANIMAL
    public Set<Animal> getAnimals() {
        return animals;
    }

    public void addAllAnimal(Set<Animal> animals) {
        this.animals.addAll(animals);
        animals.forEach(a -> a.assignment(this));
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void petStoreUpdate(PetStore petStoreOld) {
        if (getId() == null)
            setId(petStoreOld.getId());
        if (getName() == null)
            setName(petStoreOld.getName());
        if (getManagerName() == null)
            setManagerName(petStoreOld.getManagerName());
        address.addressMerge(petStoreOld.getAddress());
    }


    //  PRODUCT
    public Set<Product> getProducts() {
        return products;
    }

    public void addAllProduct(Set<Product> products) {
        this.products.addAll(products);
        products.forEach(p->p.addPetStore(this));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    //  GETTER AND SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof PetStore))
            return false;
        PetStore petStore = (PetStore) obj;
        if(petStore.getId() != null)
           return getId().equals(petStore.getId());
        return Objects.equals(getName(), petStore.getName())
                && Objects.equals(getManagerName(), petStore.getManagerName())
                && Objects.equals(getAddress(), petStore.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash( getName(), getManagerName(), getAddress());
    }
}

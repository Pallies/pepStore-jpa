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

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
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
        animals.forEach(a -> a.assignment(this));
        this.animals.addAll(animals);
    }

    public void addAnimal(Animal animal) {
        animal.assignment(this);
        animals.add(animal);
    }

    public void deleteAnimal(Animal animal) {
        animals.removeIf(animalRef -> animalRef.equals(animal));
    }

    //  PRODUCT
    public Set<Product> getProducts() {
        return products;
    }

    public void addAllProduct(Set<Product> products) {

        this.products.addAll(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
        products.removeIf(productRef -> productRef.equals(product));
    }

    //  GETTER AND SETTER
    public Long getId() {
        return id;
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
}

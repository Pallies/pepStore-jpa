package fr.diginamic.entities.store;

import fr.diginamic.entities.animals.Animal;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * The Class PetStore.
 */
@Entity
@Table(name = "MAGASIN")
public class PetStore implements Serializable {

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * The name.
     */
    @Column(name = "NOM", length = 50, nullable = false)
    private String name;

    /**
     * The manager name.
     */
    @Column(name = "CADRE", length = 50, nullable = false)
    private String managerName;

    /**
     * The address.
     */
    @Embedded
    private Address address = new Address();

    /**
     * The animals.
     */
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private final Set<Animal> animals = new HashSet<>();

    /**
     * The products.
     */
    @ManyToMany
    @JoinTable(name = "PRODUIT_VENTE",
            joinColumns = @JoinColumn(name = "ID_MAG", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_PROD", referencedColumnName = "ID"))
    private Set<Product> products = new HashSet<>();


    /**
     * Instantiates a new pet store.
     */
    public PetStore() {
    }

    /**
     * Instantiates a new pet store.
     *
     * @param name        the name
     * @param managerName the manager name
     * @param number      the number
     * @param street      the street
     * @param zipCode     the zip code
     * @param city        the city
     */
    public PetStore(String name, String managerName, String number, String street, String zipCode, String city) {
        setName(name);
        setManagerName(managerName);
        setAddress(new Address(number, street, zipCode, city));
    }

    /**
     * Gets the animals.
     *
     * @return the animals
     */
    //  ANIMAL
    public Set<Animal> getAnimals() {
        return animals;
    }

    /**
     * #Relation PetStore -> Animal
     * Adds the all animal.
     *
     * @param animals the animals
     */
    public void addAllAnimal(Set<Animal> animals) {
        this.animals.addAll(animals);
        animals.forEach(a -> a.assignment(this));
    }

    /**
     * Adds the animal.
     *
     * @param animal the animal
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /**
     * Pet store update.
     * merge old in new
     *
     * @param petStoreOld the pet store old
     */
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

    /**
     * Gets the products.
     *
     * @return the products
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Sets the products.
     *
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    /**
     * #Relation PetStore -> Product
     * Adds the all product.
     *
     * @param products the products
     */
    public void addAllProduct(Set<Product> products) {
        this.products.addAll(products);
        products.forEach(p -> p.addPetStore(this));
    }

    /**
     * Adds the product.
     *
     * @param product the product
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    //  GETTER AND SETTER
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the manager name.
     *
     * @return the manager name
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Sets the manager name.
     *
     * @param managerName the new manager name
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address the new address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PetStore))
            return false;
        PetStore petStore = (PetStore) obj;
        if (petStore.getId() != null)
            return getId().equals(petStore.getId());
        return Objects.equals(getName(), petStore.getName())
                && Objects.equals(getManagerName(), petStore.getManagerName())
                && Objects.equals(getAddress(), petStore.getAddress());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getManagerName(), getAddress());
    }
}

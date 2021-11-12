package fr.diginamic.entities.store;

import fr.diginamic.enums.ProdType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The Class Product.
 */
@Entity
@Table(name = "PRODUIT")
public class Product implements Serializable {
    
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /** The code. */
    @Column(name = "REF", length = 50, nullable = false)
    private String code;

    /** The label. */
    @Column(name = "NOM", nullable = false)
    private String label;

    /** The type. */
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private ProdType type;

    /** The price. */
    @Column(name = "PRIX", precision = 10, scale = 2, nullable = false)
    private Double price;

    /** The pet stores. */
    @ManyToMany(mappedBy = "products")
    private final Set<PetStore> petStores = new HashSet<>();

    /**
     * Instantiates a new product.
     */
    public Product() {
    }

    /**
     * Instantiates a new product.
     *
     * @param code the code
     * @param label the label
     * @param type the type
     * @param price the price
     */
    public Product(String code, String label, ProdType type, Double price) {
        setCode(code);
        setLabel(label);
        setType(type);
        setPrice(price);
    }

    /**
     * Product update.
     *
     * @param product the product
     */
    public void productUpdate(Product product) {
        if (getId() == null)
            setId(product.getId());
        if (getCode() == null)
            setCode(product.getCode());
        if (getLabel() == null)
            setLabel(product.getLabel());
        if (getType() == null)
            setType(product.getType());
        if (getPrice() == null)
            setPrice(product.getPrice());
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
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
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label.
     *
     * @param label the new label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public ProdType getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(ProdType type) {
        this.type = type;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets the pet stores.
     *
     * @return the pet stores
     */
    public Set<PetStore> getPetStores() {
        return petStores;
    }

    /**
     * Adds the pet store.
     *
     * @param petStore the pet store
     */
    public void addPetStore(PetStore petStore) {
        petStores.add(petStore);
        petStore.addProduct(this);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", petStores=" + petStores +
                '}';
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Product))
            return false;
        Product product = (Product) obj;
        return getCode().equals(product.getCode());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode());
    }
}

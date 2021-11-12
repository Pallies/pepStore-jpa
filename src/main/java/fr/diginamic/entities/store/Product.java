package fr.diginamic.entities.store;

import fr.diginamic.enums.ProdType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PRODUIT")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "REF", length = 50, nullable = false)
    private String code;

    @Column(name = "NOM", nullable = false)
    private String label;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private ProdType type;

    @Column(name = "PRIX", precision = 10, scale = 2, nullable = false)
    private Double price;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private final Set<PetStore> petStores = new HashSet<>();

    public Product() {
    }

    public Product(String code, String label, ProdType type, Double price) {
        setCode(code);
        setLabel(label);
        setType(type);
        setPrice(price);
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void addPetStore(PetStore petStore) {
        petStores.add(petStore);
        petStore.addProduct(this);
    }

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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Product))
            return false;
        Product product = (Product) obj;
        return getCode().equals(product.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode());
    }
}

package fr.diginamic.entities.animals;

import fr.diginamic.entities.store.PetStore;
import fr.diginamic.enums.Color;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * The Class Animal.
 */
@Entity
@Table(name = "ANIMAL")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal implements Serializable {
    
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The Date. */
    @Column(name = "NAISSANCE", columnDefinition = "DATE")
    private LocalDate Date;

    /** The color. */
    @Column(name = "COULEUR")
    @Enumerated(EnumType.STRING)
    private Color color;

    /** The store. */
    @ManyToOne
    @JoinColumn(name = "ID_STORE")
    private PetStore store = null;

    /**
     * Instantiates a new animal.
     */
    public Animal() {
    }

    /**
     * Instantiates a new animal.
     *
     * @param date the date
     * @param color the color
     */
    public Animal(LocalDate date, Color color) {
        Date = date;
        this.color = color;
    }

    /**
     * Gets the store.
     *
     * @return the store
     */
    // STORE
    public PetStore getStore() {
        return store;
    }

    /**
     * #Relation Animal -> Store
     * Assignment.
     * the petStore
     * and petStore add Animal
     * @param store the store
     */
    public void assignment(PetStore store) {
        if(store != null){
            this.store = store;
            store.addAnimal(this);
        }
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
     * Gets the date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return Date;
    }

    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public void setDate(LocalDate date) {
        Date = date;
    }

    /**
     * Gets the color.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color.
     *
     * @param color the new color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Sets the animal.
     * merge old in new animal
     * @param <T> the generic type
     * @param animalOld the new animal
     */
    public <T extends Animal> void setAnimal(T animalOld) {
        if (getId() == null)
            setId(animalOld.getId());
        if (getDate() == null)
            setDate(animalOld.getDate());
        if (getColor() == null)
            setColor(animalOld.getColor());
        if (getStore() == null)
            assignment(animalOld.getStore());
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Animal))
            return false;
        Animal animal = (Animal) obj;
        return getId().equals(animal.getId());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        String categorie = this instanceof Fish ? "Poisson " :"Chat ";
        String store = this.store == null ? "en attente d'affectation" : this.store.getName();
        final StringBuffer sb = new StringBuffer("Animal ");
        sb.append(" Catégorie : ").append(categorie)
        .append(", Date : ").append(Date)
        .append(color)
        .append(", store : ").append(store);
        return sb.toString();
    }
}

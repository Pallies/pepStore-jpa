package fr.diginamic.entities.animals;

import fr.diginamic.entities.store.PetStore;
import fr.diginamic.enums.Color;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ANIMAL")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAISSANCE", columnDefinition = "DATE")
    private LocalDate Date;

    @Column(name = "COULEUR")
    @Enumerated(EnumType.STRING)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "ID_STORE")
    private PetStore store = null;

    public Animal() {
    }

    public Animal(LocalDate date, Color color) {
        Date = date;
        this.color = color;
    }

    // STORE
    public PetStore getStore() {
        return store;
    }

    public void assignment(PetStore store) {
        if(store != null){
            this.store.deleteAnimal(this);
            this.store = store;
            this.store.addAnimal(this);
        }
    }

    //  GETTER AND SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Animal))
            return false;
        Animal animal = (Animal) obj;
        return getId().equals(animal.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

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

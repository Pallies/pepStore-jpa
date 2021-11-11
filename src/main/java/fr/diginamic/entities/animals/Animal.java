package fr.diginamic.entities.animals;

import fr.diginamic.entities.store.PetStore;

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
    private String color;

    @ManyToOne
    @JoinColumn(name = "ID_STORE")
    private PetStore store = null;

    public Animal() {
    }

    public Animal(LocalDate date, String color) {
        Date = date;
        this.color = color;
    }

    // STORE
    public PetStore getStore() {
        return store;
    }

    public void assignment(PetStore store) {
        this.store.deleteAnimal(this);
        this.store = store;
        this.store.addAnimal(this);
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
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
}

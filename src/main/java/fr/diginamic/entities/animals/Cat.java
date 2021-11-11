package fr.diginamic.entities.animals;

import fr.diginamic.entities.store.PetStore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "CAT")
public class Cat extends Animal implements Serializable {

    @Column(length = 6,nullable = false)
    private String chipId;

    public Cat() {
    }

    public Cat(LocalDate date, String color,  String chipId) {
        super(date, color);
        this.chipId = chipId;
    }

    public void setCat(Cat catOld) {
        if (getChipId() == null)
            setChipId(catOld.getChipId());
        setAnimal(catOld);
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

}

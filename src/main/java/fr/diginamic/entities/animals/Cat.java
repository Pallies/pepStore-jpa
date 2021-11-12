package fr.diginamic.entities.animals;

import fr.diginamic.enums.Color;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Class Cat.
 */
@Entity
@Table(name = "CAT")
public class Cat extends Animal implements Serializable {

    /** The chip id. */
    @Column(length = 6, nullable = false)
    private String chipId;

    /**
     * Instantiates a new cat.
     */
    public Cat() {
    }

    /**
     * Instantiates a new cat.
     *
     * @param date the date
     * @param color the color
     * @param chipId the chip id
     */
    public Cat(LocalDate date, Color color, String chipId) {
        super(date, color);
        this.chipId = chipId;
    }

    /**
     * Sets the cat.
     *
     * @param catOld the new cat
     */
    public void setCat(Cat catOld) {
        if (getChipId() == null)
            setChipId(catOld.getChipId());
        setAnimal(catOld);
    }

    /**
     * Gets the chip id.
     *
     * @return the chip id
     */
    public String getChipId() {
        return chipId;
    }

    /**
     * Sets the chip id.
     *
     * @param chipId the new chip id
     */
    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return super.toString() + " chipId : " + chipId;
    }
}

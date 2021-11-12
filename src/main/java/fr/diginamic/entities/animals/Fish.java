package fr.diginamic.entities.animals;

import fr.diginamic.entities.store.PetStore;
import fr.diginamic.enums.Color;
import fr.diginamic.enums.FishLivEnv;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Class Fish.
 */
@Entity
@Table(name = "FISH")
public class Fish extends Animal implements Serializable {

    /** The living env. */
    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    /**
     * Instantiates a new fish.
     */
    public Fish() {
    }

    /**
     * Instantiates a new fish.
     *
     * @param date the date
     * @param color the color
     * @param livingEnv the living env
     */
    public Fish(LocalDate date, Color color, FishLivEnv livingEnv) {
        super(date, color);
        this.livingEnv = livingEnv;
    }

    /**
     * Gets the living env.
     *
     * @return the living env
     */
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    /**
     * Sets the living env.
     *
     * @param livingEnv the new living env
     */
    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    /**
     * Sets the fish.
     *
     * @param fishOld the new fish
     */
    public void setFish(Fish fishOld) {
        if (getLivingEnv() == null)
            setLivingEnv(fishOld.getLivingEnv());
        setAnimal(fishOld);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return super.toString()+" livingEnv : " + livingEnv;
    }
}

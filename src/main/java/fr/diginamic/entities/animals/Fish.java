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

@Entity
@Table(name = "FISH")
public class Fish extends Animal implements Serializable {

    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    public Fish() {
    }

    public Fish(LocalDate date, Color color, FishLivEnv livingEnv) {
        super(date, color);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    public void setFish(Fish fishOld) {
        if (getLivingEnv() == null)
            setLivingEnv(fishOld.getLivingEnv());
        setAnimal(fishOld);
    }

    @Override
    public String toString() {
        return super.toString()+" livingEnv : " + livingEnv;
    }
}

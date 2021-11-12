package fr.diginamic.utils.initializer;

import fr.diginamic.entities.animals.Animal;
import fr.diginamic.entities.animals.Cat;
import fr.diginamic.entities.animals.Fish;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.services.BuilderService;
import fr.diginamic.services.Service;
import fr.diginamic.utils.Rand;
import fr.diginamic.utils.enums.NameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * The Class AnimalsInit.
 */
public final class AnimalsInit {
    
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(AnimalsInit.class);
    
    /** The Constant ANIMALS. */
    private static final Animal[] ANIMALS = {
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat(Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish(Rand.getDate(), Rand.getColor(), Rand.getEnv()),
    };


    /**
     * Insert all animals.
     * in data base
     */
    public static void insertAllAnimals() {
        List<Animal> animalls = Arrays.asList(ANIMALS);
        Service<Animal> animalService = BuilderService.createService(Animal.class);
        animalls.forEach(animalService::save);
        animalls.forEach(a -> LOGGER.trace("save in database -> {}", a));
    }
}

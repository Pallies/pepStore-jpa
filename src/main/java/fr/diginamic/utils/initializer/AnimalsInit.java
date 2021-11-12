package fr.diginamic.utils.initializer;

import fr.diginamic.entities.animals.Animal;
import fr.diginamic.entities.animals.Cat;
import fr.diginamic.entities.animals.Fish;
import fr.diginamic.enums.Color;
import fr.diginamic.enums.FishLivEnv;
import fr.diginamic.services.BuilderService;
import fr.diginamic.services.Service;
import fr.diginamic.utils.Rand;
import fr.diginamic.utils.enums.NameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public abstract class AnimalsInit {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnimalsInit.class);
    private static final Animal[] animals={
            new Cat(Rand.getDate(), Rand.getColor(),Rand.chipID()),
            new Cat( Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Cat( Rand.getDate(), Rand.getColor(), Rand.chipID()),
            new Fish( Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish( Rand.getDate(), Rand.getColor(), Rand.getEnv()),
            new Fish( Rand.getDate(), Rand.getColor(), Rand.getEnv()),
    };


    public static void insertAllAnimals() {
        List<Animal> animalls = Arrays.asList(animals);
        Service<Animal,Long> animalService = BuilderService.createService(NameRepository.ANIMAL);
        animalls.forEach(animalService::save);

     animalls.forEach(a->LOGGER.trace("save in database -> {}",a));
    }
}

package fr.diginamic.utils.initializer;

import fr.diginamic.dao.impl.IDaoImpl;
import fr.diginamic.entities.animals.Animal;
import fr.diginamic.entities.animals.Cat;
import fr.diginamic.entities.animals.Fish;
import fr.diginamic.enums.Color;
import fr.diginamic.enums.FishLivEnv;
import fr.diginamic.services.BuilderService;
import fr.diginamic.utils.enums.NameRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AnimalsInit {
    Animal[][] animals={
            {new Cat( LocalDate.of(2016,5,12), Color.NOIR.name(),"456RTS")},
            {new Cat( LocalDate.of(2013,10,2), Color.ROUX.name(), "498AZS")},
            {new Cat( LocalDate.of(2020,9,2), Color.CANNELLE.name(), "235TRk")},
            {new Fish( LocalDate.of(2021,5,12), Color.NOIR.name(), FishLivEnv.SEA_WATER)},
            {new Fish( LocalDate.of(2020,11,21), Color.ROUGE.name(), FishLivEnv.FRESH_WATER)},
            {new Fish( LocalDate.of(2020,6,7), Color.JAUNE.name(), FishLivEnv.SEA_WATER)}
    };


    public void setAnimals(Animal[][] animals) {
        List<Animal[]> animauls = Arrays.asList(animals);
        Cat test = new Cat( LocalDate.of(2016,5,12), Color.NOIR.name(),"456RTS");
        IDaoImpl<Cat,Long> animalService = BuilderService.createService(NameRepository.CAT);
        animalService.save(test);
    }
}

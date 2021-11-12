package fr.diginamic.services;

import fr.diginamic.entities.animals.Animal;
import fr.diginamic.entities.animals.Cat;
import fr.diginamic.entities.animals.Fish;
import fr.diginamic.utils.enums.NameRepository;

import java.util.ArrayList;
import java.util.List;

public class AnimalService extends Service<Animal>  {

    private final Service<Cat> catService;
    private final Service<Fish> fishService;

    {
        fishService =  BuilderService.createService(NameRepository.FISH);
        catService =  BuilderService.createService(NameRepository.CAT);

    }

    @Override
    public List<Animal> find() {
        List<Animal> animals = new ArrayList<>();
        animals.addAll(catService.find());
        animals.addAll(fishService.find());
        return animals;
    }

    @Override
    public Animal findById(Long id) {
        return null;
    }

    @Override
    public boolean save(Animal animal) {
        return animal instanceof Cat ?
                catService.save((Cat) animal) :
                animal instanceof Fish && fishService.save((Fish) animal);
    }

    @Override
    public boolean update(Animal animalOld, Animal animalNew) {
        return animalOld instanceof Cat && animalNew instanceof Cat ?
                catService.update((Cat) animalOld, (Cat) animalNew) :
                animalOld instanceof Fish && animalNew instanceof Fish &&
                        fishService.update((Fish) animalOld, (Fish) animalNew);
    }

    @Override
    public boolean delete(Animal animal) {
        return animal instanceof Cat ?
                catService.delete((Cat) animal) :
                animal instanceof Fish && fishService.delete((Fish) animal);
    }

    public List<? extends Animal> find(Class<Animal> animalClass) {
        return animalClass.isInstance(Cat.class) ?
                    catService.find() :
                    animalClass.isInstance(Fish.class) ?
                            fishService.find() : null;
         }
}

package fr.diginamic.services;

import fr.diginamic.dao.impl.IAnimalDaoImpl;
import fr.diginamic.dao.impl.ICatDaoImpl;
import fr.diginamic.dao.impl.IFishDaoImpl;
import fr.diginamic.entities.animals.Animal;
import fr.diginamic.entities.animals.Cat;
import fr.diginamic.entities.animals.Fish;

import java.util.ArrayList;
import java.util.List;

public class AnimalService implements IAnimalDaoImpl {

    private final ICatDaoImpl catService;
    private final IFishDaoImpl fishService;

    {
        catService = (ICatDaoImpl) new CatService();
        fishService = (IFishDaoImpl) new FishService();
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

    @Override
    public List<Animal> find(Class<Animal> animalClass) {
            return animalClass.isInstance(Cat.class) ?
                    catService.find() :
                    animalClass.isInstance(Fish.class) ? fishService.find() : null;
    }
}

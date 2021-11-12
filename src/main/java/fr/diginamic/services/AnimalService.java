package fr.diginamic.services;

import fr.diginamic.dao.impl.IAnimalDaoImpl;
import fr.diginamic.dao.impl.ICatDaoImpl;
import fr.diginamic.dao.impl.IFishDaoImpl;
import fr.diginamic.entities.animals.Animal;
import fr.diginamic.entities.animals.Cat;
import fr.diginamic.entities.animals.Fish;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.utils.enums.NameRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class AnimalService.
 */
public class AnimalService extends Service<Animal> implements IAnimalDaoImpl {

    /** The cat service. */
    private static Service<Cat> catService;
    
    /** The fish service. */
    private static Service<Fish> fishService;

    {
        catService =  BuilderService.createService( Cat.class);
        fishService =  BuilderService.createService( Fish.class);

    }

    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Animal> find() {
        List<Animal> animals = new ArrayList<>();
        animals.addAll(catService.find());
        animals.addAll(fishService.find());
        return animals;
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the animal
     */
    @Override
    public Animal findById(Long id) {
        return null;
    }

    /**
     * Save.
     *
     * @param animal the animal
     * @return true, if successful
     */
    @Override
    public boolean save(Animal animal) {
        return animal instanceof Cat ?
                catService.save((Cat) animal) :
                animal instanceof Fish && fishService.save((Fish) animal);
    }

    /**
     * Update.
     *
     * @param animalOld the animal old
     * @param animalNew the animal new
     * @return true, if successful
     */
    @Override
    public boolean update(Animal animalOld, Animal animalNew) {
        return animalOld instanceof Cat && animalNew instanceof Cat ?
                catService.update((Cat) animalOld, (Cat) animalNew) :
                animalOld instanceof Fish && animalNew instanceof Fish &&
                        fishService.update((Fish) animalOld, (Fish) animalNew);
    }

    /**
     * Delete.
     *
     * @param animal the animal
     * @return true, if successful
     */
    @Override
    public boolean delete(Animal animal) {
        return animal instanceof Cat ?
                catService.delete((Cat) animal) :
                animal instanceof Fish && fishService.delete((Fish) animal);
    }

    /**
     * Find.
     *
     * @param animalClass the animal class
     * @return the list<? extends animal>
     */
    public List<? extends Animal> find(Class<Animal> animalClass) {
        return animalClass.isInstance(Cat.class) ?
                    catService.find() :
                    animalClass.isInstance(Fish.class) ?
                            fishService.find() : null;
         }
}

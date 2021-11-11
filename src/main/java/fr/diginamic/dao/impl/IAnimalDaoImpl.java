package fr.diginamic.dao.impl;

import fr.diginamic.entities.animals.Animal;

import java.util.List;

public interface IAnimalDaoImpl extends IDaoImpl<Animal,Long> {

    public List<Animal> find();
    public List<? extends Animal> find(Class<Animal> animalClass);
}

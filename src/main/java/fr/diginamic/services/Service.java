package fr.diginamic.services;

import fr.diginamic.dao.impl.IDaoImpl;
import fr.diginamic.entities.animals.Animal;
import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;

import java.util.List;

public abstract class Service<T> implements IDaoImpl<T,Long> {

    public PetStore findByAddress(Address address){
        return null;
    };

}

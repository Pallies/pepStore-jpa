package fr.diginamic.services;

import fr.diginamic.dao.impl.IDaoImpl;
import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;


/**
 * The Class Service.
 * 
 * @param <T> the generic type
 */
public abstract class Service<T> implements IDaoImpl<T,Long>{
    
    /**
     * Find by address.
     *
     * @param address the address
     * @return the pet store
     */
    public PetStore findByAddress(Address address){return null;};
}

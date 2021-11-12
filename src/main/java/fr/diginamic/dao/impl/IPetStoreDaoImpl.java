package fr.diginamic.dao.impl;

import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;

/**
 * The Interface IPetStoreDaoImpl.
 */
public interface IPetStoreDaoImpl extends IDaoImpl<PetStore,Long> {
     
     /**
      * Find by address.
      *
      * @param address the address
      * @return the pet store
      */
     public PetStore findByAddress(Address address);
}

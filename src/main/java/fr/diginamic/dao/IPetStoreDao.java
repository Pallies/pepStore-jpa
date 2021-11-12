package fr.diginamic.dao;

import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;

/**
 * The Interface IPetStoreDao.
 */
public interface IPetStoreDao extends IDao<PetStore,Long> {
   
   /**
    * Find by address.
    *
    * @param address the address
    * @return the pet store
    */
   PetStore findByAddress(Address address);
}

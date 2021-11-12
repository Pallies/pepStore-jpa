package fr.diginamic.dao;

import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;

public interface IPetStoreDao extends IDao<PetStore,Long> {
   PetStore findByAddress(Address address);
}

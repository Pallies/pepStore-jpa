package fr.diginamic.dao.impl;

import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;

public interface IPetStoreDaoImpl extends IDaoImpl<PetStore,Long> {
     public PetStore findByAddress(Address address);
}

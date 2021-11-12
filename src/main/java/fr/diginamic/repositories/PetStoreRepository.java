package fr.diginamic.repositories;

import fr.diginamic.dao.IPetStoreDao;
import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.utils.enums.ModeDB;

import javax.persistence.TypedQuery;
import java.util.List;

public class PetStoreRepository extends Repository implements IPetStoreDao {
    @Override
    public List<PetStore> find() {
        return getEntityManger()
                .createQuery("SELECT p FROM PetStore as p", PetStore.class)
                .getResultList();
    }

    @Override
    public PetStore findById(Long id) {
        return getEntityManger().find(PetStore.class, id);
    }

    @Override
    public PetStore findByAddress(Address address) {
        TypedQuery<PetStore> qry = getEntityManger().createQuery("SELECT p FROM PetStore as p JOIN p.address as a WHERE p.address= :address", PetStore.class);
        qry.setParameter("address", address);
        return qry.getSingleResult();
    }

    @Override
    public void save(PetStore petStore) {
        getTransaction(ModeDB.PERSIST, petStore);
    }

    @Override
    public void update(PetStore petStore) {
        getTransaction(ModeDB.MERGE, petStore);
    }

    @Override
    public void delete(PetStore petStore) {
        getTransaction(ModeDB.REMOVE, petStore);
    }

    @Override
    public boolean contains(PetStore petStore) {
        return getEntityManger().contains(petStore);
    }

}

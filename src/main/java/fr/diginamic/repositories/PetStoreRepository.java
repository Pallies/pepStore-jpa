package fr.diginamic.repositories;

import fr.diginamic.dao.IPetStoreDao;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.utils.enums.ModeDB;

import java.util.List;

public class PetStoreRepository extends Repository<PetStore> implements IPetStoreDao {
    @Override
    public List<PetStore> find() {
        return getEntityManger()
                .createQuery("SELECT p FROM PetStore as p", PetStore.class)
                .getResultList();
    }

    @Override
    public PetStore findById(Long id) {
        return getEntityManger().find(PetStore.class,id);
    }

    @Override
    public void save(PetStore petStore) {
        getTransaction(ModeDB.PERSIST,petStore);
    }

    @Override
    public void update(PetStore petStore) {
        getTransaction(ModeDB.MERGE,petStore);
    }

    @Override
    public void delete(PetStore petStore) {
        getTransaction(ModeDB.REMOVE,petStore);
    }

    @Override
    public boolean contains(PetStore petStore) {
        return getEntityManger().contains(petStore);
    }

}

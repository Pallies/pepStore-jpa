package fr.diginamic.repositories;

import fr.diginamic.dao.IPetStoreDao;
import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.utils.enums.ModeDB;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The Class PetStoreRepository.
 */
public class PetStoreRepository extends Repository implements IPetStoreDao {
    
    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<PetStore> find() {
        return getEntityManger()
                .createQuery("SELECT p FROM PetStore as p", PetStore.class)
                .getResultList();
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the pet store
     */
    @Override
    public PetStore findById(Long id) {
        return getEntityManger().find(PetStore.class, id);
    }

    /**
     * Find by address.
     *
     * @param address the address
     * @return the pet store
     */
    @Override
    public PetStore findByAddress(Address address) {
        TypedQuery<PetStore> qry = getEntityManger().createQuery("SELECT p FROM PetStore as p JOIN p.address as a WHERE p.address= :address", PetStore.class);
        qry.setParameter("address", address);
        return qry.getSingleResult();
    }

    /**
     * Save.
     *
     * @param petStore the pet store
     */
    @Override
    public void save(PetStore petStore) {
        getTransaction(ModeDB.PERSIST, petStore);
    }

    /**
     * Update.
     *
     * @param petStore the pet store
     */
    @Override
    public void update(PetStore petStore) {
        getTransaction(ModeDB.MERGE, petStore);
    }

    /**
     * Delete.
     *
     * @param petStore the pet store
     */
    @Override
    public void delete(PetStore petStore) {
        getTransaction(ModeDB.REMOVE, petStore);
    }

    /**
     * Contains.
     *
     * @param petStore the pet store
     * @return true, if successful
     */
    @Override
    public boolean contains(PetStore petStore) {
        return getEntityManger().contains(petStore);
    }

}

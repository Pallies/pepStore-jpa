package fr.diginamic.repositories;

import fr.diginamic.dao.IAddressDao;
import fr.diginamic.dao.IDao;
import fr.diginamic.entities.store.Address;

import java.util.List;

/**
 * The Class AddressRepository.
 */
public class AddressRepository extends Repository implements IAddressDao {
    
    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Address> find() {
        return getEntityManger()
                .createQuery("SELECT a.address FROM PetStore as a", Address.class)
                .getResultList();
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the address
     */
    @Override
    public Address findById(Long id) {
        return getEntityManger().find(Address.class, id);
    }

    /**
     * Save.
     *
     * @param object the object
     */
    @Deprecated
    public void save(Address object) {
    }

    /**
     * Update.
     *
     * @param object the object
     */
    @Deprecated
    public void update(Address object) {

    }

    /**
     * Delete.
     *
     * @param object the object
     */
    @Deprecated
    public void delete(Address object) {

    }

    /**
     * Contains.
     *
     * @param object the object
     * @return true, if successful
     */
    @Deprecated
    public boolean contains(Address object) {
        return false;
    }

}

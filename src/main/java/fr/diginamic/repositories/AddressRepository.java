package fr.diginamic.repositories;

import fr.diginamic.dao.IAdresseDao;
import fr.diginamic.entities.store.Address;

import java.util.List;

public class AddressRepository extends Repository<Address> implements IAdresseDao {
    @Override
    public List<Address> find() {
        return getEntityManger()
                .createQuery("SELECT a.address FROM PetStore as a", Address.class)
                .getResultList();
    }

    @Override
    public Address findById(Long id) {
        return getEntityManger().find(Address.class, id);
    }

    @Deprecated
    public void save(Address object) {
    }

    @Deprecated
    public void update(Address object) {

    }

    @Deprecated
    public void delete(Address object) {

    }

    @Deprecated
    public boolean contains(Address object) {
        return false;
    }

}

package fr.diginamic.services;

import fr.diginamic.dao.IPetStoreDao;
import fr.diginamic.dao.impl.IPetStoreDaoImpl;
import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.repositories.BuilderRepository;
import fr.diginamic.utils.enums.NameRepository;

import java.util.List;

/**
 * The Class PetStoreService.
 */
public class PetStoreService extends Service<PetStore> implements IPetStoreDaoImpl {

    /** The repository. */
    private final IPetStoreDao repository;

    {
        repository = (IPetStoreDao) BuilderRepository.getRepository(NameRepository.PetStore);
    }

    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<PetStore> find() {
        return repository.find();
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the pet store
     */
    @Override
    public PetStore findById(Long id) {
        return (PetStore) repository.findById(id);
    }


    /**
     * Find by address.
     *
     * @param address the address
     * @return the pet store
     */
    public PetStore findByAddress(Address address){
        return repository.findByAddress(address);
    }
    
    /**
     * Save.
     *
     * @param petStore the pet store
     * @return true, if successful
     */
    @Override
    public boolean save(PetStore petStore) {
        repository.save(petStore);
        return repository.contains(petStore);
    }

    /**
     * Update.
     *
     * @param petStoreOld the pet store old
     * @param petStoreNew the pet store new
     * @return true, if successful
     */
    @Override
    public boolean update(PetStore petStoreOld, PetStore petStoreNew) {
        petStoreNew.petStoreUpdate(petStoreOld);
        repository.update(petStoreNew);
        return repository.contains(petStoreNew);
    }

    /**
     * Delete.
     *
     * @param petStore the pet store
     * @return true, if successful
     */
    @Override
    public boolean delete(PetStore petStore) {
        return repository.contains(petStore);
    }
}

package fr.diginamic.services;

import fr.diginamic.dao.IPetStoreDao;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.utils.enums.NameRepository;

import java.util.List;

public class PetStoreService extends Service<PetStore, Long> {

    private IPetStoreDao repository;

    {
        repository = (IPetStoreDao) BuilderService.createService(NameRepository.PETSTORE);
    }

    @Override
    public List<PetStore> find() {
        return repository.find();
    }

    @Override
    public PetStore findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean save(PetStore petStore) {
        repository.save(petStore);
        return repository.contains(petStore);
    }

    @Override
    public boolean update(PetStore petStoreOld, PetStore petStoreNew) {
        petStoreNew.petStoreUpdate(petStoreOld);
        repository.update(petStoreNew);
        return repository.contains(petStoreNew);
    }

    @Override
    public boolean delete(PetStore petStore) {
        return repository.contains(petStore);
    }
}
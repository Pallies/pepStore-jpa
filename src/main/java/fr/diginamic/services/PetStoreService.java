package fr.diginamic.services;

import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.repositories.BuilderRepository;
import fr.diginamic.repositories.Repository;
import fr.diginamic.utils.enums.NameRepository;

import java.util.List;

public class PetStoreService extends Service<PetStore>{

    private final Repository<PetStore> repository;

    {
        repository = (Repository<PetStore>) BuilderRepository.getRepository(NameRepository.PETSTORE);
    }

    @Override
    public List<PetStore> find() {
        return repository.find();
    }

    @Override
    public PetStore findById(Long id) {
        return (PetStore) repository.findById(id);
    }


    public PetStore findByAddress(Address address){
        return repository.findByAddress(address);
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

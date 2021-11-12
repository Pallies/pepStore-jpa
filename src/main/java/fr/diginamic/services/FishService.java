package fr.diginamic.services;


import fr.diginamic.entities.animals.Fish;
import fr.diginamic.repositories.BuilderRepository;
import fr.diginamic.repositories.Repository;
import fr.diginamic.utils.enums.NameRepository;

import java.util.List;


public class FishService extends Service<Fish,Long> {

    private static Repository repository;

    {
        repository = BuilderRepository.getRepository(NameRepository.FISH);
    }

    @Override
    public Fish findById(Long id) {
        return (Fish) repository.findById(id);
    }

    @Override
    public List<Fish> find() {
        return repository.find();
    }

    @Override
    public boolean save(Fish fish) {
        repository.save(fish);
        return repository.contains(fish);
    }

    @Override
    public boolean update(Fish fishOld, Fish fishNew) {
        fishNew.setFish(fishOld);
        repository.update(fishNew);
        return repository.contains(fishNew);
    }

    @Override
    public boolean delete(Fish fish) {
        repository.delete(fish);
        return repository.contains(fish);
    }
}

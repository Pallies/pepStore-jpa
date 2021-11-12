package fr.diginamic.services;


import fr.diginamic.dao.IFishDao;
import fr.diginamic.dao.impl.IFishDaoImpl;
import fr.diginamic.entities.animals.Fish;
import fr.diginamic.repositories.BuilderRepository;
import fr.diginamic.utils.enums.NameRepository;

import java.util.List;


/**
 * The Class FishService.
 */
public class FishService extends Service<Fish> implements IFishDaoImpl {

    /** The repository. */
    private static IFishDao repository;

    {
        repository = (IFishDao) BuilderRepository.getRepository(NameRepository.Fish);
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the fish
     */
    @Override
    public Fish findById(Long id) {
        return (Fish) repository.findById(id);
    }

    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Fish> find() {
        return repository.find();
    }

    /**
     * Save.
     *
     * @param fish the fish
     * @return true, if successful
     */
    @Override
    public boolean save(Fish fish) {
        repository.save(fish);
        return repository.contains(fish);
    }

    /**
     * Update.
     *
     * @param fishOld the fish old
     * @param fishNew the fish new
     * @return true, if successful
     */
    @Override
    public boolean update(Fish fishOld, Fish fishNew) {
        fishNew.setFish(fishOld);
        repository.update(fishNew);
        return repository.contains(fishNew);
    }

    /**
     * Delete.
     *
     * @param fish the fish
     * @return true, if successful
     */
    @Override
    public boolean delete(Fish fish) {
        repository.delete(fish);
        return repository.contains(fish);
    }
}

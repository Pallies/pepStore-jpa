package fr.diginamic.services;

import fr.diginamic.dao.ICatDao;
import fr.diginamic.dao.impl.ICatDaoImpl;
import fr.diginamic.entities.animals.Cat;
import fr.diginamic.repositories.BuilderRepository;
import fr.diginamic.utils.enums.NameRepository;

import java.util.List;

/**
 * The Class CatService.
 */
public class CatService extends Service<Cat> implements ICatDaoImpl {


    /** The repository. */
    private static ICatDao repository;

    {
        repository = (ICatDao) BuilderRepository.getRepository(NameRepository.Cat);
    }


    /**
     * Find by id.
     *
     * @param id the id
     * @return the cat
     */
    @Override
    public Cat findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Cat> find() {
        return repository.find();
    }

    /**
     * Save.
     *
     * @param cat the cat
     * @return true, if successful
     */
    @Override
    public boolean save(Cat cat) {
        repository.save(cat);
        return repository.contains(cat);
    }

    /**
     * Update.
     *
     * @param catOld the cat old
     * @param catNew the cat new
     * @return true, if successful
     */
    @Override
    public boolean update(Cat catOld, Cat catNew) {
        catNew.setCat(catOld);
        repository.update(catNew);
        return repository.contains(catNew);
    }

    /**
     * Delete.
     *
     * @param cat the cat
     * @return true, if successful
     */
    @Override
    public boolean delete(Cat cat) {
        repository.delete(cat);
        return !repository.contains(cat);
    }
}

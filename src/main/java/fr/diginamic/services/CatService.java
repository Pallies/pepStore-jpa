package fr.diginamic.services;

import fr.diginamic.dao.ICatDao;
import fr.diginamic.dao.impl.ICatDaoImpl;
import fr.diginamic.entities.animals.Cat;
import fr.diginamic.repositories.BuilderRepository;
import fr.diginamic.utils.enums.NameRepository;

import java.util.List;

public class CatService extends Service<Cat> implements ICatDaoImpl {


    private static ICatDao repository;

    {
        repository = (ICatDao) BuilderRepository.getRepository(NameRepository.Cat);
    }


    @Override
    public Cat findById(Long id) {
        return (Cat) repository.findById(id);
    }

    @Override
    public List<Cat> find() {
        return repository.find();
    }

    @Override
    public boolean save(Cat cat) {
        repository.save(cat);
        return repository.contains(cat);
    }

    @Override
    public boolean update(Cat catOld, Cat catNew) {
        catNew.setCat(catOld);
        repository.update(catNew);
        return repository.contains(catNew);
    }

    @Override
    public boolean delete(Cat cat) {
        repository.delete(cat);
        return !repository.contains(cat);
    }
}

package fr.diginamic.services;

import fr.diginamic.dao.IProductDao;
import fr.diginamic.dao.impl.IProductDaoImpl;
import fr.diginamic.entities.store.Product;
import fr.diginamic.repositories.BuilderRepository;
import fr.diginamic.utils.enums.NameRepository;

import java.util.List;

public class ProductService extends Service<Product> implements IProductDaoImpl {

    private final IProductDao repository;

    {
        repository = (IProductDao) BuilderRepository.getRepository(NameRepository.Product);
    }

    @Override
    public List<Product> find() {
        return repository.find();
    }

    @Override
    public Product findById(Long id) {
        return (Product) repository.findById(id);
    }

    @Override
    public boolean save(Product product) {
        repository.save(product);
        return repository.contains(product);
    }

    @Override
    public boolean update(Product productOld, Product productNew) {
        //todo
        return repository.contains(productNew);
    }

    @Override
    public boolean delete(Product product) {
        repository.delete(product);
        return repository.contains(product);
    }
}

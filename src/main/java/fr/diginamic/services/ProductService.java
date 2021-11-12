package fr.diginamic.services;

import fr.diginamic.dao.IProductDao;
import fr.diginamic.dao.impl.IProductDaoImpl;
import fr.diginamic.entities.store.Product;
import fr.diginamic.repositories.BuilderRepository;
import fr.diginamic.utils.enums.NameRepository;

import java.util.List;

/**
 * The Class ProductService.
 */
public class ProductService extends Service<Product> implements IProductDaoImpl {

    /** The repository. */
    private final IProductDao repository;

    {
        repository = (IProductDao) BuilderRepository.getRepository(NameRepository.Product);
    }

    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Product> find() {
        return repository.find();
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the product
     */
    @Override
    public Product findById(Long id) {
        return (Product) repository.findById(id);
    }

    /**
     * Save.
     *
     * @param product the product
     * @return true, if successful
     */
    @Override
    public boolean save(Product product) {
        repository.save(product);
        return repository.contains(product);
    }

    /**
     * Update.
     *
     * @param productOld the product old
     * @param productNew the product new
     * @return true, if successful
     */
    @Override
    public boolean update(Product productOld, Product productNew) {
        //todo
        return repository.contains(productNew);
    }

    /**
     * Delete.
     *
     * @param product the product
     * @return true, if successful
     */
    @Override
    public boolean delete(Product product) {
        repository.delete(product);
        return repository.contains(product);
    }
}

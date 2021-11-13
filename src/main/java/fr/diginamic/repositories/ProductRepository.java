package fr.diginamic.repositories;

import fr.diginamic.dao.IProductDao;
import fr.diginamic.entities.store.Product;
import fr.diginamic.utils.enums.ModeDB;

import java.util.List;

/**
 * The Class ProductRepository.
 */
public class ProductRepository extends Repository implements IProductDao {
    
    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Product> find() {
        return getEntityManger()
                .createQuery("SELECT p FROM Product as p", Product.class)
                .getResultList();
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the product
     */
    @Override
    public Product findById(Long id) {
        return getEntityManger().find(Product.class,id);
    }

    /**
     * Save.
     *
     * @param product the product
     */
    @Override
    public void save(Product product) {
        getTransaction(ModeDB.PERSIST,product);
    }

    /**
     * Update.
     *
     * @param product the product
     */
    @Override
    public void update(Product product) {
        getTransaction(ModeDB.MERGE,product);
    }

    /**
     * Delete.
     *
     * @param product the product
     */
    @Override
    public void delete(Product product) {
        getTransaction(ModeDB.REMOVE,product);
    }

    /**
     * Contains.
     *
     * @param product the product
     * @return true, if successful
     */
    @Override
    public boolean contains(Product product) {
        return getEntityManger().contains(product);
    }

    }

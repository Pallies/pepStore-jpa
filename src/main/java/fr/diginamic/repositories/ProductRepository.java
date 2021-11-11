package fr.diginamic.repositories;

import fr.diginamic.dao.IProductDao;
import fr.diginamic.entities.store.Product;
import fr.diginamic.utils.enums.ModeDB;

import java.util.List;

public class ProductRepository extends CommonsRepository<Product> implements IProductDao {
    @Override
    public List<Product> find() {
        return getEntityManger()
                .createQuery("SELECT p FROM Product as p", Product.class)
                .getResultList();
    }

    @Override
    public Product findById(Long id) {
        return getEntityManger().find(Product.class,id);
    }

    @Override
    public void save(Product product) {
        getTransaction(ModeDB.PERSIST,product);
    }

    @Override
    public void update(Product product) {
        getTransaction(ModeDB.MERGE,product);
    }

    @Override
    public void delete(Product product) {
        getTransaction(ModeDB.REMOVE,product);
    }

    @Override
    public boolean contains(Product product) {
        return getEntityManger().contains(product);
    }

    @Override
    public IProductDao getIDao() {
        return this;
    }
}
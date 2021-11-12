package fr.diginamic.dao;

import fr.diginamic.entities.store.Product;

/**
 * The Interface IProductDao.
 */
public interface IProductDao extends IDao<Product,Long>{
    
    /**
     * Contains.
     *
     * @param object the object
     * @return true, if successful
     */
    public abstract boolean contains(Product object);
}

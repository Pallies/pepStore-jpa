package fr.diginamic.dao;

import fr.diginamic.entities.store.Product;

public interface IProductDao extends IDao<Product,Long>{
    public abstract boolean contains(Product object);
}

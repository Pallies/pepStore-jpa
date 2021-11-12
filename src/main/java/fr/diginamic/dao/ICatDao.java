package fr.diginamic.dao;

import fr.diginamic.entities.animals.Cat;

/**
 * The Interface ICatDao.
 */
public interface ICatDao extends IDao<Cat,Long>{
    
    /**
     * Contains.
     *
     * @param object the object
     * @return true, if successful
     */
    public abstract boolean contains(Cat object);
}

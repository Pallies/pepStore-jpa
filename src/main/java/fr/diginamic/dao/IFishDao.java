package fr.diginamic.dao;

import fr.diginamic.entities.animals.Fish;

/**
 * The Interface IFishDao.
 */
public interface IFishDao extends IDao<Fish,Long> {
    
    /**
     * Contains.
     *
     * @param object the object
     * @return true, if successful
     */
    public abstract boolean contains(Fish object);
}

package fr.diginamic.dao;

import fr.diginamic.entities.animals.Cat;

public interface ICatDao extends IDao<Cat,Long>{
    public abstract boolean contains(Cat object);
}

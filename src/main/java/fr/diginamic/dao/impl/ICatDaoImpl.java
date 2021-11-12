package fr.diginamic.dao.impl;

import fr.diginamic.entities.animals.Cat;

import java.util.List;

public interface ICatDaoImpl extends IDaoImpl<Cat,Long>{
    public List<Cat> find();
}

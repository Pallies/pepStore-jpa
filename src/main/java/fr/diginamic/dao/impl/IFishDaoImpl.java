package fr.diginamic.dao.impl;

import fr.diginamic.entities.animals.Animal;
import fr.diginamic.entities.animals.Fish;

import java.util.List;

public interface IFishDaoImpl extends IDaoImpl<Fish, Long> {
    public List<Fish> find();

}

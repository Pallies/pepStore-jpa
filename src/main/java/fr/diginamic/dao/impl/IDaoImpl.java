package fr.diginamic.dao.impl;

import java.util.List;

public interface IDaoImpl<T,U>  {

    public List<T> find();

    public T findById(U id);

    public boolean save(T object);

    public boolean update(T objectOld,T objectNew);

    public boolean delete(T object);

}

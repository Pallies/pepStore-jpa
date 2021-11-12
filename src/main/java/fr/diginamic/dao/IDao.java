package fr.diginamic.dao;


import java.util.List;

public interface IDao<T, U> {

    public List<T> find();

    public T findById(U id);

    public void save(T object);

    public void update(T object);

    public void delete(T object);

    public boolean contains(T object);



}

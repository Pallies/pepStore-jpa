package fr.diginamic.dao;


import java.util.List;

/**
 * The Interface IDao.
 * generic interface for the repository
 * @param <T> the generic type
 * @param <U> the generic type
 */
public interface IDao<T, U> {

    /**
     * Find.
     *
     * @return the list
     */
    public List<T> find();

    /**
     * Find by id.
     *
     * @param id the id
     * @return the t
     */
    public T findById(U id);

    /**
     * Save.
     *
     * @param object the object
     */
    public void save(T object);

    /**
     * Update.
     *
     * @param object the object
     */
    public void update(T object);

    /**
     * Delete.
     *
     * @param object the object
     */
    public void delete(T object);

    /**
     * Contains.
     *
     * @param object the object
     * @return true, if successful
     */
    public boolean contains(T object);

}

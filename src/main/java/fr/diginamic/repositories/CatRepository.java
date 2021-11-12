package fr.diginamic.repositories;

import fr.diginamic.dao.ICatDao;
import fr.diginamic.entities.animals.Cat;
import fr.diginamic.utils.enums.ModeDB;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The Class CatRepository.
 */
public class CatRepository extends Repository implements ICatDao {

    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Cat> find() {
        return getEntityManger()
                .createQuery("SELECT c FROM Cat as c", Cat.class)
                .getResultList();
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the cat
     */
    @Override
    public Cat findById(Long id) {
        return getEntityManger().find(Cat.class, id);
    }

    /**
     * Fin by chip id.
     *
     * @param id the id
     * @return the cat
     */
    public Cat finByChipId(String id) {
        TypedQuery<Cat> qry = getEntityManger()
                .createQuery("SELECT c FROM Cat as c WHERE c.chipId= :chipsId", Cat.class);
        qry.setParameter("chipsId", id);
        return qry.getSingleResult();
    }

    /**
     * Save.
     *
     * @param cat the cat
     */
    @Override
    public void save(Cat cat) {
        getTransaction(ModeDB.PERSIST, cat);
    }

    /**
     * Update.
     *
     * @param cat the cat
     */
    @Override
    public void update(Cat cat) {
        getTransaction(ModeDB.MERGE, cat);
    }

    /**
     * Delete.
     *
     * @param cat the cat
     */
    @Override
    public void delete(Cat cat) {
        getTransaction(ModeDB.REMOVE, cat);
    }

    /**
     * Contains.
     *
     * @param cat the cat
     * @return true, if successful
     */
    @Override
    public boolean contains(Cat cat) {
        return getEntityManger().contains(cat);
    }

}

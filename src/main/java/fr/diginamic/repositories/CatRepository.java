package fr.diginamic.repositories;

import fr.diginamic.dao.ICatDao;
import fr.diginamic.entities.animals.Cat;
import fr.diginamic.utils.enums.ModeDB;

import javax.persistence.TypedQuery;
import java.util.List;

public class CatRepository extends Repository<Cat> implements ICatDao {

    @Override
    public List<Cat> find() {
        return getEntityManger()
                .createQuery("SELECT c FROM Cat as c", Cat.class)
                .getResultList();
    }

    @Override
    public Cat findById(Long id) {
        return getEntityManger().find(Cat.class, id);
    }

    @Override
    public Cat finByChipId(String id) {
        TypedQuery<Cat> qry = getEntityManger()
                .createQuery("SELECT c FROM Cat as c WHERE c.chipId= :chipsId", Cat.class);
        qry.setParameter("chipsId", id);
        return qry.getSingleResult();
    }

    @Override
    public void save(Cat cat) {
        getTransaction(ModeDB.PERSIST, cat);
    }

    @Override
    public void update(Cat cat) {
        getTransaction(ModeDB.MERGE, cat);
    }

    @Override
    public void delete(Cat cat) {
        getTransaction(ModeDB.REMOVE, cat);
    }

    @Override
    public boolean contains(Cat cat) {
        return getEntityManger().contains(cat);
    }
}

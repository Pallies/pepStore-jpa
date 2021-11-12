package fr.diginamic.repositories;

import fr.diginamic.dao.IDao;
import fr.diginamic.dao.IFishDao;
import fr.diginamic.entities.animals.Fish;
import fr.diginamic.entities.store.Product;
import fr.diginamic.utils.enums.ModeDB;

import java.util.List;

public class FishRepository extends Repository implements IFishDao {


    @Override
    public List<Fish> find() {
        return getEntityManger()
                .createQuery("SELECT f FROM Fish as f", Fish.class)
                .getResultList();
    }

    @Override
    public Fish findById(Long id) {
        return getEntityManger().find(Fish.class, id);
    }

    @Override
    public void save(Fish fish) {
        getTransaction(ModeDB.PERSIST, fish);
    }

    @Override
    public void update(Fish fish) {
        getTransaction(ModeDB.MERGE, fish);
    }

    @Override
    public void delete(Fish fish) {
        getTransaction(ModeDB.REMOVE, fish);
    }

    @Override
    public boolean contains(Fish fish) {
        return getEntityManger().contains(fish);
    }

}

package fr.diginamic.repositories;

import fr.diginamic.dao.IDao;
import fr.diginamic.dao.IFishDao;
import fr.diginamic.entities.animals.Fish;
import fr.diginamic.entities.store.Product;
import fr.diginamic.utils.enums.ModeDB;

import java.util.List;

/**
 * The Class FishRepository.
 */
public class FishRepository extends Repository implements IFishDao {


    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Fish> find() {
        return getEntityManger()
                .createQuery("SELECT f FROM Fish as f", Fish.class)
                .getResultList();
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the fish
     */
    @Override
    public Fish findById(Long id) {
        return getEntityManger().find(Fish.class, id);
    }

    /**
     * Save.
     *
     * @param fish the fish
     */
    @Override
    public void save(Fish fish) {
        getTransaction(ModeDB.PERSIST, fish);
    }

    /**
     * Update.
     *
     * @param fish the fish
     */
    @Override
    public void update(Fish fish) {
        getTransaction(ModeDB.MERGE, fish);
    }

    /**
     * Delete.
     *
     * @param fish the fish
     */
    @Override
    public void delete(Fish fish) {
        getTransaction(ModeDB.REMOVE, fish);
    }

    /**
     * Contains.
     *
     * @param fish the fish
     * @return true, if successful
     */
    @Override
    public boolean contains(Fish fish) {
        return getEntityManger().contains(fish);
    }

}

package fr.diginamic.repositories;

import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.utils.enums.ModeDB;
import fr.diginamic.utils.connection.ConnectionDB;

import javax.persistence.EntityManager;

/**
 * The Class Repository.
 */
public abstract class Repository {

    /**
     * Gets the entity manger.
     *
     * @return the entity manger
     */
    public EntityManager getEntityManger() {
        return ConnectionDB.getEntityManager();
    }

    /**
     * Gets the transaction.
     *
     * @param <T> the generic type
     * @param mode the mode
     * @param object the object
     * @return the transaction
     */
    public <T> void  getTransaction(ModeDB mode, T object) {
        EntityManager em = ConnectionDB.getEntityManager();

        em.getTransaction().begin();
        switch (mode) {
            case PERSIST:
                em.persist(object);
                break;
            case MERGE:
                em.merge(object);
                break;
            case REMOVE:
                em.remove(object);
                break;
            default:
                break;
        }
        em.getTransaction().commit();
    }
    
    /**
     * Find by address.
     *
     * @param address the address
     * @return the pet store
     */
    public PetStore findByAddress(Address address){
        return null;}
}

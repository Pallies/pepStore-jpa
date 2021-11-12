package fr.diginamic.repositories;

import fr.diginamic.dao.IDao;
import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.utils.enums.ModeDB;
import fr.diginamic.utils.connection.ConnectionDB;

import javax.persistence.EntityManager;

public abstract class Repository {

    public EntityManager getEntityManger() {
        return ConnectionDB.getEntityManager();
    }

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
    public PetStore findByAddress(Address address){
        return null;
    };
}

package fr.diginamic.utils.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ResourceBundle;

/**
 * The Class ConnectionDB.
 * Singleton
 */
public final class ConnectionDB {

    /** The entity manager. */
    private static EntityManager entityManager;
    
    /** The persistence. */
    private static String persistence;

    {
    	// configuration in file .properties
        String database_File = "petStoreConfig";
        String database_name = "DB_PEP_SHOP";
        ResourceBundle props = ResourceBundle.getBundle(database_File);
        persistence = props.getString(database_name);
    }

    /**
     * Instantiates a new connection DB.
     */
    private ConnectionDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence);
        entityManager = emf.createEntityManager();
    }

    /**
     * Gets the entity manager.
     *
     * @return the entity manager
     */
    public static EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen())
            new ConnectionDB();
        return entityManager;
    }

    /**
     * Close connection.
     */
    public static void closeConnection() {
        if (entityManager.isOpen())
            entityManager.close();
    }
}

package fr.diginamic.utils.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ResourceBundle;

public final class ConnectionDB {

    private static EntityManager entityManager;
    private static String persistence;

    {
        String database_File = "petStoreConfig";
        String database_name = "DB_PEP_SHOP";
        ResourceBundle props = ResourceBundle.getBundle(database_File);
        persistence = props.getString(database_name);
    }

    private ConnectionDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence);
        entityManager = emf.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen())
            new ConnectionDB();
        return entityManager;
    }

    public static void closeConnection() {
        if (entityManager.isOpen())
            entityManager.close();
    }
}

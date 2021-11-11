package fr.diginamic;

import fr.diginamic.utils.connection.ConnectionDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {
        EntityManager test = ConnectionDB.getEntityManager();
        LOGGER.trace("Lancement App {}",test);

    }
}

package fr.diginamic;

import fr.diginamic.entities.store.PetStore;
import fr.diginamic.utils.connection.ConnectionDB;
import fr.diginamic.utils.initializer.AnimalsInit;
import fr.diginamic.utils.initializer.PetStoreInit;
import fr.diginamic.utils.initializer.ProductInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

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

        AnimalsInit.insertAllAnimals();
        PetStoreInit.insertStore();
        ProductInit.insertProduct();
        PetStoreInit.persistProduct();
        PetStoreInit.persitAnimal();
        PetStoreInit.getAnimalsInPetStores(2);
    }
}

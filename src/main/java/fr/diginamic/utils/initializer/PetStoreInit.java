package fr.diginamic.utils.initializer;

import fr.diginamic.entities.animals.Animal;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.entities.store.Product;
import fr.diginamic.services.BuilderService;
import fr.diginamic.services.Service;
import fr.diginamic.utils.enums.NameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class PetStoreInit.
 */
public final class PetStoreInit {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(PetStoreInit.class);

    /** The Constant PET_STORES. */
    private static final PetStore[] PET_STORES = {
            new PetStore("E.Leclerc Animalerie", "LECLERC", "", "Bd Auguste Durand", "85600", "Montaigu-Vendée"),
            new PetStore("Poulailler Direct", "POULAILLER", "15bis", "Av. de la Vertonne", "44120", "Vertou"),
            new PetStore("Chou-Pet", "CHOUPET", "56", "Rue Fouré", "44000", "Nantes"),
            new PetStore("Hariet & Rosie", "HARIET", "5", "Rue Voltaire", "44400", "Nantes"),
            new PetStore("Médor & Compagnie", "LISPE", "", "ZC Atoud Sud", "44400", "Rezée"),
            new PetStore("Liopé Animalerie", "LIOPE", "12", "Rue Marie Curie", "44230", "Saint-Sébastien-sur-Loire"),
    };

    /**
     * Insert store.
     * in data base
     */
    public static void insertStore() {
        List<PetStore> petStores = Arrays.asList(PET_STORES);
        Service<PetStore> petStoreService = BuilderService.createService(PetStore.class);
        petStores.forEach(petStoreService::save);
        petStores.forEach(petStore -> LOGGER.trace("petStore -> {}", petStore.getName()));
    }

    /**
     * Persist product.
     * in data base with relation
     */
    public static void persistProduct() {
        LOGGER.trace("affectation des produits");
        Service<PetStore> petStoreService = BuilderService.createService(PetStore.class);
        Service<Product> productService = BuilderService.createService(Product.class);
        List<PetStore> petStores = petStoreService.find();
        List<Product> products = productService.find();

        for (int i = 0; i < 6; i++) {
            Set<String> codes = ProductInit.getProduct(i).stream().map(Product::getCode).collect(Collectors.toSet());
            petStores.get(i).addAllProduct(products.stream().filter(p -> codes.contains(p.getCode())).collect(Collectors.toSet()));
            petStoreService.save(petStores.get(i));
        }
    }

    /**
     * Persit animal.
     * in data base with relation
     */
    public static void persitAnimal() {
        LOGGER.trace("affectation des Animaux");
        Service<PetStore> petStoreService = BuilderService.createService(PetStore.class);
        Service<Animal> animalService = BuilderService.createService(Animal.class);
        List<Animal> animals = animalService.find();
        List<PetStore> petStores = petStoreService.find();
        int i = 0;
        for (PetStore store : petStores) {
            Set<Animal> animalStore = animals.stream().skip(i).limit(12).collect(Collectors.toSet());
            store.addAllAnimal(animalStore);
            i += 12;
            petStoreService.save(store);
        }
    }

    /**
     * Gets the animals in pet stores.
     *
     * @param id the id
     * @return the animals in pet stores
     */
    public static void getAnimalsInPetStores(int id) {
        if (id < 0 || id >= 6)
            return;
        Service<PetStore> petStoreService = BuilderService.createService(PetStore.class);
        Set<Animal> animals = petStoreService.findByAddress(PET_STORES[id].getAddress()).getAnimals();
        LOGGER.trace("\n\n réponse à la question du TP : \n\n\n ");
        animals.forEach(a -> LOGGER.trace("{} appartenant à l'animalerie {}", a, a.getStore().getName()));
    }

}


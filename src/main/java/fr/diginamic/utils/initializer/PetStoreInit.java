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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class PetStoreInit {

    private static final Logger LOGGER = LoggerFactory.getLogger(PetStoreInit.class);

    private static final PetStore[] PET_STORES = {
            new PetStore("E.Leclerc Animalerie", "LECLERC", "", "Bd Auguste Durand", "85600", "Montaigu-Vendée"),
            new PetStore("Poulailler Direct", "POULAILLER", "15bis", "Av. de la Vertonne", "44120", "Vertou"),
            new PetStore("Chou-Pet", "CHOUPET", "56", "Rue Fouré", "44000", "Nantes"),
            new PetStore("Hariet & Rosie", "HARIET", "5", "Rue Voltaire", "44400", "Nantes"),
            new PetStore("Médor & Compagnie", "LISPE", "", "ZC Atoud Sud", "44400", "Rezée"),
            new PetStore("Liopé Animalerie", "LIOPE", "12", "Rue Marie Curie", "44230", "Saint-Sébastien-sur-Loire"),
    };

    public static void insertStore() {
        List<PetStore> petStores = Arrays.asList(PET_STORES);
        Service petStoreService = BuilderService.createService(NameRepository.PETSTORE);
        petStores.forEach(petStoreService::save);
        petStores.forEach(petStore -> LOGGER.trace("petStore -> {}", petStore.getName()));
    }

    public static void persistProduct() {

        Service petStoreService = BuilderService.createService(NameRepository.PETSTORE);
        Service productService = BuilderService.createService(NameRepository.PRODUCT);
        List<PetStore> petStores = petStoreService.find();
        List<Product> products = productService.find();

        for (int i = 0; i < 6; i++) {
            Set<String> codes = ProductInit.getProduct(i).stream().map(Product::getCode).collect(Collectors.toSet());
            petStores.get(i).addAllProduct(products.stream().filter(p -> codes.contains(p.getCode())).collect(Collectors.toSet()));
            petStoreService.save(petStores.get(i));
        }
    }

    public static void persitAnimal() {
        Service petStoreService = BuilderService.createService(NameRepository.PETSTORE);
        Service animalService = BuilderService.createService(NameRepository.ANIMAL);
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

    public static Set<Animal> getAnimalsInPetStores(int id) {
        if (id < 0 || id >= 6)
            return null;
        LOGGER.trace("Animalerie : {}",PET_STORES[id]);
        Service petStoreService = BuilderService.createService(NameRepository.PETSTORE);
        Set<Animal> animals =petStoreService.findByAddress(PET_STORES[id].getAddress()).getAnimals();
        animals.forEach(a->LOGGER.trace("{} appartenant à l'animalerie {}",a,a.getStore().getName()));
        return animals;
    }

}


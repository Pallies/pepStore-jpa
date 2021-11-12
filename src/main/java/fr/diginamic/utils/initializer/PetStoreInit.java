package fr.diginamic.utils.initializer;

import fr.diginamic.entities.animals.Animal;
import fr.diginamic.entities.animals.Cat;
import fr.diginamic.entities.animals.Fish;
import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.enums.Color;
import fr.diginamic.enums.FishLivEnv;
import fr.diginamic.services.BuilderService;
import fr.diginamic.services.Service;
import fr.diginamic.utils.enums.NameRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public final class PetStoreInit {

    private static final PetStore[] PET_STORES={
            new PetStore( "E.Leclerc Animalerie","LECLERC","","Bd Auguste Durand", "85600" ,"Montaigu-Vendée"),
            new PetStore( "Poulailler Direct","POULAILLER","15bis","Av. de la Vertonne", "44120" ,"Vertou"),
            new PetStore( "Chou-Pet","CHOUPET","56","Rue Fouré", "44000" ,"Nantes"),
            new PetStore( "Hariet & Rosie","HARIET","5","Rue Voltaire", "44400" ,"Nantes"),
            new PetStore( "Médor & Compagnie","LISPE","","ZC Atoud Sud", "44400" ,"Rezée"),
            new PetStore( "Liopé Animalerie","LIOPE","12","Rue Marie Curie", "44230" ,"Saint-Sébastien-sur-Loire"),
    };

    public static void insertStore(){
        List<PetStore> petStores= Arrays.asList(PET_STORES);
        Service petStoreService = BuilderService.createService(NameRepository.PETSTORE);
        petStores.forEach(petStoreService::save);
    }
}


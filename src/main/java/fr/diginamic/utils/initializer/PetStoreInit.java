package fr.diginamic.utils.initializer;

import fr.diginamic.entities.animals.Animal;
import fr.diginamic.entities.animals.Cat;
import fr.diginamic.entities.animals.Fish;
import fr.diginamic.entities.store.Address;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.enums.Color;
import fr.diginamic.enums.FishLivEnv;

import java.time.LocalDate;

public class PetStoreInit {

    PetStore[][] pepStore={
            {new PetStore( "E.Leclerc Animalerie","LECLERC","","Bd Auguste Durand", "85600" ,"Montaigu-Vendée")},
            {new PetStore( "Poulailler Direct","POULAILLER","15bis","Av. de la Vertonne", "44120" ,"Vertou")},
            {new PetStore( "Chou-Pet","CHOUPET","56","Rue Fouré", "44000" ,"Nantes")},
            {new PetStore( "Hariet & Rosie","HARIET","5","Rue Voltaire", "44400" ,"Nantes")},
            {new PetStore( "Médor & Compagnie","LISPE","","ZC Atoud Sud", "44400" ,"Rezée")},
            {new PetStore( "Liopé Animalerie","LIOPE","12","Rue Marie Curie", "44230" ,"Saint-Sébastien-sur-Loire")},
    };

    public void insertStore(){

    }
}


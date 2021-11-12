package fr.diginamic.services;

import fr.diginamic.entities.animals.Cat;
import fr.diginamic.entities.store.PetStore;
import fr.diginamic.utils.enums.NameRepository;


public final class BuilderService {

    private BuilderService() {

    }

    @SuppressWarnings("unchecked")
    public static <T> Service<T> createService(Class<T> T ) {
        switch (NameRepository.getClassForName(T.toString())) {
            case Cat:
                return (Service<T>) new CatService();
            case Fish:
                return (Service<T>) new FishService();
            case Animal:
                return (Service<T>) new AnimalService();
            case PetStore:
                return (Service<T>) new PetStoreService();
            case Product:
                return (Service<T>) new ProductService();
            default:
                throw new IllegalStateException("Unexpected value: " + NameRepository.getClassForName(T.toString()));
        }
    }


}

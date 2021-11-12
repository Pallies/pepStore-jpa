package fr.diginamic.services;

import fr.diginamic.dao.impl.IDaoImpl;
import fr.diginamic.entities.animals.Fish;
import fr.diginamic.utils.enums.NameRepository;

public final class BuilderService {

    private BuilderService() {

    }

    public static Service createService(NameRepository name) {
        switch (name) {
            case CAT:
                return new CatService();
            case FISH:
                return new FishService();
            case ANIMAL:
                return new AnimalService();
            case PETSTORE:
                return new PetStoreService();
        }
        return null;//TODO error
    }
}

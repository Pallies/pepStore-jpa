package fr.diginamic.services;

import fr.diginamic.dao.impl.IDaoImpl;
import fr.diginamic.entities.animals.Fish;
import fr.diginamic.utils.enums.NameRepository;

import java.security.UnresolvedPermission;

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
            case PRODUCT:
                return new ProductService();
        }
        return null;
        //throw new UnsupportedOperationException();
    }
}

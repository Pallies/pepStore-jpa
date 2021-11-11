package fr.diginamic.repositories;

import fr.diginamic.dao.IDao;
import fr.diginamic.utils.enums.NameRepository;

public final class BuilderRepository<T> {

    private BuilderRepository() {
    }

    public static IDao getRepository(NameRepository name) {
        switch (name) {
            case CAT:
                return new CatRepository();
            case FISH:
                return new FishRepository();
            case PETSTORE:
                return new PetStoreRepository();
            case PRODUCT:
                return new ProductRepository();
            case ADDRESS:
                return new AddressRepository();
        }
        return null;//TODO ERROR
    }


}

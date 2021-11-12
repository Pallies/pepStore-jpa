package fr.diginamic.repositories;

import fr.diginamic.utils.enums.NameRepository;

/**
 * The Class BuilderRepository.
 */
public final class BuilderRepository {

    /**
     * Instantiates a new builder repository.
     */
    private BuilderRepository() {
    }

    /**
     * Gets the repository.
     *
     * @param name the name
     * @return the repository
     */
    public static Repository getRepository(NameRepository name) {
        switch (name) {
            case Cat:
                return new CatRepository();
            case Fish:
                return new FishRepository();
            case PetStore:
                return new PetStoreRepository();
            case Product:
                return new ProductRepository();
            case Address:
                return new AddressRepository();
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
    }


}

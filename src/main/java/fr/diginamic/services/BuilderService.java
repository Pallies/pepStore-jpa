package fr.diginamic.services;

import fr.diginamic.dao.impl.IDaoImpl;
import fr.diginamic.utils.enums.NameRepository;

public final class BuilderService {

    private BuilderService(){

    }

    public static IDaoImpl createService(NameRepository name){
        switch (name){
            case CAT:
                return new CatService();
            case FISH:
                return new FishService();
        }
        return null;//TODO error
    }
}

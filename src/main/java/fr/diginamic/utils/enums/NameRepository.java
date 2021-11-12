package fr.diginamic.utils.enums;

import java.util.Arrays;

public enum NameRepository {
    Cat,
   Fish,
    Animal,
    PetStore,
    Product,
    Address;





    public static NameRepository getClassForName(String name) {
        String[] classSeparator = name.split("[.]");
        return NameRepository.valueOf(classSeparator[classSeparator.length-1]);
    }

}

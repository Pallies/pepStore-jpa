package fr.diginamic.utils.initializer;

import fr.diginamic.entities.store.PetStore;
import fr.diginamic.entities.store.Product;
import fr.diginamic.enums.ProdType;
import fr.diginamic.services.BuilderService;
import fr.diginamic.services.Service;
import fr.diginamic.utils.enums.NameRepository;

import java.util.*;

public final class ProductInit {

    private static final Product[] PRODUCTS_1 = {
            new Product("0101234567890128TEC-IT", "Arbre A Chat Batik", ProdType.ACCESSORY, 49.30D),
            new Product("0101GH4567890128TE0-IT", "Barquette Chien Kippy 150G", ProdType.FOOD, 9.30D),
            new Product("010123456SE901237EC-IT", "Barquette Pour Chat Kippy 100g", ProdType.FOOD, 4.56D),
            new Product("010642365SE901237EC-IT", "Brosse carde Pour Chiens et Chat", ProdType.CLEANING, 4.56D),
            new Product("0J85769012301248T34-GM", "Brosse En Caoutchouc Pour Chiens", ProdType.CLEANING, 5.68D),
    };
    private static final Product[] PRODUCTS_2 = {
            new Product("0101GH4567890128TE0-IT", "Barquette Chien Kippy 150G", ProdType.FOOD, 9.30D),
            new Product("010123456SE901237EC-IT", "Barquette Pour Chat Kippy 100g", ProdType.FOOD, 4.56D),
            new Product("0J56789012301248T34-GM", "Boite Pour Chat Kippy 400g", ProdType.FOOD, 7.68D),
            new Product("0173456VBN101228T2C-DF", "Boite Brit Premium By Nature", ProdType.FOOD, 12.70D),
            new Product("0101GH4567890128TE0-IT", "Brosse Carde Ferplast", ProdType.CLEANING, 9.30D),
            new Product("010642365SE901237EC-IT", "Brosse carde Pour Chiens Et Chat", ProdType.CLEANING, 4.56D),
            new Product("0J85769012301248T34-GM", "Brosse En Caoutchouc Pour Chiens", ProdType.CLEANING, 5.68D),
            new Product("0173456VBN101228T2C-DF", "Couverture pour voiture Beeztees", ProdType.CLEANING, 129.70D),
    };
    private static final Product[] PRODUCTS_3 = {
            new Product("0101234567890128TEC-IT", "Arbre A Chat Batik", ProdType.ACCESSORY, 49.30D),
            new Product("1631234567890136276-FR", "Arbre A Chat screw", ProdType.ACCESSORY, 89.90D),
            new Product("0189012801234567T90-BL", "Arbre A Chat Tom", ProdType.ACCESSORY, 67.80D),
            new Product("0101GH4567890128TE0-IT", "Brosse Carde Ferplast", ProdType.CLEANING, 9.30D),
            new Product("010642365SE901237EC-IT", "Brosse carde Pour Chiens Et Chat", ProdType.CLEANING, 4.56D),
            new Product("0J85769012301248T34-GM", "Brosse En Caoutchouc Pour Chiens", ProdType.CLEANING, 5.68D),
            new Product("0173456VBN101228T2C-DF", "Couverture pour voiture Beeztees", ProdType.CLEANING, 129.70D),
    };
    private static final Product[] PRODUCTS_4 = {
            new Product("0101234567890128TEC-IT", "Arbre A Chat Batik", ProdType.ACCESSORY, 49.30D),
            new Product("1631234567890136276-FR", "Arbre A Chat screw", ProdType.ACCESSORY, 89.90D),
            new Product("0189012801234567T90-BL", "Arbre A Chat Tom", ProdType.ACCESSORY, 67.80D),
            new Product("0101GH4567890128TE0-IT", "Barquette Chien Kippy 150G", ProdType.FOOD, 9.30D),
            new Product("010123456SE901237EC-IT", "Barquette Pour Chat Kippy 100g", ProdType.FOOD, 4.56D),
            new Product("0J56789012301248T34-GM", "Boite Pour Chat Kippy 400g", ProdType.FOOD, 7.68D),
            new Product("0173456VBN101228T2C-DF", "Boite Brit Premium By Nature", ProdType.FOOD, 12.70D),
    };
    private static final Product[] PRODUCTS_5 = {
            new Product("0101234567890128TEC-IT", "Arbre A Chat Batik", ProdType.ACCESSORY, 49.30D),
            new Product("0189012801234567T90-BL", "Arbre A Chat Tom", ProdType.ACCESSORY, 67.80D),
            new Product("0101GH4567890128TE0-IT", "Barquette Chien Kippy 150G", ProdType.FOOD, 9.30D),
            new Product("010123456SE901237EC-IT", "Barquette Pour Chat Kippy 100g", ProdType.FOOD, 4.56D),
            new Product("0J56789012301248T34-GM", "Boite Pour Chat Kippy 400g", ProdType.FOOD, 7.68D),
            new Product("0101GH4567890128TE0-IT", "Brosse Carde Ferplast", ProdType.CLEANING, 9.30D),
            new Product("010642365SE901237EC-IT", "Brosse carde Pour Chiens Et Chat", ProdType.CLEANING, 4.56D),
            new Product("0173456VBN101228T2C-DF", "Couverture pour voiture Beeztees", ProdType.CLEANING, 129.70D),
    };
    private static final Product[] PRODUCTS_6 = {
            new Product("0101234567890128TEC-IT", "Arbre A Chat Batik", ProdType.ACCESSORY, 49.30D),
            new Product("1631234567890136276-FR", "Arbre A Chat screw", ProdType.ACCESSORY, 89.90D),
            new Product("010123456SE901237EC-IT", "Barquette Pour Chat Kippy 100g", ProdType.FOOD, 4.56D),
            new Product("0J56789012301248T34-GM", "Boite Pour Chat Kippy 400g", ProdType.FOOD, 7.68D),
            new Product("0101GH4567890128TE0-IT", "Brosse Carde Ferplast", ProdType.CLEANING, 9.30D),
            new Product("0J85769012301248T34-GM", "Brosse En Caoutchouc Pour Chiens", ProdType.CLEANING, 5.68D),
            new Product("0173456VBN101228T2C-DF", "Couverture pour voiture Beeztees", ProdType.CLEANING, 129.70D),
    };

    public static void insertProduct() {
        List<Product> products1 = Arrays.asList(PRODUCTS_1);
        List<Product> products2 = Arrays.asList(PRODUCTS_2);
        List<Product> products3 = Arrays.asList(PRODUCTS_3);
        List<Product> products4 = Arrays.asList(PRODUCTS_4);
        List<Product> products5 = Arrays.asList(PRODUCTS_5);
        List<Product> products6 = Arrays.asList(PRODUCTS_6);
        Set<Product> products = new HashSet<>();
        products.addAll(products1);
        products.addAll(products2);
        products.addAll(products3);
        products.addAll(products4);
        products.addAll(products5);
        products.addAll(products6);
        Service<Product> productService = BuilderService.createService(Product.class);
        products.forEach(productService::save);
    }

    public static Set<Product> getProduct(int rang) {
        Set<Product> products = new HashSet<>();
        switch (rang) {
            case 0:
                products.addAll(Arrays.asList(PRODUCTS_1));
                break;
            case 1:
                products.addAll(Arrays.asList(PRODUCTS_2));
                break;
            case 2:
                products.addAll(Arrays.asList(PRODUCTS_3));
                break;
            case 3:
                products.addAll(Arrays.asList(PRODUCTS_4));
                break;
            case 4:
                products.addAll(Arrays.asList(PRODUCTS_5));
                break;
            case 5:
                products.addAll(Arrays.asList(PRODUCTS_6));
                break;
        }
        return products;
    }
}


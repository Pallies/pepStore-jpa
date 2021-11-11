package fr.diginamic.enums;

public enum ProdType {
    FOOD("Nourriture"),
    ACCESSORY("Accessoire"),
    CLEANING("Nettoyage");

    private String productType;

    ProdType(String productType) {
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Produit de type : ");
        return sb.append(productType).toString();
    }
}

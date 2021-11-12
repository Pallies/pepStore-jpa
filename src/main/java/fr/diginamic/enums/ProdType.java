package fr.diginamic.enums;

/**
 * The Enum ProdType.
 */
public enum ProdType {
    
    /** The food. */
    FOOD("Nourriture"),
    
    /** The accessory. */
    ACCESSORY("Accessoire"),
    
    /** The cleaning. */
    CLEANING("Nettoyage");

    /** The product type. */
    private String productType;

    /**
     * Instantiates a new prod type.
     *
     * @param productType the product type
     */
    ProdType(String productType) {
        this.productType = productType;
    }

    /**
     * Gets the product type.
     *
     * @return the product type
     */
    public String getProductType() {
        return productType;
    }

    /**
     * Sets the product type.
     *
     * @param productType the new product type
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Produit de type : ");
        return sb.append(productType).toString();
    }
}

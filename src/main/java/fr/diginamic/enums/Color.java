package fr.diginamic.enums;

/**
 * The Enum Color.
 */
public enum Color {
    
    /** The chocolat. */
    CHOCOLAT("chocolat"),
    
    /** The lilas. */
    LILAS("lilas"),
    
    /** The cannelle. */
    CANNELLE("canelle"),
    
    /** The fauve. */
    FAUVE("fauve"),
    
    /** The roux. */
    ROUX("roux"),
    
    /** The creme. */
    CREME("creme"),
    
    /** The noir. */
    NOIR("noir"),
    
    /** The blanc. */
    BLANC("blanc"),
    
    /** The bleu. */
    BLEU("bleu"),
    
    /** The rouge. */
    ROUGE("rouge"),
    
    /** The jaune. */
    JAUNE("jaune"),
    
    /** The bicolor. */
    BICOLOR("bicolor");

    /** The color. */
    private String color;

    /**
     * Instantiates a new color.
     *
     * @param color the color
     */
    Color(String color) {
        this.color = color;
    }

    /**
     * Gets the color.
     *
     * @param id the id
     * @return the color
     */
    public static Color getColor(int id) {
        return Color.values()[id];
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" de couleur : ");
        return sb.append(color).toString();
    }
}

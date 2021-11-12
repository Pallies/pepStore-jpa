package fr.diginamic.enums;

/**
 * The Enum FishLivEnv.
 */
public enum FishLivEnv {
    
    /** The fresh water. */
    FRESH_WATER("eau douce"),
    
    /** The sea water. */
    SEA_WATER("eau de mer");

    /** The environnement. */
    private String environnement;

    /**
     * Instantiates a new fish liv env.
     *
     * @param environnement the environnement
     */
    FishLivEnv(String environnement) {
        this.environnement = environnement;
    }

    /**
     * Gets the environnement.
     *
     * @return the environnement
     */
    public String getEnvironnement() {
        return environnement;
    }

    /**
     * Sets the environnement.
     *
     * @param environnement the new environnement
     */
    public void setEnvironnement(String environnement) {
        this.environnement = environnement;
    }

    /**
     * Gets the env.
     *
     * @param id the id
     * @return the env
     */
    public static FishLivEnv getEnv(int id) {
        return FishLivEnv.values()[id];
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return " Poisson(s) d' " + environnement;
    }
}

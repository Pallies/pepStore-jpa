package fr.diginamic.enums;

public enum FishLivEnv {
    FRESH_WATER("eau douce"),
    SEA_WATER("eau de mer");

    private String environnement;

    FishLivEnv(String environnement) {
        this.environnement=environnement;
    }

    public String getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(String environnement) {
        this.environnement = environnement;
    }

    @Override
    public String toString() {
        return " Poisson(s) d' " + environnement;
    }
}

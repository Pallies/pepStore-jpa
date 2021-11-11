package fr.diginamic.enums;

public enum Color {
    CHOCOLAT("chocolat"),
    LILAS("lilas"),
    CANNELLE("canelle"),
    FAUVE("fauve"),
    ROUX("roux"),
    CREME("creme"),
    NOIR("noir"),
    BLANC("blanc"),
    BLEU("bleu"),
    ROUGE("rouge"),
    JAUNE("jaune"),
    BICOLOR("bicolor");

    private String color;

    Color(String color) {
        this.color = color;
    }
}
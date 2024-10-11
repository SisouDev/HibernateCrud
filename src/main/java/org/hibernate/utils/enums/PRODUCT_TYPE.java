package org.hibernate.utils.enums;

public enum PRODUCT_TYPE {
    BOOKS("Books"),
    GAMES("Games"),
    MOVIES("Movies"),
    SERIES("Series"),
    ANIMES("Animes");

    private String description;
    private PRODUCT_TYPE(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

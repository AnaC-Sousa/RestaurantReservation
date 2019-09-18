package com.restaurante.restaurante.domain.menu;

public enum SpiceLevel {
    LOW(1),
    MEDIUM(2),
    MAX(3);

    int spiceLevel;
    SpiceLevel(int spiceLevel){
        this.spiceLevel = spiceLevel;
    }
}

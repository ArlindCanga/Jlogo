package it.unicam.cs.pa.jlogo.model;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

/**
 * Enumeratore per segnare il tipo di figura disegnato
 */
public enum shapeEnum {
    /**
     * Area di disegno
     */
    SIZE("SIZE"),
    /**
     * Segmento
     */
    LINE("LINE"),
    /**
     * Poligono chiuso da 3 o più segmenti
     */
    POLYGON("POLYGON"),
    /**
     * Descrive le linee di un poligono
     */
    EMPTY("");

    private final String shapeEn;
    shapeEnum(String shape){
        this.shapeEn = shape;
    }

    @Override
    public String toString(){
        return this.shapeEn;
    }
}

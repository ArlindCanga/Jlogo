package it.unicam.cs.pa.jlogo.model.intLogic;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.shapeEnum;

/**
 * descrive segmenti e figure chiuse
 */
public interface IShape {
    /**
     * dato un oggetto Shape ritorna il suo tipo di figura
     * @return il tipo di figura
     */
    shapeEnum getShapeType();

    /**
     * Cambia il tipo di figura
     * @param shape
     */
    void setShapeType(shapeEnum shape);
}

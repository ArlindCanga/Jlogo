package it.unicam.cs.pa.jlogo.model.intLogic;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.coordinates;

/**
 * Descrive un segmento
 */
public interface ILine extends IShape {
    /**
     * Descrive la dimensione del segmento
     * @return size
     */
    int getSize();

    /**
     * restituisce le cordinate di un segmento
     * @return lineCoordinates
     */
    coordinates getCoordinate();

    /**
     * Restituisce la lunghezza di un segmento
     */
    double getLineLength();

}

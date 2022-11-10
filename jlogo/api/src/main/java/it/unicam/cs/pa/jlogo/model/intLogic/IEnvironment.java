package it.unicam.cs.pa.jlogo.model.intLogic;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */


import it.unicam.cs.pa.jlogo.model.coordinates;
import it.unicam.cs.pa.jlogo.model.lineEnum;

import java.awt.Color;
import java.util.List;

/**
 * Descrive un ambiente di disegno
 * Si occupa di gestire i vari oggetto dentro una finestra di disegno.
 * Analizza e crea figure
 */
public interface IEnvironment extends IShape {
    /**
     * Restituisce l'altezza dell'area di disegno
     * @return Height
     */
    int getHeight();

    /**
     * Restituisce la larghezza dell'area di disegno
     * @return Width
     */
    int getWidth();

    /**
     * Restituisce il colore di sfondo dell'area di disegno
     */
    Color getBackgroundColor();

    /**
     * Imposta il colore di sfondo dell'area di disegno
     * @param backgroundColor è il nuovo colore dell'area di disegno
     */
    void setBackgroundColor(Color backgroundColor);

    /**
     * Aggiunge un segmento nell'area di disegno
     * @param segCord, cordinate del segmento da aggiungere
     * @param cursor, Cursore
     * @param lineType, tipo di segmento
     */
    void addLine(coordinates segCord, ITurtle cursor, lineEnum lineType);

    /**
     * Restituisce una lista dei segmenti che non formano una figura chiusa
     * @return List<? extends Line> segments
     */
    List<ILine> getSegments();

    /**
     * Restituisce una lista delle aree chiuse
     * @return List<? extends Polygon> Polygons
     */
    List<IPolygon> getPolygons();

    /**
     * Dato un Cursore di cordinata x,y se è dentro un area chiusa cambia il colore di sfondo dell'area
     * @return true se l'area è chiusa, false altrimenti
     */
    boolean setFillColor(ITurtle cursor, Color closedColor);
}

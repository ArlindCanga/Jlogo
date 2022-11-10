package it.unicam.cs.pa.jlogo.model.intLogic;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import java.awt.Color;
import java.util.List;

/**
 * Questa interfaccia rappresenta figure chiuse.
 *
 */
public interface IPolygon extends IShape {
    /**
     * Dato una figura chiusa ritorna una lista dei suoi segmenti
     * @return una lista di Line che formano il poligono
     */
    List<ILine> getPolygonLines();

    /**
     * Descrive il numero totale di un poligono
     * @return N lines
     */
    int totLines();

    /**
     * Restituisce il colore di background di un poligono
     * @return colore di background del poligono
     */
    Color getPolygonColor();

    /**
     * setta il colore di un area chiusa
     * @param closedAreaColor colore dell'area chiusa
     */
    void setPolygonColor(Color closedAreaColor);


    /**
     * Aggiunge un segmento di tipo Empty al poligono
     * @param line segmento da aggiungere
     */
    void addSegment(ILine line);

    /**
     * Dato un segmento ed una lista dei segmenti esistenti,
     * questo metodo verifica se, disegnando il segmento, viene formato un Poligono a partire dalla lista
     * gia' esistente dei segmenti
     * @param segment, segmento da aggiungere
     * @param segments, lista dei segmenti attuali
     */
    void createPolygon(ILine segment, List<ILine> segments, List<IPolygon> polygons);

    /**
     * Dato un segmento ed una lista di segmenti, controlla che questi formino un triangolo.
     * @param segment segmento da aggiungere
     * @param segments lista da controllare
     * @return true se forma un segmento, false altrimenti
     */
    boolean checkIfPolygon(ILine segment, List<ILine> segments);

    /**
     * Dato una cordinata x,y valuta se questo è all'interno del poligono
     * @param x
     * @param y
     * @return true se dentro, false altrimenti
     */
    boolean pointIntoPolygon(double x, double y);

    String toString();
}

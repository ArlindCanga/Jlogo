package it.unicam.cs.pa.jlogo.model.intLogic;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.Angle;
import it.unicam.cs.pa.jlogo.model.aPosition;

import java.awt.Color;

/**
 * Descrive il cursore e i suoi movimenti
 */
public interface ITurtle {
    /**
     * Restituisce la posizione attuale del cursore
     * @return CursorPosition
     */
    aPosition getCurrentPosition();

    /**
     * Setta la posizione del cursore
     * @param x
     */
    void setCurrentPosition(double x, double y);

    /**
     * Definisce la posizione di HOME di default (base/2, altezza/2)
     */
    void setHome(double x, double y);

    /**
     * Restituisce l'angolo (direzione) del cursore
     * @return angle [0...360]
     */
    Angle getAngle();

    /**
     * setta l'angolazione del cursore
     * @param i gradi da settare
     */
    void setAngle(int i);

    /**
     * Metodo utili per la rotazione del cursore
     * @param i, gradi da ruotare
     */
    void rotateLeft(double i);
    void rotateRight(double i);

    /**
     * Restituisce il colore del segmento
     * @return penColor
     */
    Color getpenColor();

    /**
     * Setta il colore del segmento
     * @param penColor colore rgb da impostare
     */
    void setpenColor(Color penColor);

    /**
     * restituisce la dimensione della penna
     * @return penSize
     */
    int getPenSize();

    /**
     * setta la dimensione della penna
     * @param i, pen size
     */
    void setPenSize(int i);

    /**
     * Restituisce lo stato della penna
     * @return true se scrive, false altrimenti
     */
    boolean getPlot();

    /**
     * Modifica lo stato della penna
     * @param plotParam
     */
    void setPlot(boolean plotParam);
}

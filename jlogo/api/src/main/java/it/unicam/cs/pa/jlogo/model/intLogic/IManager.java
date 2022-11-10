package it.unicam.cs.pa.jlogo.model.intLogic;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.Tokens.abstractToken;

import java.awt.Color;
import java.util.List;

/**
 * Questa interfaccia indirizza i comandi dell'utente
 */
public interface IManager {

    void execute(List<abstractToken> tokensToExecute);
    /**
     * sposta il cursore in avanti
     * @param dist distanza da percorrere
     * @return true se possibile, false altrimenti
     */
    void goForward(double dist);
    /**
     * sposta il cursore indietro
     * @param dist distanza da percorrere
     * @return true se possibile, false altrimenti
     */
    void goBackward(double dist);

    /**
     * ruota il cursore verso sinistra
     * @param angle gradi da ruotare
     */
    void rotateLeft(double angle);

    /**
     * ruota il cursore verso destra
     * @param angle gradi da ruotare
     */
    void rotateRight(double angle);

    /**
     * cancella quanto disegnato
     */
    void clearScreen();

    /**
     * sposta il cursore nella home
     */
    void home();

    /**
     * stacca la penna dal foglio
     */
    void penUp();

    /**
     * attacca la penna al foglio
     */
    void penDown();

    /**
     * Imposta il colore della penna
     * @param penColor, Colore RGB della penna
     */
    void setPenColor(Color penColor);

    /**
     *Imposta il colore di un area chiusa
     * Da settare mentra si disegna, nel momento in cui si forma un area chiusa prenderà questo colore
     * @param fillColor, Colore RGB di riempimento
     */
    void setFillColor(Color fillColor);

    /**
     *Imposta il colore dell'area di disegno
     * @param screenColor, Colore RGB di riempimento
     */
    void setScreenColor(Color screenColor);

    /**
     * Imposta la dimensione della penna
     * @param penSize
     */
    void setPenSize(int penSize);


    /**
     * Ritorna una stringa del risultato dell'esecuzione
     * @return
     */
    String result();

    /**
     * Salva il risultato del disegno su un file
     * @param Path dove salvare il file
     */
    boolean saveFile(String Path);
}

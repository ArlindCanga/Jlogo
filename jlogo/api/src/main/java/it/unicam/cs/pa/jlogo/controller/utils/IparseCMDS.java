package it.unicam.cs.pa.jlogo.controller.utils;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.Tokens.abstractToken;

import java.util.List;

/**
 * formatta una stringa in modo che sia leggibile dall'interpreter
 */
public interface IparseCMDS {
    /**
     * Prende una stringa, esegue il parse ed aggiunge il comando alla lista
     * @param strToParse stringa da parsare
     */
    void parse(String strToParse);

    /**
     * restituisce la lista dei token
     * @return List<abstractToken>
     */
    List<abstractToken> getTokenList();

    /**
     * svuota la lista dei token
     */
    void deleteTokens();
}

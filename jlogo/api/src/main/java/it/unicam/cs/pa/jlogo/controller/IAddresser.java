package it.unicam.cs.pa.jlogo.controller;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.Tokens.abstractToken;

import java.util.List;

/**
 * Interfaccia che fa da tramite tra View e Model
 */
public interface IAddresser {
    /**
     * Delega l'esecuzione dei comandi
     */
    void execute(List<abstractToken> tokenList);
}

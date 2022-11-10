package it.unicam.cs.pa.jlogo.controller;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.controller.utils.reader;
import it.unicam.cs.pa.jlogo.model.Tokens.abstractToken;
import it.unicam.cs.pa.jlogo.model.intLogic.IManager;
import it.unicam.cs.pa.jlogo.model.orchestrator;

import java.util.List;

/**
 * Classe che fa da tramite tra il controller ed il model
 */
public class sender implements IAddresser {
    IManager modelManager;
    reader fileReader;

    public sender(){
        this.modelManager = new orchestrator();
    }

    @Override
    public void execute(List<abstractToken> tokenList) {
        this.modelManager.execute(tokenList);
    }
}

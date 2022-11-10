package it.unicam.cs.pa.jlogo.View;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.exit;


/**
 * Questa classe prende i comandi dall'utente
 */
public class LogoMain {
    public static void main(String[] args) throws IOException {
        //mi aspetto un path per un file di comandi
        if (args.length >= 1){
            new userInterpreter(args[0]);
        } else {
            new userInterpreter();
        }
        exit(0);
    }
}

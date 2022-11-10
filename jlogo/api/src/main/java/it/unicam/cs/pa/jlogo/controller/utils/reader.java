package it.unicam.cs.pa.jlogo.controller.utils;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */
import it.unicam.cs.pa.jlogo.model.Tokens.abstractToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.List;


/**
 * Classe utile per leggere da un file
 */
public class reader {
    IparseCMDS parserList;

    public reader(String pathFile) throws IOException {
        pathFile = pathFile.replace("\\", "/");
        if (!this.checkPath(pathFile))
            throw new IllegalArgumentException("Path non corretto");
        parserList = new cmdsParser();
        this.readAndTokenize(pathFile);
    }

    public List<abstractToken> getTokens(){
        return parserList.getTokenList();
    }

    private boolean checkPath(String path){
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }

    private void readAndTokenize(String pathFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(pathFile));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        parserList.parse(line);
    }

}

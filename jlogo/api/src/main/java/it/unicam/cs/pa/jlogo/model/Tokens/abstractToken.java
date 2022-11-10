package it.unicam.cs.pa.jlogo.model.Tokens;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

/**
 * Classe che rappresenta un token
 * Formato da un String tokenId ed un generico parametro T
 */
public abstract class abstractToken<T> {
    private String tokenId;
    private T param;

    public abstractToken(String tokenName){
        this.tokenId = tokenName;
    }
    public abstractToken(String tokenName, T genericParam){
        this.tokenId = tokenName;
        this.param = genericParam;
    }

    public String getTokenId(){
        return tokenId;
    }

    public T getParam(){
        if (this.param != null)
            return this.param;
        return null;
    }
}

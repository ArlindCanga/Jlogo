package it.unicam.cs.pa.jlogo.model.Tokens;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

public class stringToken extends abstractToken {
    private String tokenValue;

    public stringToken(String tokenName, String value){
        super(tokenName,value);
        this.tokenValue = value;
    }
}

package it.unicam.cs.pa.jlogo.model.Tokens;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */


public class numbersToken extends abstractToken {
    private Number tokenValue;

    public numbersToken(String tokenName, Number value){
        super(tokenName,value);
        this.tokenValue = value;
    }

}

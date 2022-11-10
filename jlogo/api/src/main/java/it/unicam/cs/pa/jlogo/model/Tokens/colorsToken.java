package it.unicam.cs.pa.jlogo.model.Tokens;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import java.awt.*;

public class colorsToken extends abstractToken {
    public colorsToken(String tokenName, Color color) {
        super(tokenName, color);
    }
}

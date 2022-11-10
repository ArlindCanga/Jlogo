package it.unicam.cs.pa.jlogo;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.Tokens.abstractToken;
import it.unicam.cs.pa.jlogo.model.Tokens.numbersToken;
import org.junit.jupiter.api.Test;

public class tokenTests {
    @Test
    void checkTypes(){
        double val = 10.7;
        abstractToken test = new numbersToken("FORWARD", val);
        Number testNum = (Number) test.getParam();
        int i = 1;
    }
}

package it.unicam.cs.pa.jlogo;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.controller.utils.IparseCMDS;
import it.unicam.cs.pa.jlogo.controller.utils.cmdsParser;
import it.unicam.cs.pa.jlogo.model.Tokens.abstractToken;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class parserTest {
    @Test
    void checkRepeat(){
        String str = "ripeti 5 [ ripeti 4 [ forward 50 ] ]";
        IparseCMDS testParser = new cmdsParser();
        testParser.parse(str);
        List<abstractToken> testList = testParser.getTokenList();
        assertEquals(testList.size(), 20);
        str = "ripeti 2 [ forward 50 ]";
        testParser.deleteTokens();
        testParser.parse(str);
        testList = testParser.getTokenList();
        assertEquals(testList.size(), 2);
        str = "ripeti 2 [ ripeti 5 [ ripeti 10 [ forward 50 ] ] ]";
        testParser.deleteTokens();
        testParser.parse(str);
        testList = testParser.getTokenList();
        assertEquals(testList.size(), 100);
    }
}

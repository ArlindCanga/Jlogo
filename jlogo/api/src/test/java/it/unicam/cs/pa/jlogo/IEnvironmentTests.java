package it.unicam.cs.pa.jlogo;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */
import static org.junit.jupiter.api.Assertions.*;

import it.unicam.cs.pa.jlogo.model.*;
import it.unicam.cs.pa.jlogo.model.intLogic.IEnvironment;
import it.unicam.cs.pa.jlogo.model.intLogic.ITurtle;
import org.junit.jupiter.api.Test;

import java.awt.*;


public class IEnvironmentTests {
    @Test
    void testParams(){
        assertThrows(NullPointerException.class, () -> new DrawingArea(100, 100, null));
        assertThrows(IllegalArgumentException.class, () -> new DrawingArea(0, 0, Color.white));
    }

    @Test
    void testAttribute(){
        IEnvironment testEnv = new DrawingArea(500, 400, Color.white);
        assertTrue(testEnv.getBackgroundColor() == Color.white);
        testEnv.setBackgroundColor(Color.BLACK);;
        assertTrue(testEnv.getBackgroundColor() == Color.BLACK);
        assertTrue(testEnv.getHeight() == 400);
        assertTrue(testEnv.getWidth() == 500);
    }

    @Test
    void testsetFillColor(){
        // Creo un poligono di 3 lati e provo a colorarlo
        IEnvironment testEnv = new DrawingArea(500, 400, Color.white);
        ITurtle wkCursor = new turtleCursor();
        wkCursor.setpenColor(Color.BLACK);
        coordinates cord1 = new coordinates(0,1,2,1);
        wkCursor.setCurrentPosition(2, 1);
        testEnv.addLine(cord1, wkCursor, null);
        coordinates cord2 = new coordinates(2,1,2,3);
        wkCursor.setCurrentPosition(2, 3);
        testEnv.addLine(cord2 , wkCursor, null);
        coordinates cord3 = new coordinates(2,3,0,1);
        wkCursor.setCurrentPosition(0, 1);
        testEnv.addLine(cord3, wkCursor, null);
        wkCursor.setCurrentPosition(1.5, 2);
        testEnv.setFillColor(wkCursor, Color.BLUE);
        assertTrue(testEnv.getPolygons().get(0).getPolygonColor() == Color.BLUE);
        wkCursor.setCurrentPosition(2.1, 1.1);
        testEnv.setFillColor(wkCursor, Color.RED);
        assertFalse(testEnv.getPolygons().get(0).getPolygonColor() == Color.RED);
    }
}

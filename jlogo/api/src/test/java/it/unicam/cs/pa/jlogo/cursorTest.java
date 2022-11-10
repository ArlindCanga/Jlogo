package it.unicam.cs.pa.jlogo;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */
import it.unicam.cs.pa.jlogo.model.intLogic.ITurtle;
import it.unicam.cs.pa.jlogo.model.turtleCursor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class cursorTest {
    @Test
    void testRotation(){
        ITurtle cursorToTest = new turtleCursor();
        cursorToTest.setCurrentPosition(50,50);
        assertTrue(cursorToTest.getAngle().getAngleDirection() == 0);
        cursorToTest.rotateRight(450);
        assertTrue(cursorToTest.getAngle().getAngleDirection() == 90);
        cursorToTest.rotateLeft(180);
        assertTrue(cursorToTest.getAngle().getAngleDirection() == 270);
        cursorToTest.rotateLeft(360);
        assertTrue(cursorToTest.getAngle().getAngleDirection() == 270);
        cursorToTest.rotateLeft(180);
        assertTrue(cursorToTest.getAngle().getAngleDirection() == 90);
        cursorToTest.rotateRight(450);
        assertTrue(cursorToTest.getAngle().getAngleDirection() == 180);
    }
}

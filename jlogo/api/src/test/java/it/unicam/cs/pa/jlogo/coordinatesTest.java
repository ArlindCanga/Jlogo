package it.unicam.cs.pa.jlogo;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */
import it.unicam.cs.pa.jlogo.model.coordinates;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class coordinatesTest {
    private static coordinates cord, cord1, cord2, cord3;
    @BeforeAll
    static void init(){
        cord = new coordinates(0,1,3,1);
        cord1 = new coordinates(3,1,3,3);
        cord2 = new coordinates(3,3,0,1);
        cord3 = new coordinates(5,1,6,8);
    }
    @Test
    void testLength(){
        assertEquals(cord.getLength(), 3);
    }

    @Test
    void testIntersections(){
        assertTrue(cord.intersectTail(cord1));
        assertTrue(cord.intersectHead(cord2));
        assertFalse(cord.intersectHead(cord3));
        assertFalse(cord.intersectTail(cord3));
    }
}

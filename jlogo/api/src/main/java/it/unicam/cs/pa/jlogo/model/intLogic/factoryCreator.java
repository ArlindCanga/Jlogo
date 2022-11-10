package it.unicam.cs.pa.jlogo.model.intLogic;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.Segment;
import it.unicam.cs.pa.jlogo.model.coordinates;
import it.unicam.cs.pa.jlogo.model.lineEnum;
import it.unicam.cs.pa.jlogo.model.trianglePolygon;

import java.util.ArrayList;
import java.util.List;

/**
 * Interfaccia che ha la responsabilità di creare poligoni o Linee.
 * E' utile nel caso in cui si voglia introdurre un nuovo Poligono o delle Linee che non sono rette (curve o archi).
 */
public interface factoryCreator {
    /**
     * Per implementare Poligoni basta estendere la classe astratta 'abstractClosedPolygon' (creando quindi un nuovo oggetto)
     * e fare un add nella lista dentro il metodo con il nuovo oggetto da istanziare.
     * @return List<Polygon> dei poligoni da considerare.
     */
    static List<IPolygon> polygonsCreator(){
        List<IPolygon> polygons = new ArrayList<>();
        polygons.add(new trianglePolygon()); //Poligono di 3 lati
        return polygons;
    }

    /**
     * La classe Segment(che implementa Line) fornisce un campo per definire il tipo di segmento
     * che vogliamo utilizzare.
     * Per implementare nuovi segmenti basta specificare il tipo di Segment che vogliamo considerare tramite
     * l'enumeratore @lineEnum; altrimenti estendere l'interfaccia Line.
     * @param cord
     * @param cursor
     * @param str
     * @return
     */
    static ILine linesCreator(coordinates cord, ITurtle cursor, lineEnum str){
        if (str == null){
            str = lineEnum.STRAIGHT;
        }
        switch (str){
            default:
            case STRAIGHT:
                return new Segment(cord, cursor.getpenColor(), cursor.getPenSize());
        }
    }
}

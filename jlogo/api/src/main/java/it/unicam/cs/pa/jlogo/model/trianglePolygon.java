package it.unicam.cs.pa.jlogo.model;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.intLogic.ILine;
import it.unicam.cs.pa.jlogo.model.intLogic.IPolygon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class trianglePolygon extends abstractClosedPolygon{

    public trianglePolygon(){
        super(3);
    }

    public boolean checkIfPolygon(ILine segment, List<ILine> segments) {
        List<ILine> polygonCheck = this.createPolygonTriangleList(segment, segments);
        for (ILine seg : polygonCheck){
            if (seg.getCoordinate().sameCord(segment.getCoordinate()))
                return false;
        }
        if (polygonCheck.size() == super.totLines() - 1)
            return true;
        return false;
    }

    public void createPolygon(ILine segment, List<ILine> segments, List<IPolygon> polygons){
        List<ILine> polygonToCreate = this.createPolygonTriangleList(segment, segments);
        if (polygonToCreate.size() == super.totLines() - 1){
            super.addSegment(segment);
            polygonToCreate.forEach(line -> {
                super.addSegment(line);
                segments.remove(line);
            });
            polygons.add(this);
            System.out.println("Formato un Poligono:" + "\n" + super.toString());
        }
    }

    public boolean pointIntoPolygon(double x, double y) {
        //prendo il punto in questione e calcolo 1 area diversa per ogni lato del triangolo
        //se la somma delle "mini" aree è uguale alla somma totale vuol dire che il punto è dentro il poligono
        List<ILine> polygonLines = super.getPolygonLines();
        double triangleArea = this.triangleErone(polygonLines.get(0).getLineLength(),
                polygonLines.get(1).getLineLength(), polygonLines.get(2).getLineLength());
        coordinates segCord1 = new coordinates(polygonLines.get(0).getCoordinate().getX1(), polygonLines.get(0).getCoordinate().getY1(), x, y);
        coordinates segCord12 = new coordinates(x, y, polygonLines.get(0).getCoordinate().getX2(), polygonLines.get(0).getCoordinate().getY2());
        double miniTriangleArea1 = this.triangleErone(segCord1.getLength(), segCord12.getLength(),polygonLines.get(0).getLineLength());
        coordinates segCord2 = new coordinates(polygonLines.get(1).getCoordinate().getX1(), polygonLines.get(1).getCoordinate().getY1(), x, y);
        coordinates segCord22 = new coordinates(x, y, polygonLines.get(1).getCoordinate().getX2(), polygonLines.get(1).getCoordinate().getY2());
        double miniTriangleArea2 = this.triangleErone(segCord2.getLength(), segCord22.getLength(),polygonLines.get(1).getLineLength());
        coordinates segCord3 = new coordinates(polygonLines.get(2).getCoordinate().getX1(), polygonLines.get(2).getCoordinate().getY1(), x, y);
        coordinates segCord32 = new coordinates(x, y, polygonLines.get(2).getCoordinate().getX2(), polygonLines.get(2).getCoordinate().getY2());
        double miniTriangleArea3 = this.triangleErone(segCord3.getLength(), segCord32.getLength(),polygonLines.get(2).getLineLength());
        return Math.abs(triangleArea - miniTriangleArea1 - miniTriangleArea2 - miniTriangleArea3) < 10e-10;
    }

    private List<ILine> getTailsIntersect(ILine segment, List<ILine> segments){
        return segments
                .stream()
                .filter(c -> (segment.getCoordinate().intersectTail(c.getCoordinate())))
                .collect(Collectors.toList());
    }

    private List<ILine> getHeadIntersect(ILine segment, List<ILine> segments){
        return segments
                .stream()
                .filter(c -> (segment.getCoordinate().intersectHead(c.getCoordinate())))
                .collect(Collectors.toList());
    }

    private List<ILine> mergeIntersects(List<ILine> segmentsTail, List<ILine> segmentsHead){
        List<ILine> finalIntersects = new ArrayList<>();
        for (ILine tail : segmentsTail){
            for (ILine head : segmentsHead){
                if ((tail.getCoordinate().intersectTail(head.getCoordinate())) || (tail.getCoordinate().intersectHead(head.getCoordinate()))){
                    finalIntersects.add(tail);
                    finalIntersects.add(head);
                    return finalIntersects;
                }
            }
        }
        return finalIntersects;
    }

    // Dati 3 segmenti restituisce l'area del triangolo seguendo la formula di Erone
    private double triangleErone(double seg1, double seg2, double seg3){
        double semiPer = (seg1 + seg2 + seg3)/2.0;
        return Math.sqrt(Math.abs(semiPer * (semiPer - seg1) * (semiPer - seg2) * (semiPer - seg3)));
    }


    private List<ILine> createPolygonTriangleList(ILine segment, List<ILine> segments) {
        List<ILine> linesTail = this.getTailsIntersect(segment, segments);
        List<ILine> linesHead = this.getHeadIntersect(segment, segments);
        List<ILine> finalLines = this.mergeIntersects(linesTail,linesHead);
        return finalLines;
    }

}

package it.unicam.cs.pa.jlogo.model;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.intLogic.ILine;
import it.unicam.cs.pa.jlogo.model.intLogic.IPolygon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class abstractClosedPolygon implements IPolygon {
    private shapeEnum polygonType = shapeEnum.POLYGON;
    private int maxLines;
    private List<ILine> polygonLines;
    private Color polygonColor;

    public abstractClosedPolygon(int maxLines){
        this.maxLines = maxLines;
        polygonLines = new ArrayList<ILine>();
        this.polygonColor = Color.WHITE;
    }
    @Override
    public List<ILine> getPolygonLines() {
        return this.polygonLines;
    }

    @Override
    public int totLines() {
        return this.maxLines;
    }

    @Override
    public Color getPolygonColor() {
        return this.polygonColor;
    }

    @Override
    public void setPolygonColor(Color closedAreaColor) {
        this.polygonColor = closedAreaColor;
    }

    @Override
    public void addSegment(ILine line) {
        line.setShapeType(shapeEnum.EMPTY);
        polygonLines.add(line);
    }

    @Override
    public shapeEnum getShapeType() {
        return this.polygonType;
    }

    @Override
    public void setShapeType(shapeEnum shape) {
        this.polygonType = shape;
    }

    @Override
    public String toString(){
        String stringToRet = this.polygonType.toString() + " " + this.totLines() + " "
                    + this.getPolygonColor().getRed() + " " + this.getPolygonColor().getGreen() + " " + this.getPolygonColor().getBlue();
        for (ILine line : polygonLines){
            stringToRet = stringToRet + "\n" + line.toString();
        }
        return stringToRet;
    }

    @Override
    public abstract boolean checkIfPolygon(ILine segment, List<ILine> segments);

    @Override
    public abstract void createPolygon(ILine segment, List<ILine> segments, List<IPolygon> polygons);

    @Override
    public abstract boolean pointIntoPolygon(double x, double y);



}

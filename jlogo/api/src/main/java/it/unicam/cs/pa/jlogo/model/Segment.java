package it.unicam.cs.pa.jlogo.model;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.intLogic.ILine;

import java.awt.Color;
import java.util.Objects;

public class Segment implements ILine {
    private shapeEnum shapeType = shapeEnum.LINE;
    private coordinates lineCoordinates;
    private Color lineColor;
    private int lineSize;

    private lineEnum lineType = lineEnum.STRAIGHT;

    public Segment(coordinates linexy, Color segColor, int size){
        this.testParam(linexy, segColor, size);
        this.lineCoordinates = linexy;
        this.lineColor = segColor;
        this.lineSize = size;
    }

    private void testParam(Object... param){
        for (Object testParam : param){
            Objects.requireNonNull(testParam);
        }
    }

    @Override
    public int getSize() {
        return this.lineSize;
    }

    @Override
    public coordinates getCoordinate() {
        return this.lineCoordinates;
    }

    @Override
    public double getLineLength() {
        return this.lineCoordinates.getLength();
    }

    @Override
    public shapeEnum getShapeType() {
        return this.shapeType;
    }

    @Override
    public void setShapeType(shapeEnum shape) {
        this.shapeType = shape;
    }

    @Override
    public String toString(){
        return (this.shapeType.toString() + " " + this.lineCoordinates.toString() + this.lineColor.getRed() + " "
                + this.lineColor.getGreen() + " " + this.lineColor.getBlue() + " " + this.getSize());
    }

}

package it.unicam.cs.pa.jlogo.model;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.intLogic.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DrawingArea implements IEnvironment {
    private shapeEnum areaType = shapeEnum.SIZE;
    private int width;
    private int height;
    private Color backgroundAreaColor;
    private List<ILine> lineList;
    private List<IPolygon> polygonList;
    private List<IPolygon> polygonToTake;

    public DrawingArea(int x, int y, Color areaRGB){
        if (x<= 0 || y<=0){
            throw new IllegalArgumentException("Size della finestra non corretto!");
        }
        this.testParam(x,y, areaRGB);
        this.width = x;
        this.height = y;
        this.backgroundAreaColor = areaRGB;
        this.lineList = new ArrayList<>();
        this.polygonList = new ArrayList<>();
    }

    private void testParam(Object... param){
        for (Object testParam : param){
            Objects.requireNonNull(testParam);
        }
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }


    @Override
    public Color getBackgroundColor() {
        return this.backgroundAreaColor;
    }

    @Override
    public void setBackgroundColor(Color backgroundColor) {
        this.testParam(backgroundColor);
        this.backgroundAreaColor = backgroundColor;
    }

    @Override
    public void addLine(coordinates segCord, ITurtle cursor, lineEnum lineType) {
        if (cursor.getPlot()) {
            this.testParam(segCord, cursor);
            this.polygonToTake = factoryCreator.polygonsCreator();
            ILine segment = factoryCreator.linesCreator(segCord, cursor, lineType);
            boolean addedToPolygon = false;
            for (IPolygon polToTest : this.polygonToTake){
                if (polToTest.checkIfPolygon(segment, this.lineList)){
                    polToTest.createPolygon(segment, this.lineList, this.polygonList);
                    addedToPolygon = true;
                    break;
                }
            }
            if (!addedToPolygon){
                this.lineList.add(segment);
                System.out.println("Aggiunto segmento:" + "\n" + segment.toString());
            }
        }
    }

    @Override
    public List<ILine> getSegments() {
        return this.lineList;
    }

    @Override
    public List<IPolygon> getPolygons() {
        return this.polygonList;
    }

    @Override
    public boolean setFillColor(ITurtle cursor, Color closedColor) {
        boolean ret = false;
        for (IPolygon polygon : polygonList){
            if (polygon.pointIntoPolygon(cursor.getCurrentPosition().x(), cursor.getCurrentPosition().y())){
                polygon.setPolygonColor(closedColor);
                System.out.println("Area chiusa colorata correttamente!" + "\n" + polygon.toString());
                ret = true;
                break;
            }
        }
        return ret;
    }


    @Override
    public shapeEnum getShapeType() {
        return this.areaType;
    }

    @Override
    public void setShapeType(shapeEnum shape) {
        this.areaType = shape;
    }

    @Override
    public String toString(){
        String stringToRet = this.areaType.toString() + " " + this.width + " " + this.height + " "
                + this.backgroundAreaColor.getRed() + " " + this.backgroundAreaColor.getGreen() + " "
                + this.backgroundAreaColor.getBlue();
        for (ILine line : lineList){
            stringToRet = stringToRet + "\n" + line.toString();
        }
        for (IPolygon polygon : polygonList){
            stringToRet = stringToRet + "\n" + polygon.toString();
        }
        return stringToRet;
    }
}

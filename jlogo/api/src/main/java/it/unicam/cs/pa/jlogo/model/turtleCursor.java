package it.unicam.cs.pa.jlogo.model;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.intLogic.ITurtle;

import java.awt.Color;
import java.util.Objects;

public class turtleCursor implements ITurtle {
    private aPosition actualPosition;
    private Angle angle;
    private Color lineColor;
    private Color areaColor;
    private int penSize;
    private boolean Plot;

    public turtleCursor(){
        this.Plot = true;
        this.penSize = 1;
        this.lineColor = Color.black;
        this.areaColor = Color.white;
        this.setCurrentPosition(0,0);
        this.angle = new Angle();
    }

    @Override
    public aPosition getCurrentPosition() {
        return this.actualPosition;
    }

    @Override
    public void setCurrentPosition(double x, double y){
        this.actualPosition = new aPosition(x, y);
        System.out.println("Cursore spostato in " + " " + x + "," + y);
    }

    @Override
    public void setHome(double x, double y){
        this.setCurrentPosition(x, y);
    }

    @Override
    public Angle getAngle() {
        return this.angle;
    }

    @Override
    public void setAngle(int i) {
        this.angle.setAngleDirection(i);
    }

    @Override
    public void rotateLeft(double i) {
        Objects.requireNonNull(i);
        this.angle.rotateLeftDirection(i);
    }

    @Override
    public void rotateRight(double i) {
        Objects.requireNonNull(i);
        this.angle.rotateRightDirection(i);
    }

    @Override
    public Color getpenColor() {
        return this.lineColor;
    }

    @Override
    public void setpenColor(Color penColor) {
        Objects.requireNonNull(penColor);
        this.lineColor = penColor;
    }

    @Override
    public int getPenSize() {
        return this.penSize;
    }

    @Override
    public void setPenSize(int i) {
        Objects.requireNonNull(i);
        this.penSize = i;
    }

    @Override
    public boolean getPlot() {
        return this.Plot;
    }

    @Override
    public void setPlot(boolean plotParam) {
        Objects.requireNonNull(plotParam);
        this.Plot = plotParam;
    }
}

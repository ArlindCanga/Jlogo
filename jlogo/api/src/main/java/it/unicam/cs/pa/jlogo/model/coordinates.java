package it.unicam.cs.pa.jlogo.model;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import java.util.Objects;

/**
 * Classe utile per la gestione delle coordinate di ogni segmento
 */
public class coordinates {
    private double x1;
    private double y1;
    private double x2;
    private double y2;


    public coordinates(double fx1, double fy1, double fx2, double fy2){
        this.testParam(fx1,fx2,fy1,fy2);
        this.x1 = fx1;
        this.y1 = fy1;
        this.x2 = fx2;
        this.y2 = fy2;
    }

    private void testParam(Object... param){
        for (Object testParam : param){
            Objects.requireNonNull(testParam);
        }
    }

    /**
     * metodi utili per il settaggio delle coordinate singole
     */
    public void setX1(double fx1){
        this.x1 = fx1;
    }
    public void setY1(double fy1){
        this.y1 = fy1;
    }
    public void setX2(double fx2){
        this.x2 = fx2;
    }
    public void setY2(double fy2){
        this.y2 = fy2;
    }

    /**
     * metodi getter
     */

    public double getX1(){
        return this.x1;
    }
    public double getY1(){
        return this.y1;
    }
    public double getX2(){
        return this.x2;
    }
    public double getY2(){
        return this.y2;
    }

    /**
     * Dato un segmento, analizza se i suoi x2,y2 coincidono con punti di un altro segmento
     * @param segmentXY segmento da testare
     * @return true se tocca, false altrimenti
     */
    public boolean intersectTail(coordinates segmentXY){
        if (((this.x2 == segmentXY.x1) && (this.y2 == segmentXY.y1))
              ||((this.x2 == segmentXY.x2) && (this.y2 == segmentXY.y2))){
            return true;
        }
        return false;
    }

    /**
     * Dato un segmento, analizza se i suoi x1,y1 coincidono con punti di un altro segmento
     * @param segmentXY segmento da testare
     * @return true se tocca, false altrimenti
     */
    public boolean intersectHead(coordinates segmentXY){
        if (((this.x1 == segmentXY.x1) && (this.y1 == segmentXY.y1))
              ||((this.x1 == segmentXY.x2) && (this.y1 == segmentXY.y2))){
            return true;
        }
        return false;
    }

    public double getLength(){
        return Math.sqrt(Math.pow(this.x2 - this.x1, 2) + Math.pow(this.y2 - this.y1, 2));
    }

    public boolean sameCord(coordinates obj) {
        return ((this.x1 + this.y1 + this.x2 + this.y2) == (obj.getX1() + obj.getY1() + obj.getX2() + obj.getY2()));
    }

    @Override
    public String toString(){
        return (this.x1 + " " + this.y1 + " " + this.x2 + " " + this.y2);
    }
}

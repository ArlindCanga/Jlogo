package it.unicam.cs.pa.jlogo.model;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import java.util.Objects;

/**
 * classe per gestire l'angolazione del cursore
 */
public class Angle {
    private double angleDirection;

    public Angle(){
        this.angleDirection = 0;
    }

    //Prendo solo valori positivi
    public void setAngleDirection(int i){
        Objects.requireNonNull(i);
        this.angleDirection = Math.abs(i);
    }


    public double getAngleDirection(){
        return this.angleDirection;
    }

    /**
     * Ruota il cursore verso destra, se i gradi superano i 360 ricomincia da 0
     * @param angleParam
     */
    public void rotateRightDirection(double angleParam){
        double x = this.angleDirection + (Math.abs(angleParam));
        if (x > 360){
            this.angleDirection = 0;
            this.rotateRightDirection(x-360);
        } else {
            this.angleDirection = x;
        }
    }

    /**
     * Ruota il cursore verso sinistra, se i gradi arrivano a < 0 ricomincia da 360
     * @param angleParam
     */
    public void rotateLeftDirection(double angleParam){
        double x = this.angleDirection - (Math.abs(angleParam));
        if (x < 0){
            this.angleDirection = 360;
            this.rotateLeftDirection(x);
        } else {
            this.angleDirection = x;
        }
    }
}

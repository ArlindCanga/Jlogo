package it.unicam.cs.pa.jlogo.model;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.model.intLogic.IEnvironment;
import it.unicam.cs.pa.jlogo.model.intLogic.IManager;
import it.unicam.cs.pa.jlogo.model.intLogic.ITurtle;
import it.unicam.cs.pa.jlogo.model.Tokens.abstractToken;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class orchestrator implements IManager {
    IEnvironment table;
    ITurtle Cursor;

    /**
     * Proprietà di default dell'area di disegno:
     * x = 5000, y = 5000, Colore bianco
     */
    public orchestrator(){
        this.table = new DrawingArea(5000, 5000, Color.WHITE);
        this.setCursor();
    }

    private void setCursor(){
        this.Cursor = new turtleCursor();
        this.home();
    }

    @Override
    public void execute(List<abstractToken> tokensToExecute) {
        for (int i = 0; i < tokensToExecute.size(); i++){
            abstractToken token = tokensToExecute.get(i);
            switch (token.getTokenId().toUpperCase()){
                case "FORWARD":
                    this.goForward((Double)token.getParam());
                    break;
                case "BACKWARD":
                    this.goBackward((Double)token.getParam());
                    break;
                case "LEFT":
                    this.rotateLeft((Double)token.getParam());
                    break;
                case "RIGHT":
                    this.rotateRight((Double)token.getParam());
                    break;
                case "CLEARSCREEN":
                    this.clearScreen();
                    break;
                case "HOME":
                    this.home();
                    break;
                case "PENUP":
                    this.penUp();
                    break;
                case "PENDOWN":
                    this.penDown();
                    break;
                case "SETPENCOLOR":
                    this.setPenColor((Color) token.getParam());
                    break;
                case "SETFILLCOLOR":
                    this.setFillColor((Color) token.getParam());
                    break;
                case "SETSCREENCOLOR":
                    this.setScreenColor((Color) token.getParam());
                    break;
                case "SETPENSIZE":
                    this.setPenSize((Integer) token.getParam());
                    break;
                case "PRINT":
                    System.out.println(this.table.toString());
                    break;
                case "SAVE":
                    this.saveFile((String) token.getParam());
                    break;
            }
        }
    }


    @Override
    public void goForward(double dist) {
        if (dist >= 0){
            this.moveCursor(dist);
        } else {
            throw new IllegalArgumentException("Can't move by negative value");
        }
    }

    @Override
    public void goBackward(double dist) {
        if (dist >= 0) {
            this.moveCursor(-dist);
        } else {
            throw new IllegalArgumentException("Can't move by negative value");
        }

    }

    @Override
    public void rotateLeft(double angle) {
        this.Cursor.rotateLeft(angle);
        System.out.println("Cursore spostato di " + angle + "gradi, ora si trova a " + this.Cursor.getAngle().getAngleDirection() + " gradi");
    }

    @Override
    public void rotateRight(double angle) {
        this.Cursor.rotateRight(angle);
        System.out.println("Cursore spostato di " + angle + " gradi, ora si trova a " + this.Cursor.getAngle().getAngleDirection() + " gradi");
    }

    @Override
    public void clearScreen() {
        this.table = new DrawingArea(this.table.getWidth(), this.table.getHeight(), this.table.getBackgroundColor());
        System.out.println("Tutti i disegni sono stati cancellati");
    }

    @Override
    public void home() {
        this.Cursor.setCurrentPosition(this.table.getWidth() / 2, this.table.getHeight() / 2);
    }

    @Override
    public void penUp() {
        this.Cursor.setPlot(false);
        System.out.println("Penna staccata dal foglio");
    }

    @Override
    public void penDown() {
        this.Cursor.setPlot(true);
        System.out.println("Penna attaccata al foglio");
    }

    @Override
    public void setPenColor(Color penColor) {
        this.Cursor.setpenColor(penColor);
    }

    @Override
    public void setFillColor(Color fillColor) {
        if (!this.table.setFillColor(this.Cursor, fillColor))
            System.out.println("Il cursore non è dentro un area chiusa");
    }

    @Override
    public void setScreenColor(Color screenColor) {
        this.table.setBackgroundColor(screenColor);
        System.out.println("Colore dell'area di disegno camgiato in: "
                + screenColor.getRed() + " " + screenColor.getGreen() + " " + screenColor.getBlue());
    }

    @Override
    public void setPenSize(int penSize) {
        this.Cursor.setPenSize(penSize);
        System.out.println("Dimensione della penna cambiata. Attuale= " + penSize);
    }


    @Override
    public String result() {
        return this.table.toString();
    }

    @Override
    public boolean saveFile(String Path) {
        Path = Path.replace("\\", "/");
        try {
            FileWriter myWriter = new FileWriter(Path);
            myWriter.write(this.table.toString());
            myWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private void moveCursor(double dist){
        double posX = this.Cursor.getCurrentPosition().x() + (dist * Math.cos(this.Cursor.getAngle().getAngleDirection()));
        double posY = this.Cursor.getCurrentPosition().y() + (dist * Math.sin(this.Cursor.getAngle().getAngleDirection()));
        if (posX > this.table.getWidth()){
            System.out.println("Il cursore si ferma sul bordo dell'area di disegno");
            posX = this.table.getWidth();
        }
        if (posY > this.table.getWidth()){
            System.out.println("Il cursore si ferma sul bordo dell'area di disegno");
            posY = this.table.getHeight();
        }
        this.table.addLine(new coordinates(this.Cursor.getCurrentPosition().x(), this.Cursor.getCurrentPosition().y(), posX, posY),
                this.Cursor, lineEnum.STRAIGHT);
        this.Cursor.setCurrentPosition(posX,posY);
    }
}

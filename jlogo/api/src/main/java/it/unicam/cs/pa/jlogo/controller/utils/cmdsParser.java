package it.unicam.cs.pa.jlogo.controller.utils;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */
import it.unicam.cs.pa.jlogo.model.Tokens.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class cmdsParser implements IparseCMDS {
    private List<abstractToken> cmds;

    public cmdsParser(){
        this.cmds = new ArrayList<>();
    }

    @Override
    public void parse(String strToParse) {
        String[] cmdArray = strToParse.split(" ");
        this.evaluateCMD(cmdArray);
    }


    @Override
    public List<abstractToken> getTokenList() {
        return this.cmds;
    }

    @Override
    public void deleteTokens() {
        this.cmds = new ArrayList<>();
    }

    private void evaluateCMD(String[] cmdsToEval){
        for (int i = 0; i < cmdsToEval.length; i++){
            switch (cmdsToEval[i].toUpperCase()){
                case "FORWARD":
                case "BACKWARD":
                case "LEFT":
                case "RIGHT":
                case "SETPENSIZE":
                    if (this.isNumeric(cmdsToEval[i+1])){
                        this.createNumbersToken(cmdsToEval[i], (cmdsToEval[i+1]));
                        i++;
                    }
                    break;
                case "RIPETI":
                    i = this.repeat(cmdsToEval, i + 1);
                    break;
                case "PENUP":
                case "PENDOWN":
                case "CLEARSCREEN":
                case "HOME":
                case "PRINT":
                    this.cmds.add(new simpleToken(cmdsToEval[i]));
                    break;
                case "SETPENCOLOR":
                case "SETFILLCOLOR":
                case "SETSCREENCOLOR":
                    this.createColorToken(cmdsToEval[i],cmdsToEval[i + 1], cmdsToEval[i+2], cmdsToEval[i+3]);
                    i = i+3;
                    break;
                case "SAVE":
                    if (i + 1 < cmds.size()){
                        this.cmds.add(new stringToken(cmdsToEval[i], cmdsToEval[i+1]));
                        i++;
                    } else {
                        throw new IllegalArgumentException("Ho bisogno di un path");
                    }
            }
        }
    }

    private boolean isNumeric(String obj){
        if (obj == null){
            return false;
        }
        try {
            double d = Double.parseDouble(obj);
            if (d <= 0)
                return false;
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private void createNumbersToken(String cmd, String param){
        double num = Double.parseDouble(param);
        if (num < 0)
            throw new IllegalArgumentException(cmd + " parameter can't be negative");
        this.cmds.add(new numbersToken(cmd, num));
    }

    private int repeat(String[] cmds, int index){
        int i = this.checkBrackets(cmds, index + 1);
        if (this.isNumeric(cmds[index]) && cmds[index + 1].equals("[") && this.checkBrackets(cmds, index+1) >= 0){
            for (int x = Integer.parseInt(cmds[index]); x > 0; x--){
                this.evaluateCMD(this.cmdsToRepeat(cmds, index+2, i));
            }
        } else {
            throw new IllegalArgumentException("Repeat command has bad syntax");
        }
        return i;
    }

    private String[] cmdsToRepeat(String[] cmds, int from, int to){
        String[] arrToRet = new String[to-from];
        int index = 0;
        for (int i = from; i < to; i++){
            arrToRet[index] = cmds[i];
            index++;
        }
        return arrToRet;
    }
    private int checkBrackets(String[] cmds, int index){
        boolean opened = false;
        boolean closed = false;
        boolean inner;
        for (int i = index; i < cmds.length; i++){
            inner = false;
            if (cmds[i].equals("[")){
                if (!opened){
                    opened = true;
                } else {
                    i = this.checkBrackets(cmds, i);
                    if (i < 0){
                        return -1;
                    }
                    inner = true;
                }
            }
            if (cmds[i].equals("]") && !inner){
                if (!closed){
                    closed = true;
                } else {
                    return -1;
                }
            }
            if (opened && closed)
                return i;
        }
        return -1;
    }

    private void createColorToken(String cmdName, String r, String g, String b){
        if (!(cmdName!="" && this.isNumeric(r) && this.isNumeric(g) && this.isNumeric(b)))
            throw new IllegalArgumentException("Bad syntax!");
        this.cmds.add(new colorsToken(cmdName, this.createColor(Integer.parseInt(r),
                                                                Integer.parseInt(g),Integer.parseInt(b))));
    }

    private Color createColor(int R, int G, int B){
        if ((R >=0 & R <= 255) && (G >=0 & G <= 255) && (B >=0 & B <= 255)){
                return new Color(R,G,B);
        }
        return null;
    }

}

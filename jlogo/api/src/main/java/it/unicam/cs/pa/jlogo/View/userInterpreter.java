package it.unicam.cs.pa.jlogo.View;/*
 * jlogo: a LOGO interpreter in Java
 *
 * Copyright 2022 Arlind Canga
 *
 */

import it.unicam.cs.pa.jlogo.controller.IAddresser;
import it.unicam.cs.pa.jlogo.controller.sender;
import it.unicam.cs.pa.jlogo.controller.utils.cmdsParser;
import it.unicam.cs.pa.jlogo.controller.utils.IparseCMDS;
import it.unicam.cs.pa.jlogo.controller.utils.reader;

import java.io.IOException;
import java.util.Scanner;

/**
 * Questa classe prende l'inpute dell'utente e lo invia al parser
 */
public class userInterpreter {
    IparseCMDS stringParser;
    IAddresser controlMate;
    reader fileReader;

    public userInterpreter(){
        stringParser = new cmdsParser();
        controlMate = new sender();
        this.cmdSpeaker();
    }

    public userInterpreter(String pathFile) throws IOException {
        fileReader = new reader(pathFile);
        controlMate = new sender();
        controlMate.execute(fileReader.getTokens());
    }

    private void cmdSpeaker(){
        System.out.println(this.cmdList());
        Scanner input = new Scanner(System.in);
        boolean cycle = true;
        while (cycle){
            this.stringParser.deleteTokens();
            String userInput = input.nextLine();
            if (this.needHelp(userInput) < 0)
                break;
            this.stringParser.parse(userInput);
            this.controlMate.execute(this.stringParser.getTokenList());
        }
    }

    private int needHelp(String str){
        str = str.toUpperCase();
        str.replaceAll("\\s+","");
        if (str.equals("HELP")){
            System.out.println(this.cmdList());
        }
        if (str.equals("EXIT"))
            return -1;
        return 0;
    }

    private String cmdList(){
        return  "HELP - Per vedere questo menù" + "\n" +
                "FORWARD <dist> - Sposta il cursore in avanti" + "\n" +
                "BACKWARD <dist> - Sposta il cursore indietro" + "\n" +
                "LEFT <angle> - Ruota il cursore di angle gradi verso sinistra" + "\n" +
                "RIGHT <angle> - Ruota il cursore di angle gradi verso destra" + "\n" +
                "CLEARSCREEN - Cancella quanto disegnato" + "\n" +
                "HOME - Muove il cursore nella posizione di home" + "\n" +
                "PENUP - Stacca la penna dal foglio" + "\n" +
                "PENDOWN - Attacca la penna al foglio" + "\n" +
                "SETPENCOLOR <byte> <byte> <byte> - Imposta il colore della penna" +
                "SETFILLCOLOR <byte> <byte> <byte> - Imposta il colore di riempimento di un'area chiusa" + "\n" +
                "SETSCREENCOLOR <byte> <byte> <byte> - imposta il colore di background dell’area di disegno" + "\n" +
                "SETPENSIZE <size> - Imposta la dimensione della penna" + "\n" +
                "RIPETI <num> [ <cmds> ] - ripete la sequenza di comandi presenti nella lista dei comandi <cmds>" + "\n" +
                "PRINT - Per stampare a video il risultato dell'esecuzione" + "\n" +
                "EXIT - Per terminare il programma.";
    }
}

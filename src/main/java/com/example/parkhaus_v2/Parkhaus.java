package com.example.parkhaus_v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parkhaus {
    private final int MAX_PARKPLAETZE;
    private int freie_firmenparkplaetze = 50;
    private double kasse;
    private final List<User> besetzt;
    // Insgesamt stellt die Ticketnummern dar
    private int neustesTicket;
    //endregion

    public Parkhaus(int anzahlParkplaetze) {
        MAX_PARKPLAETZE =anzahlParkplaetze;
        kasse = 0;
        neustesTicket = 1;
        besetzt = new ArrayList<>();
    }

    public void simulateOnce(){
        Random random = new Random();
        // Zufällige Ein- und Ausfahrt
        int timer = (random.nextInt(3) + 1) * 1000;
        int einAus = (random.nextInt(2)+1);
        // Nachher darauf achten, dass die Methode eine Exception werfen kann
        try {
            Thread.sleep(timer);
            if(einAus == 1){
                einfahren();
            } else {
                int ticketNummer = random.nextInt(neustesTicket);
                ausfahren(ticketNummer);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void einfahren() {

        //region Globale Variablen
        if (getBesetzt() == MAX_PARKPLAETZE) {
            return;
        }

        User parkender = new User(neustesTicket);

        if (parkender.getTicket() instanceof FirmenTicket && freie_firmenparkplaetze > 0) {
            freie_firmenparkplaetze--;
        } else return;

        neustesTicket++;
        besetzt.add(parkender);
    }

    /*
        Sucht den User in der Liste besetzt, entfernt diesen und zahlt in die Kasse ein.
     */
    public void ausfahren(int ticketNummer) {
        for (User aktueller : besetzt) {
            if (aktueller.getTicket().getNummer() == ticketNummer) {
                //Gib firmen Parkplätze frei
                if(aktueller.getTicket() instanceof FirmenTicket)
                {
                    freie_firmenparkplaetze++;
                }
                besetzt.remove(aktueller);
                bezahlen(aktueller.getTicket());
                return;
            }
        }

        System.out.println("ERROR: Ticket Nummer nicht gefunden!");
    }

    public void bezahlen(Ticket t) {
        if (t == null) {
            System.out.println("ERROR: Ticket is null");
            return;
        }

        t.ausfahren();

        if (t instanceof DauerTicket) {
            kasse += t.getPreis();
            return;
        }

        kasse += t.getPreis() * t.getDauer();
    }

    //region Getter
    public int getNeustesTicket() {
        return neustesTicket;
    }

    public double getKasse() {
        return kasse;
    }

    public int getBesetzt() {
        return besetzt.size();
    }
    //endregion
}

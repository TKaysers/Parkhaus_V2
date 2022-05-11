package com.example.parkhaus_v2;

import java.util.ArrayList;
import java.util.Date;

/*
    ToDo
        - Eine Zeile anhand einer Nummer suchen
 */
public class Table {
    private ArrayList<String[]> rows;

    public Table() {
        rows = new ArrayList<>();
    }

    /*
        Fügt eine neue Zeile der Tabelle hinzu:
            <NR>            Das n-te Auto was reinfaehrt
            <DATUM_VON>     Zeitpunkt des Hineinfahrens
            <DATUM_BIS>     ( Zeitpunkt des Verlassens )
            <DAUER>         ( Dauer des Parkens )
            <TICKET>        Ticket
            <PREIS>         ( Preis fuer das Parken )
     */
    public void insert(int nr, Date von, Date bis, long dauer, Ticket ticket, double preis) {
        rows.add(new String[] {""+nr, von.toString(), null, null, ""+ticket.hashCode(), null});
    }

    public void onCarLeaves(int nr) {

    }
}
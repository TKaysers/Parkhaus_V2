package com.example.parkhaus_v2;

public class DauerTicket extends Ticket {
    private final int Zeitraum;

    public DauerTicket(int nr, int zeitraum) {
        super(nr);
        Zeitraum = zeitraum;
    }

    /*  ---------------------------
                GETTER
    --------------------------- */
    public double getPreis() {
        return 50.0;
    }

    public int getZeitraum() {
        return Zeitraum;
    }
}
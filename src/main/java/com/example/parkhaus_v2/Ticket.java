package com.example.parkhaus_v2;

import java.util.Date;

public class Ticket {
    private final int nr;
    private final Date von;
    private Date bis;
    private double dauer;

    public Ticket(int nr) {
        this.von = new Date();
        this.bis = null;        // Wird bei der Ausfahrt erfasst
        this.dauer = -1.0;      // Wird bei der Ausfahrt erfasst
        this.nr = nr;
    }

    public void ausfahren() {
        // Ausfahrtszeit erfassen
        bis = new Date();

        // Dauer berechnen
        long msDauer = bis.getTime() - von.getTime();   // Dauer des Parkens in Millisekunden
        dauer = (msDauer * 1000) / 24.0;         // Dauer des Parkens in Stunden
    }

    /*  ---------------------------
                    GETTER
        --------------------------- */
    public double getPreis() {
        return 1.0;
    }

    public int getNummer() {
        return nr;
    }

    public double getDauer() {
        return dauer;
    }
}


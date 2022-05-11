package com.example.parkhaus_v2;

import java.util.Random;

public class Pkw {
    private final String kennzeichen;

    public Pkw() {
        this.kennzeichen = generiereKennzeichen();
    }

    private String generiereKennzeichen() {
        StringBuilder _kennzeichen = new StringBuilder();
        Random r = new Random();

        // Stadt und 1-2 Buchstaben
        for (int i = 0; i < 2; i++) {
            int anzahlBuchstaben = r.nextInt(2) + 1;
            for (int j = 0; j < anzahlBuchstaben; j++) {
                _kennzeichen.append((char) (65 + r.nextInt(26)));
            }
            _kennzeichen.append(" ");
        }

        for (int i = 0; i < 4; i++) {
            _kennzeichen.append(r.nextInt(10));
        }

        return _kennzeichen.toString();
    }

    /*  ---------------------------
                    GETTER
        --------------------------- */
    public String getKennzeichen() {
        return kennzeichen;
    }
}

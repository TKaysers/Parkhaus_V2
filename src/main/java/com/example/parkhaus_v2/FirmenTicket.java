package com.example.parkhaus_v2;

public class FirmenTicket extends DauerTicket {
    //Fuer die "Sicherung" des Parkplatzes
    private final String Kennzeichen;

    public FirmenTicket(int nr, int zeitraum, String kennzeichen) {
        super(nr, zeitraum);
        Kennzeichen = kennzeichen;
    }

    /*  ---------------------------
                GETTER
    --------------------------- */
    public double getPreis() {
        return 30.0;
    }
    public String getKennzeichen() {
        return Kennzeichen;
    }
}

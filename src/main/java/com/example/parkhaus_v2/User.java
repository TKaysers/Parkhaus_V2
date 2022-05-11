package com.example.parkhaus_v2;
import java.util.MissingResourceException;
import java.util.Random;

public class User {
    private final Pkw auto;
    private final Ticket ticket;

    public User(int ticketNr) {
        auto = new Pkw();
        ticket = ticketziehen(ticketNr);
    }

    /*  Zieht ein Ticket basierend auf einer Zufallszahl
        0 = Normales Ticker/ Tagesticket
        1 = Dauerticket
        2 = Firmenticket
    */
    private Ticket ticketziehen(int nr) {
        Random random = new Random();
        int zufall = random.nextInt(3);

        switch (zufall) {
            case 0:
                return new Ticket(nr);
            case 1:
                //Erstellt einen Zeitraum zwischen 1 - 12 Monaten
                int zeitraum = random.nextInt(12) + 1;
                return new DauerTicket(nr, zeitraum);
            case 2:
                //Erstellt einen Zeitraum zwischen 1 - 12 Monaten
                int zeitraumF = random.nextInt(12) + 1;
                return new FirmenTicket(nr, zeitraumF, auto.getKennzeichen());
        }

        return null;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
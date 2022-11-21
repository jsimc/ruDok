package enums.notifikacija;

public class MyNotification {
    private Object notification;
    private Notifikacija enumNotif;

    public MyNotification(Object notification, Notifikacija notifikacija) {
        this.notification = notification;
        enumNotif = notifikacija;
    }

    public Object getNotification() {
        return notification;
    }

    public Notifikacija getEnumNotif() {
        return enumNotif;
    }

    public enum Notifikacija {
        DODAVANJE, //dodavanje deteta u stablo
        BRISANJE,//uklanjanje deteta iz stabla
        POSTAVLJANJE_RODITELJA, // postavljanje roditelja
        POSTAVLJANJE_IMENA,
        POSTAVLJANJE_AUTORA,
        POSTAVLJANJE_POZADINSKE_SLIKE,
        POSTAVLJANJE_REDNOG_BROJA,
        DODAVANJE_SLOTA,
        BRISANJE_SLOTA,
        POMERANJE_SLOTA,
        REPAINT,
        ERROR
    }
}

package gui.myDialog.factory;

import enums.tipKomponenti.TipSadrzaja;

public class MyDialogFactoryGenerator {
    public static MyDialogFactory returnMyDialogFactory(TipSadrzaja tipSadrzaja) {
        if(tipSadrzaja.equals(TipSadrzaja.TEKST)) return new MyDialogTextFactory();
        if(tipSadrzaja.equals(TipSadrzaja.SLIKA)) return new MyDialogSlikaFactory();
        return null;
    }
}

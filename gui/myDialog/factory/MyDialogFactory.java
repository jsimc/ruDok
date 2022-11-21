package gui.myDialog.factory;

import enums.tipKomponenti.TipSadrzaja;
import gui.myDialog.MyDialog;
import myComponents.Slot;

public abstract class MyDialogFactory {
    public MyDialog makeMyDialog(TipSadrzaja tipSadrzaja, Slot slot) {
        MyDialog myDialog = createMyDialog(tipSadrzaja, slot);
        return myDialog;
    }

    public abstract MyDialog createMyDialog(TipSadrzaja tipSadrzaja, Slot slot);
}

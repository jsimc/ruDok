package gui.myDialog.factory;

import enums.tipKomponenti.TipSadrzaja;
import gui.mainview.MainFrame;
import gui.myDialog.MyDialog;
import gui.myDialog.MyDialogSlika;
import myComponents.Slot;

public class MyDialogSlikaFactory extends MyDialogFactory{
    @Override
    public MyDialog createMyDialog(TipSadrzaja tipSadrzaja, Slot slot) {
        return new MyDialogSlika(MainFrame.getInstance(), slot);
    }
}

package gui.myDialog.factory;

import enums.tipKomponenti.TipSadrzaja;
import gui.mainview.MainFrame;
import gui.myDialog.MyDialog;
import gui.myDialog.MyDialogText;
import myComponents.Slot;

public class MyDialogTextFactory extends MyDialogFactory{
    @Override
    public MyDialog createMyDialog(TipSadrzaja tipSadrzaja, Slot slot) {
        return new MyDialogText(MainFrame.getInstance(), slot);
    }
}

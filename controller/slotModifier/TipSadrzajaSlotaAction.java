package controller.slotModifier;

import controller.MyAction;
import enums.tipKomponenti.TipSadrzaja;
import gui.mainview.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TipSadrzajaSlotaAction extends MyAction {
    public TipSadrzajaSlotaAction() {
        putValue(Action.NAME, "Tip Sadrzaja");
        putValue(SHORT_DESCRIPTION, "Vrsta Sadrzaja");

        //promeni ikonicu
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-texas-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TipSadrzaja[] options = {TipSadrzaja.SLIKA,
                TipSadrzaja.TEKST};
        int n = JOptionPane.showOptionDialog(MainFrame.getInstance(),
                "Izaberite vrstu sadrzaja",
                "Vrsta sadrzaja u slotu",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[1]); //default button title
        if(n!=-1)
            MainFrame.getInstance().setTipSadrzaja(options[n]);
        else
            MainFrame.getInstance().setTipSadrzaja(TipSadrzaja.TEKST);
    }
}

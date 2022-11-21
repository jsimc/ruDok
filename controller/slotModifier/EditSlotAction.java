package controller.slotModifier;

import controller.MyAction;
import gui.mainview.MainFrame;
import gui.myDialog.MyDialog;
import gui.myDialog.factory.MyDialogFactoryGenerator;
import myComponents.Prezentacija;
import myComponents.Slot;
import myComponents.view.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditSlotAction extends MyAction {
    public EditSlotAction() {
        putValue(Action.NAME, "Edit Slot");
        putValue(SHORT_DESCRIPTION, "Edit Slot");

        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-edit-row-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView focusedPrezView = (PrezentacijaView) MainFrame.getInstance().getProjekatView()
                .getPrezentacijeTabbedPane().getSelectedComponent();

        Prezentacija prezentacija = focusedPrezView.getPrezentacija();
        if(prezentacija.getSelectedSlot() == null) return;

        Slot slot = prezentacija.getSelectedSlot();
//        ISlotHandler iSlotHandler = slot.getiSlotHandler();

        if(MyDialogFactoryGenerator.returnMyDialogFactory(slot.getTipSadrzaja()) != null) {
            MyDialog myDialog = MyDialogFactoryGenerator.returnMyDialogFactory(slot.getTipSadrzaja())
                    .makeMyDialog(slot.getTipSadrzaja(), slot);
            myDialog.setVisible(true);
        }
    }
}

package controller.slotModifier;

import controller.MyAction;
import gui.mainview.MainFrame;
import myComponents.view.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddSlotAction extends MyAction {

    public AddSlotAction() {
        putValue(Action.NAME, "Add Slot");
        putValue(SHORT_DESCRIPTION, "Dodaj Slot");

        //promeni ikonicu
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-plus-math-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView focusedPrezView = (PrezentacijaView) MainFrame.getInstance().getProjekatView()
                .getPrezentacijeTabbedPane().getSelectedComponent();

        focusedPrezView.startAddSlotMode();
    }
}

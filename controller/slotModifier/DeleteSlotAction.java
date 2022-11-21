package controller.slotModifier;

import controller.MyAction;
import gui.mainview.MainFrame;
import myComponents.view.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteSlotAction extends MyAction {

    public DeleteSlotAction() {
        putValue(Action.NAME, "Delete Slot");
        putValue(SHORT_DESCRIPTION, "Delete Slot");

        //promeni ikonicu
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-subtract-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView focusedPrezView = (PrezentacijaView) MainFrame.getInstance().getProjekatView()
                .getPrezentacijeTabbedPane().getSelectedComponent();

        focusedPrezView.startDeleteSlotMode();
    }
}

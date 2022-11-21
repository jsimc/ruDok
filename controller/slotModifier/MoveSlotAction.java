package controller.slotModifier;

import controller.MyAction;
import gui.mainview.MainFrame;
import myComponents.view.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MoveSlotAction extends MyAction {
    public MoveSlotAction() {
        putValue(Action.NAME, "Move Slot");
        putValue(SHORT_DESCRIPTION, "Pomeri Slot");

        //promeni ikonicu
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-move-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView focusedPrezView = (PrezentacijaView) MainFrame.getInstance().getProjekatView()
                .getPrezentacijeTabbedPane().getSelectedComponent();

        focusedPrezView.startMoveSlotMode();
    }
}

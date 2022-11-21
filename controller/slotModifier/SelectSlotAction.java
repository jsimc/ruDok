package controller.slotModifier;

import controller.MyAction;
import gui.mainview.MainFrame;
import myComponents.view.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;

//defaultSlotMode == SelectSlotMode/action
public class SelectSlotAction extends MyAction {

    public SelectSlotAction() {
        putValue(Action.NAME, "Default");
        putValue(SHORT_DESCRIPTION, "Kursor");

        //promeni ikonicu
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-cursor-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView focusedPrezView = (PrezentacijaView) MainFrame.getInstance().getProjekatView()
                .getPrezentacijeTabbedPane().getSelectedComponent();

        focusedPrezView.startSelectSlotMode();
    }
}

package controller.stateAtions;

import controller.MyAction;
import gui.mainview.MainFrame;
import myComponents.view.PrezentacijaView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class NextBtnAction extends MyAction {
    public NextBtnAction() {
        putValue(Action.NAME, "Next");
        putValue(SHORT_DESCRIPTION, "Prebaci na sledeci slajd.");

         putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-right-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView focusedPrezView = (PrezentacijaView) MainFrame.getInstance().getProjekatView()
                .getPrezentacijeTabbedPane().getSelectedComponent();
        ((CardLayout)focusedPrezView.getSlideShowPanel().getLayout()).next(focusedPrezView.getSlideShowPanel());
    }
}

package controller.stateAtions;

import controller.MyAction;
import gui.mainview.MainFrame;
import myComponents.view.PrezentacijaView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PrevBtnAction extends MyAction {

    public PrevBtnAction() {
        putValue(Action.NAME, "Prev");
        putValue(SHORT_DESCRIPTION, "Prebaci na prethodni slajd.");

        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-left-22.png"));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView focusedPrezView = (PrezentacijaView) MainFrame.getInstance().getProjekatView()
                .getPrezentacijeTabbedPane().getSelectedComponent();
        ((CardLayout)focusedPrezView.getSlideShowPanel().getLayout()).previous(focusedPrezView.getSlideShowPanel());
    }
}

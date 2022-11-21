package controller.stateAtions;

import controller.MyAction;
import gui.mainview.MainFrame;
import myComponents.view.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditModeAction extends MyAction {

    public EditModeAction() {
        putValue(Action.NAME, "Close SlideShow mode");
        putValue(SHORT_DESCRIPTION, "Vrati se u edit mode.");

        //promeni ikonicu
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-edit-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((PrezentacijaView) MainFrame.getInstance().getProjekatView().getPrezentacijeTabbedPane().getSelectedComponent()).startEditMode();
        ((PrezentacijaView)MainFrame.getInstance().getProjekatView().getPrezentacijeTabbedPane().getSelectedComponent()).changeState();
    }
}

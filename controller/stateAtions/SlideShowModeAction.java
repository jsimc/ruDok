package controller.stateAtions;

import controller.MyAction;
import error.ErrorFactory;
import gui.mainview.MainFrame;
import myComponents.view.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SlideShowModeAction extends MyAction {

    public SlideShowModeAction() {
        putValue(Action.NAME, "SlideShow");
        putValue(SHORT_DESCRIPTION, "Pogledaj SlideShow.");

        //promeni ikonicu
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-start-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //kad se klikne na dugme trebalo bi da se u MainFrame-u zameni na contentPaneu
        //EditModePane sa SlideShowPaneom
        //Postavljam startViewMode, ali e
        if(MainFrame.getInstance().getProjekatView().getPrezentacijeTabbedPane().getSelectedComponent() == null) {
            ErrorFactory.getInstance().generateError("Nijedna prezentacija nije otvorena", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ((PrezentacijaView)MainFrame.getInstance().getProjekatView().getPrezentacijeTabbedPane().getSelectedComponent()).startViewMode();
        ((PrezentacijaView)MainFrame.getInstance().getProjekatView().getPrezentacijeTabbedPane().getSelectedComponent()).changeState();
    }
}

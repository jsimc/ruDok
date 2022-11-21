package state.rezimRada.concrete;

import error.ErrorFactory;
import gui.mainview.MainFrame;
import myComponents.view.PrezentacijaView;
import state.rezimRada.State;

import javax.swing.*;

public class ViewState implements State {
    @Override
    public void changeState() {
        PrezentacijaView focusedPrezView = (PrezentacijaView) MainFrame.getInstance().getProjekatView()
                                            .getPrezentacijeTabbedPane().getSelectedComponent();

        if(focusedPrezView == null) {
            ErrorFactory.getInstance().generateError("Nijedna prezentacija nije otvorena", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        focusedPrezView.startVibeSlotMode();

        focusedPrezView.setSlideShow(true);
        focusedPrezView.viewToolBarMode();
        focusedPrezView.makeMeASlideShowPane();
        focusedPrezView.repaint();
        focusedPrezView.validate();
    }
}

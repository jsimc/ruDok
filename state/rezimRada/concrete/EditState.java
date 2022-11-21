package state.rezimRada.concrete;

import gui.mainview.MainFrame;
import myComponents.view.PrezentacijaView;
import state.rezimRada.State;

public class EditState implements State {
    @Override
    public void changeState() {
        PrezentacijaView focusedPrezView = (PrezentacijaView) MainFrame.getInstance().getProjekatView()
                .getPrezentacijeTabbedPane().getSelectedComponent();

        focusedPrezView.editToolBarMode();
        focusedPrezView.setSlideShow(false);
        focusedPrezView.prebaciNaEdit();
    }
}

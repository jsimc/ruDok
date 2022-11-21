package state.radSaSlotovima.concrete;

import gui.mainview.MainFrame;
import myComponents.Slide;
import myComponents.Slot;
import state.radSaSlotovima.StateSlot;

public class AddSlotState extends StateSlot {
    @Override
    public void mousePressed(int x, int y, Slide slide) {
        Slot slot = new Slot(x, y, MainFrame.getInstance().getTipSadrzaja());
        slide.addSlot(slot);
    }
}

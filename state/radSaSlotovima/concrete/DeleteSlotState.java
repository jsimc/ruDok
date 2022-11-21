package state.radSaSlotovima.concrete;

import error.ErrorFactory;
import myComponents.Slide;
import myComponents.Slot;
import myComponents.view.SlideView;
import state.radSaSlotovima.StateSlot;

import javax.swing.*;

public class DeleteSlotState extends StateSlot {
    @Override
    public void mousePressed(int x, int y, Slide slide) {
        for(int i = 0; i < slide.getSlots().size(); i++) {
            Slot slot = slide.getSlots().get(i);
            if(slot.elementAt(x, y)) {
                slide.removeSlot(slot);
                return;
            }
        }
    }
}

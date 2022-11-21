package state.radSaSlotovima.concrete;

import myComponents.Slide;
import myComponents.Slot;
import state.radSaSlotovima.StateSlot;

public class SelectSlotState extends StateSlot {
    @Override
    public void mousePressed(int x, int y, Slide slide) {
        for(Slot slot : slide.getSlots()) {
            if(slot.isSelected()) {
                slot.setSelected(false);
            }
        }
        for(Slot slot : slide.getSlots()) {
            if(slot.elementAt(x, y)) {
                slot.setSelected(true);

                System.out.println("Selected: " + slot);
                return;
            }
        }
//        slide.setSelectedSlot(x, y);
    }
}

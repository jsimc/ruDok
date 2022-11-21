package state.radSaSlotovima.concrete;

import myComponents.Slide;
import myComponents.Slot;
import state.radSaSlotovima.StateSlot;

public class MoveSlotState extends StateSlot {
    private boolean flag = false;

    //ideja da se nekako moveslotstate skroz prestane sa radom
    // mouse Dragged ako vidi da nije kliknuto na slot koji je selektovan
    @Override
    public void mousePressed(int x, int y, Slide slide) {
        flag = false;
        for(int i = 0; i < slide.getSlots().size(); i++) {
            if(slide.getSlots().get(i).isSelected() && slide.getSlots().get(i).elementAt(x, y)) {
                flag = true; // true znaci da mouse dragged SME da se izvrsi
            }
        }
    }

    @Override
    public void mouseDragged(int x, int y, Slide slide) {
        if(flag) {
            for(int i = 0; i < slide.getSlots().size(); i++) {
                Slot slot1 = slide.getSlots().get(i);
                if (slot1.isSelected()) {
                    slot1.setPosition(x, y);
                    return;
                }
            }
        }
    }


}

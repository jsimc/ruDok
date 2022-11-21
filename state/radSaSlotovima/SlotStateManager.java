package state.radSaSlotovima;

import state.radSaSlotovima.concrete.*;

public class SlotStateManager {
    private StateSlot activeState;

    private final AddSlotState addSlotState;
    private final DeleteSlotState deleteSlotState;
    private final SelectSlotState selectSlotState;
    private final MoveSlotState moveSlotState;
    private final VibeSlotState vibeSlotState;

    public SlotStateManager() {
        addSlotState = new AddSlotState();
        deleteSlotState = new DeleteSlotState();
        selectSlotState = new SelectSlotState();
        moveSlotState = new MoveSlotState();
        vibeSlotState = new VibeSlotState();
        activeState = vibeSlotState;
    }

    public StateSlot getCurrent(){
        return activeState;
    }

    public void setAddSlotState(){
        this.activeState = addSlotState;
    }

    public void setDeleteSlotState() {
        this.activeState = deleteSlotState;
    }

    public void setSelectSlotState() {
        this.activeState = selectSlotState;
    }

    public void setMoveSlotState() {
        this.activeState = moveSlotState;
    }

    public void setVibeSlotState() {
        this.activeState = vibeSlotState;
    }
}

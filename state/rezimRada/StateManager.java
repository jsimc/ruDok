package state.rezimRada;

import state.rezimRada.concrete.EditState;
import state.rezimRada.concrete.ViewState;

public class StateManager{
    private State activeState;

    private final ViewState stateView;
    private final EditState stateEdit;

    public StateManager() {
        stateEdit = new EditState();
        stateView = new ViewState();
        activeState = stateEdit;
    }

    public State getCurrent(){
        return activeState;
    }

    public void setStateEdit(){
        this.activeState = stateEdit;
    }

    public void setStateView() {
        this.activeState = stateView;
    }

}

package controller;

import controller.commandActions.DoAction;
import controller.commandActions.UndoAction;
import controller.slotModifier.*;
import controller.stateAtions.EditModeAction;
import controller.stateAtions.NextBtnAction;
import controller.stateAtions.PrevBtnAction;
import controller.stateAtions.SlideShowModeAction;

public class ActionManager {
    private InfoAction infoAction;
    private NewAction newAction;
    private AutorAction autorAction;
    private TemplateAction templateAction;
    private DeleteAction deleteAction;
    private EditModeAction editModeAction;
    private NextBtnAction nextBtnAction;
    private PrevBtnAction prevBtnAction;
    private SlideShowModeAction slideShowModeAction;
    private AddSlotAction addSlotAction;
    private SelectSlotAction selectSlotAction;
    private DeleteSlotAction deleteSlotAction;
    private MoveSlotAction moveSlotAction;
    private ColorAction colorAction;
    private StrokeDebljinaAction strokeChangerAction;
    private StrokeVrstaAction strokeVrstaAction;
    private DoAction doAction;
    private UndoAction undoAction;
    private SaveProjectAction saveProjectAction;
    private OpenAction openAction;
    private TipSadrzajaSlotaAction tipSadrzajaSlotaAction;
    private DeljenjePrezentacije deljenjePrezentacije;
    private EditSlotAction editSlotAction;

    public ActionManager() {
        infoAction = new InfoAction();
        newAction = new NewAction();
        autorAction = new AutorAction();
        templateAction = new TemplateAction();
        deleteAction = new DeleteAction();
        editModeAction = new EditModeAction();
        nextBtnAction = new NextBtnAction();
        prevBtnAction = new PrevBtnAction();
        slideShowModeAction = new SlideShowModeAction();
        addSlotAction = new AddSlotAction();
        selectSlotAction = new SelectSlotAction();
        deleteSlotAction = new DeleteSlotAction();
        moveSlotAction = new MoveSlotAction();
        colorAction = new ColorAction();
        strokeChangerAction = new StrokeDebljinaAction();
        strokeVrstaAction = new StrokeVrstaAction();
        doAction = new DoAction();
        undoAction = new UndoAction();
        saveProjectAction = new SaveProjectAction();
        openAction = new OpenAction();
        tipSadrzajaSlotaAction = new TipSadrzajaSlotaAction();
        deljenjePrezentacije = new DeljenjePrezentacije();
        editSlotAction = new EditSlotAction();
    }

    public EditSlotAction getEditSlotAction() {
        return editSlotAction;
    }

    public void setEditSlotAction(EditSlotAction editSlotAction) {
        this.editSlotAction = editSlotAction;
    }

    public DeljenjePrezentacije getDeljenjePrezentacije() {
        return deljenjePrezentacije;
    }

    public void setDeljenjePrezentacije(DeljenjePrezentacije deljenjePrezentacije) {
        this.deljenjePrezentacije = deljenjePrezentacije;
    }

    public TipSadrzajaSlotaAction getTipSadrzajaSlotaAction() {
        return tipSadrzajaSlotaAction;
    }

    public void setTipSadrzajaSlotaAction(TipSadrzajaSlotaAction tipSadrzajaSlotaAction) {
        this.tipSadrzajaSlotaAction = tipSadrzajaSlotaAction;
    }

    public OpenAction getOpenAction() {
        return openAction;
    }

    public void setOpenAction(OpenAction openAction) {
        this.openAction = openAction;
    }

    public SaveProjectAction getSaveProjectAction() {
        return saveProjectAction;
    }

    public void setSaveProjectAction(SaveProjectAction saveProjectAction) {
        this.saveProjectAction = saveProjectAction;
    }

    public DoAction getDoAction() {
        return doAction;
    }

    public void setDoAction(DoAction doAction) {
        this.doAction = doAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public void setUndoAction(UndoAction undoAction) {
        this.undoAction = undoAction;
    }

    public StrokeVrstaAction getStrokeVrstaAction() {
        return strokeVrstaAction;
    }

    public void setStrokeVrstaAction(StrokeVrstaAction strokeVrstaAction) {
        this.strokeVrstaAction = strokeVrstaAction;
    }

    public StrokeDebljinaAction getStrokeChangerAction() {
        return strokeChangerAction;
    }

    public void setStrokeChangerAction(StrokeDebljinaAction strokeChangerAction) {
        this.strokeChangerAction = strokeChangerAction;
    }

    public ColorAction getColorAction() {
        return colorAction;
    }

    public void setColorAction(ColorAction colorAction) {
        this.colorAction = colorAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public NewAction getNewAction() {
        return newAction;
    }

    public void setNewAction(NewAction newAction) {
        this.newAction = newAction;
    }

    public AutorAction getAutorAction() {
        return autorAction;
    }

    public void setAutorAction(AutorAction autorAction) {
        this.autorAction = autorAction;
    }

    public TemplateAction getTemplateAction() {
        return templateAction;
    }

    public void setTemplateAction(TemplateAction templateAction) {
        this.templateAction = templateAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public void setDeleteAction(DeleteAction deleteAction) {
        this.deleteAction = deleteAction;
    }

    public EditModeAction getEditModeAction() {
        return editModeAction;
    }

    public void setEditModeAction(EditModeAction editModeAction) {
        this.editModeAction = editModeAction;
    }

    public NextBtnAction getNextBtnAction() {
        return nextBtnAction;
    }

    public void setNextBtnAction(NextBtnAction nextBtnAction) {
        this.nextBtnAction = nextBtnAction;
    }

    public PrevBtnAction getPrevBtnAction() {
        return prevBtnAction;
    }

    public void setPrevBtnAction(PrevBtnAction prevBtnAction) {
        this.prevBtnAction = prevBtnAction;
    }

    public SlideShowModeAction getSlideShowModeAction() {
        return slideShowModeAction;
    }

    public void setSlideShowModeAction(SlideShowModeAction slideShowModeAction) {
        this.slideShowModeAction = slideShowModeAction;
    }

    public AddSlotAction getAddSlotAction() {
        return addSlotAction;
    }

    public void setAddSlotAction(AddSlotAction addSlotAction) {
        this.addSlotAction = addSlotAction;
    }

    public SelectSlotAction getSelectSlotAction() {
        return selectSlotAction;
    }

    public void setSelectSlotAction(SelectSlotAction selectSlotAction) {
        this.selectSlotAction = selectSlotAction;
    }

    public DeleteSlotAction getDeleteSlotAction() {
        return deleteSlotAction;
    }

    public void setDeleteSlotAction(DeleteSlotAction deleteSlotAction) {
        this.deleteSlotAction = deleteSlotAction;
    }

    public MoveSlotAction getMoveSlotAction() {
        return moveSlotAction;
    }

    public void setMoveSlotAction(MoveSlotAction moveSlotAction) {
        this.moveSlotAction = moveSlotAction;
    }
}

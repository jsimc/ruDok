package gui.myDialog;

import controller.slotModifier.slotHandler.ISlotHandler;
import gui.mainview.MainFrame;
import myComponents.Slot;

import javax.swing.*;
import java.awt.*;

public abstract class MyDialog extends Dialog {
    private JToolBar jToolBar;
    private JButton saveButton;
    private JButton cancelButton;
    private JPanel mainPanel;

    private Slot slot;

    private ISlotHandler iSlotHandler;

    public MyDialog(Frame owner, Slot slot) {
        super(owner);
        this.setLocationRelativeTo(MainFrame.getInstance());
        this.setPreferredSize(new Dimension(356, 257));
        this.slot = slot;
        this.iSlotHandler = slot.getiSlotHandler();
        jToolBar = new JToolBar();
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public ISlotHandler getiSlotHandler() {
        return iSlotHandler;
    }

    public void setiSlotHandler(ISlotHandler iSlotHandler) {
        this.iSlotHandler = iSlotHandler;
    }

    public JToolBar getjToolBar() {
        return jToolBar;
    }

    public void setjToolBar(JToolBar jToolBar) {
        this.jToolBar = jToolBar;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}

package controller.commandActions;

import controller.MyAction;
import gui.mainview.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class UndoAction extends MyAction {

    public UndoAction() {
        putValue(Action.NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "CTRL + Z");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-undo-22.png"));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getCommandManager().undoCommand();
    }
}

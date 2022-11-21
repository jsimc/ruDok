package controller.commandActions;

import controller.MyAction;
import gui.mainview.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DoAction extends MyAction {

    public DoAction() {
        putValue(Action.NAME, "REDO");
        putValue(SHORT_DESCRIPTION, "CTRL + B");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-redo-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getCommandManager().doCommand();
    }
}

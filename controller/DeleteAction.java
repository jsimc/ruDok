package controller;

import command.concrete.BrisanjeKomanda;
import error.ErrorFactory;
import gui.mainview.MainFrame;
import gui.treeGui.treeModel.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends MyAction{

    public DeleteAction() {
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "CTRL + D");
        putValue(SMALL_ICON, loadIcon("src/src/slike/bin.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(o instanceof MyTreeNode) {
            MyTreeNode deteTreeNode = (MyTreeNode) o;
            if(deteTreeNode.getParent() == null) {
                ErrorFactory.getInstance().generateError("Ne moze se obrisati workspace!", "GRESKA KORISNIKA!",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            MainFrame.getInstance().getCommandManager().addCommand(
                    new BrisanjeKomanda(deteTreeNode));

            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }

    }
}

package controller;

import command.concrete.DodavanjeKomanda;
import error.ErrorFactory;
import factory.myComponentsFactory.AbstractNodeFactory;
import factory.myComponentsFactory.FactoryGenerator;
import gui.mainview.MainFrame;
import gui.treeGui.treeModel.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewAction extends MyAction{

    public NewAction() {
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "CTRL + N");
        putValue(SMALL_ICON, loadIcon("src/src/slike/docs.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(o instanceof MyTreeNode) {
            MyTreeNode selektovaniTreeNode = (MyTreeNode) o;

            MainFrame.getInstance().getMyTree().expandPath(MainFrame.getInstance().getMyTree().getSelectionPath());

            AbstractNodeFactory abstractNodeFactory = FactoryGenerator.returnNodeFactory(selektovaniTreeNode);
            if(abstractNodeFactory == null) {
                ErrorFactory.getInstance().generateError("Ne moze da se doda na Slide", "GRESKA KORISNIKA",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            MainFrame.getInstance().getCommandManager().addCommand(new DodavanjeKomanda(selektovaniTreeNode, abstractNodeFactory));

            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }
    }
}

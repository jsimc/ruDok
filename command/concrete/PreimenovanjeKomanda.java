package command.concrete;

import command.MojaKomanda;
import gui.mainview.MainFrame;
import gui.treeGui.treeModel.MyTreeNode;
import ruNodeModel.RuNode;

import javax.swing.*;

public class PreimenovanjeKomanda implements MojaKomanda {

    private String oldName;
    private String newName;

    private RuNode ruNode; //cije se ime menja
    private MyTreeNode myTreeNode; //wrapper ruNode-a

    public PreimenovanjeKomanda(String newName, MyTreeNode myTreeNode) {
        this.newName = newName;
        this.myTreeNode = myTreeNode;
        this.ruNode = myTreeNode.getRuNode();
        this.oldName = ruNode.getName();
    }

    @Override
    public void doCommand() {
        this.ruNode.setName(newName);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

    @Override
    public void undoCommand() {
        this.ruNode.setName(oldName);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}

package controller;

import error.ErrorFactory;
import gui.mainview.MainFrame;
import gui.treeGui.treeModel.MyTreeNode;
import myComponents.Projekat;
import serialization.Serijalizacija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class SaveProjectAction extends MyAction{
    JLabel image;

    public SaveProjectAction() {
        putValue(NAME, "Save");
        putValue(SHORT_DESCRIPTION, "CTRL + S");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("src/src/slike/icons8-save-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Cuva se projekat koji je oznacen u stablu
        Object o = MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(!(((MyTreeNode)o).getRuNode() instanceof Projekat)) {
            ErrorFactory.getInstance().generateError("Oznacite Projekat za cuvanje", "GRESKA KORISNIKA",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        Projekat projekat = (Projekat) ((MyTreeNode)o).getRuNode();
        if(!projekat.isChanged()) {
            System.out.println("Nije promenjen");
            return;
        }

        try {
            Serijalizacija.writeToFile(projekat);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        projekat.setChanged(false);
    }
}

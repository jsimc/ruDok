package controller;

import error.ErrorFactory;
import gui.mainview.MainFrame;
import myComponents.Prezentacija;
import gui.treeGui.treeModel.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AutorAction extends MyAction{

    public AutorAction() {
        putValue(Action.NAME, "Autor");
        putValue(SHORT_DESCRIPTION, "Promeni autora prezentacije?");
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/user.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object o = MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();

        if(o instanceof MyTreeNode && ((MyTreeNode)o).getRuNode() instanceof Prezentacija) {
            Object input = JOptionPane.showInputDialog(MainFrame.getInstance(), "Unesi autora", "Odabir autora", JOptionPane.QUESTION_MESSAGE);

            if(input != null){
                if (!input.toString().equals("")) {
                    //duplo kastovanje
                    ((Prezentacija)((MyTreeNode)o).getRuNode()).setAutor(input.toString());
                }
            }

        } else {
            ErrorFactory.getInstance().generateError("Oznacite prezentaciju da biste postavili autora", "Obavestenje",
                    JOptionPane.WARNING_MESSAGE);
        }

    }


        //da promenis autora u trenutno otvorenoj i/ili cekiranoj prezentaciji
        //al to ne znaci da treba da mu prosledis prezentaciju nego ce on da shvati preko buttona to
}

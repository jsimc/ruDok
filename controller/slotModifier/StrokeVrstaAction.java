package controller.slotModifier;

import controller.MyAction;
import gui.mainview.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StrokeVrstaAction extends MyAction {
    public StrokeVrstaAction() {
        putValue(Action.NAME, "Stroke vrsta");
        putValue(SHORT_DESCRIPTION, "Vrsta stroke-a");

        //promeni ikonicu
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-dashed-line-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object[] options = {"Dashed",
                "Solid"};
        int n = JOptionPane.showOptionDialog(MainFrame.getInstance(),
                "Would you like dashed lines or not?",
                "Vrsta linije",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[1]); //default button title
        MainFrame.getInstance().setDashed(n == 0);
    }
}

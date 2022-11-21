package controller.slotModifier;

import controller.MyAction;
import gui.mainview.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StrokeDebljinaAction extends MyAction {
    public StrokeDebljinaAction() {
        putValue(Action.NAME, "Stroke changer");
        putValue(SHORT_DESCRIPTION, "DEBLJINa stroke-a");

        //promeni ikonicu
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-stroke-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = JOptionPane.showInputDialog(MainFrame.getInstance(),
                "Debljina linije",
                JOptionPane.INFORMATION_MESSAGE);
        int debljinaLinije = 5;
        try {
            debljinaLinije = Integer.parseInt(str);
        } catch(Exception e1) {
//            e1.printStackTrace();
        }

        MainFrame.getInstance().setStrokeDebljina(debljinaLinije);

    }

}

package controller;

import gui.mainview.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ColorAction extends MyAction{

    public ColorAction() {
        putValue(Action.NAME, "Slot Color");
        putValue(SHORT_DESCRIPTION, "Izaberi boju");
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-paint-palette-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color color = JColorChooser.showDialog(MainFrame.getInstance(), "Choose Slot Color", Color.BLUE);
        if(color != null) {
            MainFrame.getInstance().setColor(color);
        }
    }
}

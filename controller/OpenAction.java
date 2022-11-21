package controller;

import fileFilter.MyFileFilter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class OpenAction extends MyAction{
    public OpenAction() {
        putValue(NAME, "Open Project");
        putValue(SHORT_DESCRIPTION, "CTRL + O");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("src/src/slike/icons8-open-sign-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new MyFileFilter());
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            putValue(SMALL_ICON, loadIcon(file.getAbsolutePath()));
        }
    }
}

package controller;

import gui.mainview.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InfoAction extends MyAction {

    public InfoAction() {
        putValue(Action.NAME, "Info");
        putValue(SHORT_DESCRIPTION, "CTRL + I");
        putValue(Action.ACCELERATOR_KEY,  KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/info.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String info = "Jelena Simić 27/20RN";
        ImageIcon slika = new ImageIcon("src/src/slike/Jelena.jpg");
//        JOptionPane.showMessageDialog(MainFrame.getInstance(), info, "Student - info", JOptionPane.INFORMATION_MESSAGE, slika);
        JPanel poruka = new JPanel();
        poruka.add(new JLabel(slika));
        poruka.add(new JLabel(info));
        JDialog dialog = new JDialog(MainFrame.getInstance());
        dialog.setSize(350, 250);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Student - info");
        dialog.add(poruka);

        dialog.pack();
        dialog.setLocationByPlatform(true);
        dialog.setVisible(true);
    }

}

package gui.mainview;

import javax.swing.*;

public class MainMenuBar extends JMenuBar {

    public MainMenuBar() {
//        setBackground(new Color(0xD7F1F1F1, true));

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteAction());

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(MainFrame.getInstance().getActionManager().getAutorAction());
        editMenu.add(MainFrame.getInstance().getActionManager().getTemplateAction());
        editMenu.add(MainFrame.getInstance().getActionManager().getColorAction());

        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(MainFrame.getInstance().getActionManager().getInfoAction());

        this.add(fileMenu);
        this.add(editMenu);
        this.add(helpMenu);
    }



}

package gui.mainview;

import javax.swing.*;
import java.awt.*;

public class MainToolBar extends JToolBar {

    public MainToolBar() {
        setBackground(new Color(0x81BDD7));
        setFloatable(false);
        arrange();
    }


    private void arrange() {
        add(MainFrame.getInstance().getActionManager().getNewAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getDeleteAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getInfoAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSaveProjectAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getOpenAction());
        addSeparator();
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getUndoAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getDoAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getDeljenjePrezentacije());
    }
}

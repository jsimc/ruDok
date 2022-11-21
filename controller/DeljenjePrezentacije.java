package controller;

import error.ErrorFactory;
import gui.mainview.MainFrame;
import gui.treeGui.treeModel.MyTreeNode;
import myComponents.Prezentacija;
import myComponents.Projekat;
import myComponents.WorkSpace;
import ruNodeModel.RuNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class DeljenjePrezentacije extends MyAction{

    public DeljenjePrezentacije() {
        putValue(Action.NAME, "Deljenje Prezentacije"); //Deljenje
        putValue(SHORT_DESCRIPTION, "Podeli Prezentaciju");
        putValue(Action.SMALL_ICON, loadIcon("src/src/slike/icons8-share-document-22.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(((MyTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode() instanceof Prezentacija)) {
            ErrorFactory.getInstance().generateError("Selektuj Prezentaciju", "Greska", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Prezentacija prezentacija = (Prezentacija) ((MyTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode();

        JDialog shareDialog = new JDialog();
        shareDialog.setLocationRelativeTo(MainFrame.getInstance());
        shareDialog.setLayout(new BorderLayout());

        JPanel projekatPanel = new JPanel();
        projekatPanel.setLayout(new BoxLayout(projekatPanel, BoxLayout.Y_AXIS));
        JPanel savePanel = new JPanel(new FlowLayout());

        MyTreeNode wsMtn = (MyTreeNode) MainFrame.getInstance().getMyTreeModel().getRoot();
        List<MyTreeNode> wsMtnDeca = new ArrayList<>();
        for(int i = 0; i < wsMtn.getChildren().size(); i++) {
            wsMtnDeca.add((MyTreeNode) wsMtn.getChildAt(i));
        }
        WorkSpace ws = (WorkSpace) wsMtn.getRuNode();
        for(RuNode projekat : ws.getChildren()) {
            if(projekat.equals(prezentacija.getParent()) ||
                    prezentacija.getDeljeno().contains((Projekat) projekat)) {
                continue;
            }
            JButton jButton = new JButton(projekat.getName());
            jButton.addActionListener(action -> {
                MyTreeNode prezentacijaMtn = new MyTreeNode(prezentacija);
                for(int i = 0; i < prezentacija.getChildren().size(); i++) {
                    MyTreeNode dete = new MyTreeNode(prezentacija.getChildren().get(i));
                    prezentacijaMtn.addChild(dete);
                    dete.setParent(prezentacijaMtn);
                }
                prezentacija.addDeljeno((Projekat) projekat);
                for(MyTreeNode projekatMtn : wsMtnDeca) {
                    if(projekatMtn.getRuNode().equals(projekat)) {
                        projekatMtn.addChild(prezentacijaMtn);
                        prezentacijaMtn.setParent(projekatMtn);
                        break;
                    }
                }
                shareDialog.dispose();
            });
            projekatPanel.add(jButton);
        }

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(action -> shareDialog.dispose());
        savePanel.add(cancelButton);

        shareDialog.add(projekatPanel, BorderLayout.CENTER);
        shareDialog.add(savePanel, BorderLayout.SOUTH);
        shareDialog.pack();
        shareDialog.setVisible(true);

    }

}

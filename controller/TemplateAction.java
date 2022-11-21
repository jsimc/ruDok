package controller;

import error.ErrorFactory;
import gui.mainview.MainFrame;
import myComponents.Prezentacija;
import gui.treeGui.treeModel.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TemplateAction extends MyAction{
    public TemplateAction() {
        putValue(NAME, "Template");
        putValue(SHORT_DESCRIPTION, "Promeni tematiku prezentacije");
        putValue(SMALL_ICON, loadIcon("src/src/slike/background.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object o = MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();

//        if (o instanceof MyTreeNode && ((MyTreeNode)o).getRuNode() instanceof Prezentacija) {
//            Prezentacija selektovanaPrezentacija = (Prezentacija) ((MyTreeNode)o).getRuNode();
//
//            Vector<ImageIcon> slikeUrl = new Vector<>();
//            slikeUrl.add(new ImageIcon("src/src/slike/Actions-help-about-icon.jpg"));
//            slikeUrl.add(new ImageIcon("src/src/slike/Jelena_Maturska_ikonica.jpg", "src/src/slike/Jelena_Maturska_ikonica.jpg"));
//            slikeUrl.add(new ImageIcon("src/src/slike/person-icons-clip-art-profile.jpg", "src/src/slike/person-icons-clip-art-profile.jpg"));
//            JComboBox jComboBoxPozadine = new JComboBox(slikeUrl);
//            jComboBoxPozadine.setSelectedItem(null);
//
//            jComboBoxPozadine.setEditable(true);
//            JOptionPane.showMessageDialog(MainFrame.getInstance(), jComboBoxPozadine, "Promeni pozadinu", JOptionPane.QUESTION_MESSAGE);
//
//            ImageIcon url = (ImageIcon) jComboBoxPozadine.getSelectedItem();
//            selektovanaPrezentacija.setPozadinskaSlika(url.getImage());
////            for(RuNode s : selektovanaPrezentacija.getChildren()) {
////                ((Slide)s).setUrlSlike(url.getDescription());
////            }
//        }
        if (o instanceof MyTreeNode && ((MyTreeNode) o).getRuNode() instanceof Prezentacija) {

            Prezentacija prezentacija = (Prezentacija) ((MyTreeNode) o).getRuNode();

//            JToggleButton tglBtn1 = new JToggleButton(new ImageIcon("src/src/slike/Jelena_Maturska_ikonica.jpg"));
//            JToggleButton tglBtn2 = new JToggleButton(new ImageIcon("src/src/slike/Actions-help-about-icon.jpg"));
//            JToggleButton tglBtn3 = new JToggleButton(new ImageIcon("src/src/slike/person-icons-clip-art-profile.jpg"));

            JToggleButton tglBtn1 = new JToggleButton("Zelena");
            JToggleButton tglBtn2 = new JToggleButton("Siva");
            JToggleButton tglBtn3 = new JToggleButton("Plava");

            ButtonGroup toggleBtnGroup = new ButtonGroup();
            toggleBtnGroup.add(tglBtn1);
            toggleBtnGroup.add(tglBtn2);
            toggleBtnGroup.add(tglBtn3);
            tglBtn1.setSelected(true);

            JPanel panel = new JPanel();

            JDialog dialog = new JDialog(MainFrame.getInstance(), true);
            JButton selectBtn = new JButton("select");
            selectBtn.addActionListener(action -> {
                String url = "";
                if (tglBtn1.isSelected()) {
                    url = "src/src/slike/green_pozadina.png";
                } else if (tglBtn2.isSelected()) {
                    url = "src/src/slike/grey_pozadina.png";
                } else if (tglBtn3.isSelected()) {
                    url = "src/src/slike/teal_pozadina.png";
                }

//                System.out.println(url);
                prezentacija.setPozadinskaSlika(url);
    //            JToggleButton tgl = (JToggleButton) toggleBtnGroup.getSelection().getSelectedObjects()[0];
                dialog.dispose();
            });

            panel.add(tglBtn1);
            panel.add(tglBtn2);
            panel.add(tglBtn3);
            panel.add(selectBtn);

            dialog.add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(MainFrame.getInstance());
            dialog.setVisible(true);
            System.out.println("prezentacija je: " + prezentacija.getAutor() + " " + prezentacija.getPozadinskaSlika());

        } else {
            ErrorFactory.getInstance().generateError("Potrebno je oznaciti prezentaciju!", "GRESKA KORISNIKA!",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println("Oznaci prezentaciju!");
        }

/*
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showSaveDialog(null);

        String urlSlike = "";
        if (jFileChooser.getSelectedFile() != null) {
            urlSlike = jFileChooser.getSelectedFile().getAbsolutePath();
        }
        System.out.println(urlSlike);
        */
    }
}

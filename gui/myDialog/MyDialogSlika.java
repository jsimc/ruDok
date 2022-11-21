package gui.myDialog;

import fileFilter.ImageFilter;
import gui.mainview.ImagePanel;
import gui.mainview.MainFrame;
import myComponents.Slot;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MyDialogSlika extends MyDialog{
    private List<String> nizEkstenzija = Arrays.asList("jpg", "png", "jpeg", "img");
    private String urlSlike;

    private ImagePanel previewSlika;
    private JButton chooseSlika;

    public MyDialogSlika(Frame owner, Slot slot) {
        super(owner, slot);
        if(slot.getContent().getUrlSlike() != null) {
            previewSlika = new ImagePanel(slot.getContent().getUrlSlike());
        } else {
            previewSlika = new ImagePanel();
        }
        postaviAkcije();
        getMainPanel().add(getjToolBar(), BorderLayout.NORTH);
        getMainPanel().add(previewSlika, BorderLayout.CENTER);
        getMainPanel().add(makeASouthPanel(), BorderLayout.SOUTH);
        this.pack();
    }

    private void postaviAkcije() {
        chooseSlika = new JButton("Izaberi sliku");
        chooseSlika.addActionListener(e-> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setControlButtonsAreShown(false);
            jFileChooser.setMultiSelectionEnabled(false);
            jFileChooser.setFileFilter(new ImageFilter());
            jFileChooser.showOpenDialog(MainFrame.getInstance());
            if (jFileChooser.getSelectedFile() != null){
                urlSlike = jFileChooser.getSelectedFile().getAbsolutePath();
                previewSlika.setUrlSlike(urlSlike);
                previewSlika.repaint();
                previewSlika.validate();
                jFileChooser.setVisible(false);
            }
        });
        getjToolBar().add(chooseSlika);

        getSaveButton().addActionListener(e -> {
            getSlot().getiSlotHandler().readContent(urlSlike);
            this.dispose();
        });
        getCancelButton().addActionListener(e -> this.dispose());
    }

    private JPanel makeASouthPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(getSaveButton());
        jPanel.add(getCancelButton());
        return jPanel;
    }
}

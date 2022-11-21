package gui.myDialog;

import myComponents.Slot;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyDialogText extends MyDialog{
//    private Slot slot; //sumnjam da ce mi trebati samo sam ga dodala zbog testa, da vidim da li se cuva Content

    private JTextPane jTextPane = new JTextPane();
    private SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
    private StyledDocument doc;

//    private String formattedText;


    public MyDialogText(Frame owner, Slot slot) {
        super(owner, slot);
        jTextPane.setCharacterAttributes(simpleAttributeSet, true);
        makeAToolBar();
        getMainPanel().add(getjToolBar(), BorderLayout.NORTH);
        StyleConstants.setBold(simpleAttributeSet, true);
        jTextPane.setText(slot.getContent().myFormat());
        getMainPanel().add(jTextPane, BorderLayout.CENTER);
        JPanel southJPane = new JPanel();
        poredjajDugmice(southJPane);
        getMainPanel().add(southJPane, BorderLayout.SOUTH);
        this.pack();
    }

    private void makeAToolBar() {
        /**bold**/
        getjToolBar().add(new AbstractAction("Bold") {
            @Override
            public void actionPerformed(ActionEvent e) {
                doc = (StyledDocument) jTextPane.getDocument();
                int selectionEnd = jTextPane.getSelectionEnd();
                int selectionStart = jTextPane.getSelectionStart();
                if (selectionStart == selectionEnd) {
                    return;
                }
                Element element = doc.getCharacterElement(selectionStart);
                AttributeSet as = element.getAttributes();

                MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
                StyleConstants.setBold(asNew, !StyleConstants.isBold(as));
                doc.setCharacterAttributes(selectionStart, jTextPane.getSelectedText()
                        .length(), asNew, true);
            }
        });
        /**italic**/
        getjToolBar().add(new AbstractAction("Italic") {
            @Override
            public void actionPerformed(ActionEvent e) {
                doc = (StyledDocument) jTextPane.getDocument();
                int selectionEnd = jTextPane.getSelectionEnd();
                int selectionStart = jTextPane.getSelectionStart();
                if (selectionStart == selectionEnd) {
                    return;
                }
                Element element = doc.getCharacterElement(selectionStart);
                AttributeSet as = element.getAttributes();

                MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
                StyleConstants.setItalic(asNew, !StyleConstants.isItalic(as));
                doc.setCharacterAttributes(selectionStart, jTextPane.getSelectedText()
                        .length(), asNew, true);
            }
        });
        /**underlined**/
        getjToolBar().add(new AbstractAction("Underline") {
            @Override
            public void actionPerformed(ActionEvent e) {
                doc = (StyledDocument) jTextPane.getDocument();
                int selectionEnd = jTextPane.getSelectionEnd();
                int selectionStart = jTextPane.getSelectionStart();
                if (selectionStart == selectionEnd) {
                    return;
                }
                Element element = doc.getCharacterElement(selectionStart);
                AttributeSet as = element.getAttributes();

                MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
                StyleConstants.setUnderline(asNew, !StyleConstants.isUnderline(as));
                doc.setCharacterAttributes(selectionStart, jTextPane.getSelectedText()
                        .length(), asNew, true);
            }
        });
    }
                                // i ubaci actione za dugmice
    private void poredjajDugmice(JPanel jPanel) {
        jPanel.setLayout(new FlowLayout());
        getSaveButton().addActionListener(e -> {
            getSlot().getiSlotHandler().readContent(jTextPane);

            this.dispose();
        });
        jPanel.add(getSaveButton());
        getCancelButton().addActionListener(e -> this.dispose());
        jPanel.add(getCancelButton());
    }

    public JTextPane getjTextPane() {
        return jTextPane;
    }

    public void setjTextPane(JTextPane jTextPane) {
        this.jTextPane = jTextPane;
    }

    public SimpleAttributeSet getSimpleAttributeSet() {
        return simpleAttributeSet;
    }

    public void setSimpleAttributeSet(SimpleAttributeSet simpleAttributeSet) {
        this.simpleAttributeSet = simpleAttributeSet;
    }


}

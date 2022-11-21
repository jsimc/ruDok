package controller.slotModifier.slotHandler.concrete;

import contents.Content;
import controller.slotModifier.slotHandler.ISlotHandler;
import enums.tipKomponenti.TipSadrzaja;
import myComponents.Slot;

import javax.swing.*;
import java.awt.*;

public class TekstSlotHandler implements ISlotHandler {
    private final String BOLD = "/*";
    private final String ITALIC = "/~";
    private final String UNDERLINED = "/_";

    private Slot slot;

    public TekstSlotHandler(Slot slot) {
        this.slot = slot;
    }

    @Override
    public Content readContent(Object arg) {
        JTextPane jTextPane = (JTextPane) arg;
        Content contn;
        this.slot.setContent(contn = new Content(jTextPane.getText(), TipSadrzaja.TEKST));
        return contn;
    }

    @Override
    public void writeContent(Content content) {

    }

    @Override
    public void paint(Graphics2D g) {
        String tekst = slot.getContent().getText();
        g.drawString(tekst, slot.getX()+slot.getWidth()/2-10, slot.getY()+5);
    }

    private String myReplace(String text) {
        String[] izbaci = {"/", "*", "~", "_"};
        StringBuilder builder = new StringBuilder(text);
        for(int i = 0; i < izbaci.length; i++) {
            int index = builder.indexOf(izbaci[i]);
            while (index != -1) {
                builder.replace(index, index + izbaci[i].length(), "");
                index += izbaci[i].length(); // Move to the end of the replacement
                index = builder.indexOf(izbaci[i], index);
            }
        }
        return builder.toString();
    }
}

package controller.slotModifier.slotHandler.concrete;

import contents.Content;
import controller.slotModifier.slotHandler.ISlotHandler;
import enums.tipKomponenti.TipSadrzaja;
import myComponents.Slot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SlikaSlotHandler implements ISlotHandler {
    private Slot slot;

    public SlikaSlotHandler(Slot slot) {
        this.slot = slot;
    }

    @Override
    public Content readContent(Object arg) {
        //u ovom slucaju object arg je urlSlike u vidu stringa
        Content cntn;
        slot.setContent(cntn = new Content((String)arg, TipSadrzaja.SLIKA));
        return cntn;
    }

    @Override
    public void writeContent(Content content) {

    }

    @Override
    public void paint(Graphics2D g) {
        BufferedImage img = null;
        String urlSlike = slot.getContent().getUrlSlike();
        try {
            if(urlSlike != null) {
                img = ImageIO.read(new File(urlSlike));
            }
        } catch (IOException e) {
        }
        if(img!= null)
            g.drawImage(img,slot.getX(),slot.getY(), img.getWidth()/15, img.getHeight()/15,null);
        else {
            g.setPaint(Color.WHITE);
            g.fillRect(slot.getX(), slot.getY(), slot.getWidth(), slot.getHeight());
        }
    }
}

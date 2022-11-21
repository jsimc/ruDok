package gui.mainview;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {

    private BufferedImage image;
    private String urlSlike;

    public ImagePanel() {
        //nece se nikad desiti, ali -> slika Bjanke
        this.urlSlike = "\"C:\\Users\\Jelena\\Pictures\\BJANKA\\IMG-20210117-WA0020.jpg\"";
    }

    public ImagePanel(String url) {
        this.urlSlike = url;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            if(urlSlike != null) {
                image = ImageIO.read(new File(urlSlike));
            }
        } catch (IOException e) {
        }
        g.drawImage(image,0,0,getWidth(),getHeight(),null);
    }

    public String getUrlSlike() {
        return urlSlike;
    }

    public void setUrlSlike(String urlSlike) {
        this.urlSlike = urlSlike;
    }
}

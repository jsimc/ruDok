package controller;

import javax.swing.*;

public abstract class MyAction extends AbstractAction {
    public ImageIcon loadIcon(String url) {
        ImageIcon img = new ImageIcon(url);

        if (img == null) {
            System.out.println("Greska");
            return null;
        }

        return img;
    }

}

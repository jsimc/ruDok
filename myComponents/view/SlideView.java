package myComponents.view;

import enums.notifikacija.MyNotification;
import controller.slotModifier.mouseSlotController.MouseSlotController;
import myComponents.Prezentacija;
import myComponents.Slide;
import myComponents.Slot;
import observer.IObserver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SlideView extends JPanel implements IObserver {
    private Slide slide;

//    private boolean flag;
    private boolean flag;

    private String urlSlike;

    private JLabel redniBrojLbl;

    private List<SlotView> slotViewList;

    public SlideView(Slide slide) {
        this.slide = slide;
        this.slide.addObserver(this);
        this.slide.getParent().addObserver(this);

        new MouseSlotController(this);

        this.urlSlike = ((Prezentacija)this.slide.getParent()).getPozadinskaSlika();
        this.redniBrojLbl = new JLabel(String.format("%s", this.slide.getRedniBroj()));

        this.slotViewList = new ArrayList<>();
        for(int i = 0; i < slide.getSlots().size(); i++) {
            this.slotViewList.add(new SlotView(slide.getSlots().get(i)));
        }

        this.setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 375));
        setMaximumSize(new Dimension(500, 375));
        add(redniBrojLbl, BorderLayout.SOUTH);
//        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    @Override
    public void updateObserver(Object notification) {
        urlSlike = ((Prezentacija)this.slide.getParent()).getPozadinskaSlika();
        this.redniBrojLbl.setText(String.format("%s", this.slide.getRedniBroj()));

        if(notification instanceof MyNotification) {
            MyNotification mojaNotifikacija = (MyNotification) notification;
            switch (mojaNotifikacija.getEnumNotif()) {
                case DODAVANJE_SLOTA:
                    this.addSlotView(new SlotView((Slot) mojaNotifikacija.getNotification()));
                    break;
                case BRISANJE_SLOTA:
                    this.slotViewList.removeIf(sv -> sv.getSlot().equals(mojaNotifikacija.getNotification()));
                    break;
                case POMERANJE_SLOTA, REPAINT: default:
                    validate();
                    repaint();
                    break;
            }
        }
        slide.setChanged(true);
        validate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage img = null;
        try {
            if(urlSlike == null) {
                urlSlike = "src/src/slike/green_pozadina.png";
            }
            img = ImageIO.read(new File(urlSlike));
        } catch (IOException e) {
        }
        g.drawImage(img,0,0,getWidth(),getHeight(),null);
        //--------------------------------------------------------------

        for(int i = 0; i < slotViewList.size(); i++) {
            if(isFlag()) {
                slotViewList.get(i).paintContent((Graphics2D) g);
            } else {
                ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
                slotViewList.get(i).paint((Graphics2D) g);
            }
        }

    }

    public Slide getSlide() {
        return slide;
    }

    public List<SlotView> getSlotViewList() {
        return slotViewList;
    }

    public void setSlotViewList(List<SlotView> slotViewList) {
        this.slotViewList = slotViewList;
    }

    public void addSlotView(SlotView slotView) {
        this.slotViewList.add(slotView);
        //Ja kacim SlideView da bued observer Slotu
        //kad se desi pomeranje (menjanje pointa) u Slotu
        //odma se ponovo sve iscrtava
        slotView.getSlot().addObserver(this);
    }

    public void removeSlotView(SlotView slotView) {
        this.slotViewList.remove(slotView);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

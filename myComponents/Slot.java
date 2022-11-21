package myComponents;

import contents.Content;
import controller.slotModifier.slotHandler.ISlotHandler;
import controller.slotModifier.slotHandler.concrete.SlikaSlotHandler;
import controller.slotModifier.slotHandler.concrete.TekstSlotHandler;
import enums.notifikacija.MyNotification;
import enums.tipKomponenti.TipSadrzaja;
import gui.mainview.MainFrame;
import observer.IObservable;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Slot extends IObservable implements Serializable {
    @Serial
    private static final long serialVersionUID = 8138761054697080925L;
    private int x;
    private int y;
    private TipSadrzaja tipSadrzaja = TipSadrzaja.TEKST;
    private int height;
    private int width;
    private boolean selected;
    private String name;
    private String description;
    transient private Color color;
    transient private Stroke stroke;

    private Content content;
    private ISlotHandler iSlotHandler;

    public Slot(int x, int y, TipSadrzaja tipSadrzaja) {
        this.x = x;
        this.y = y;
        this.tipSadrzaja = tipSadrzaja==null ? this.tipSadrzaja : tipSadrzaja;
        this.height = 50;
        this.width = 80;
        this.color = MainFrame.getInstance().getColor();
        if(MainFrame.getInstance().isDashed()) {
            this.stroke = new BasicStroke(MainFrame.getInstance().getStrokeDebljina(),
                    BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_MITER,
                    10.0f,
                    new float[] {16.0f, 20.0f},
                    1);
        } else {
            this.stroke = new BasicStroke(MainFrame.getInstance().getStrokeDebljina());
        }
        name = this.tipSadrzaja.equals(TipSadrzaja.TEKST) ? "Tekst" : "Slika";
        if(this.getTipSadrzaja().equals(TipSadrzaja.TEKST)) iSlotHandler = new TekstSlotHandler(this);
        else if(this.getTipSadrzaja().equals(TipSadrzaja.SLIKA)) iSlotHandler = new SlikaSlotHandler(this);
        this.content = new Content("Mama mia pizzeria", this.tipSadrzaja);
    }

    public int getX() {
        return x;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        notifyObservers(new MyNotification(new Point(x, y), MyNotification.Notifikacija.POMERANJE_SLOTA));
    }

    public int getY() {
        return y;
    }

    public TipSadrzaja getTipSadrzaja() {
        return tipSadrzaja;
    }

    public void setTipSadrzaja(TipSadrzaja tipSadrzaja) {
        this.tipSadrzaja = tipSadrzaja;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ISlotHandler getiSlotHandler() {
        return iSlotHandler;
    }

    public void setiSlotHandler(ISlotHandler iSlotHandler) {
        this.iSlotHandler = iSlotHandler;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        if(this.selected) {
            setColor(new Color(255, 16, 240));
        } else {
            setColor(MainFrame.getInstance().getColor());
        }
        notifyObservers(new MyNotification(null, MyNotification.Notifikacija.REPAINT));
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public boolean elementAt(int x, int y) {
        return this.getX() <= x && x <= this.getX()+this.getHeight() &&
                this.getY() <= y && y <= this.getY()+this.getWidth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return x == slot.x && y == slot.y && height == slot.height && width == slot.width && Objects.equals(name, slot.name) && Objects.equals(description, slot.description) && Objects.equals(color, slot.color) && Objects.equals(stroke, slot.stroke);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, height, width, name, description, color, stroke);
    }

    @Override
    public String toString() {
        return "Slot{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

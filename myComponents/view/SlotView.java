package myComponents.view;

import controller.slotModifier.slotHandler.ISlotHandler;
import myComponents.Slot;

import java.awt.*;
import java.util.Objects;

public class SlotView {
    private Slot slot;
    private ISlotHandler iSlotHandler;

    private Shape shape;

    public SlotView(Slot slot) {
        this.slot = slot;
        this.iSlotHandler = slot.getiSlotHandler();
    }

    public void paint(Graphics2D g) {
        g.setPaint(slot.getColor());
        g.setStroke(slot.getStroke());

        shape = new Rectangle(slot.getX(), slot.getY(), slot.getWidth(), slot.getHeight());
        g.draw(shape);
        g.fill(shape);
        g.setPaint(Color.BLACK);
        g.drawString(slot.getName(), slot.getX()+slot.getWidth()/2-10, slot.getY()+5);
    }


    public boolean elementAt(Slot slot, Point position) {
        return this.shape.contains(position);
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlotView slotView = (SlotView) o;
        return Objects.equals(slot, slotView.slot) && Objects.equals(shape, slotView.shape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slot, shape);
    }

    @Override
    public String toString() {
        return slot.toString();
    }

    public void paintContent(Graphics2D g) {
        this.iSlotHandler.paint(g);
    }
}

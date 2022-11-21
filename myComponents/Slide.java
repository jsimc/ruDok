package myComponents;

import enums.notifikacija.MyNotification;
import ruNodeModel.RuNode;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class Slide extends RuNode {
    @Serial
    private static final long serialVersionUID = -8425235950759614197L;
    private int redniBroj;

    private List<Slot> slots;

    public Slide(String name, RuNode parent, int redniBroj) {
        super(name, parent);
        slots = new ArrayList<>();
        this.redniBroj = redniBroj;
    }

    @Override
    public void setParent(RuNode parent) {
        if(parent instanceof Prezentacija) {
            setParent(parent);
        }
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
        notifyObservers(new MyNotification(redniBroj, MyNotification.Notifikacija.POSTAVLJANJE_REDNOG_BROJA));
    }

    public void addSlot(Slot slot) {
        this.slots.add(slot);
        notifyObservers(new MyNotification(slot, MyNotification.Notifikacija.DODAVANJE_SLOTA));
    }

    public void removeSlot(Slot slot) {
        this.slots.remove(slot);
        notifyObservers(new MyNotification(slot, MyNotification.Notifikacija.BRISANJE_SLOTA));
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public Slot getSelectedSlot() {
        for(Slot s : slots) {
            if(s.isSelected()) {
                return s;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "Slide{" +
                "slots=" + slots +
                '}';
    }
}

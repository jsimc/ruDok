package ruNodeModel;

import enums.notifikacija.MyNotification;
import gui.mainview.MainFrame;
import observer.IObservable;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;

public abstract class RuNode extends IObservable implements Serializable {
    @Serial
    private static final long serialVersionUID = 1057738316831544967L;
    private String name;
    private RuNode parent;
    transient private boolean changed;

    public RuNode(String name, RuNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public RuNode getParent() {
        return parent;
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
        notifyObservers(new MyNotification(parent, MyNotification.Notifikacija.POSTAVLJANJE_RODITELJA));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers(new MyNotification(name, MyNotification.Notifikacija.POSTAVLJANJE_IMENA));
    }


    @Override
    public String toString() {
        return name;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        if(this.changed != changed) {
            this.changed = changed;
            //a i na nacin koji je meni pao na pamet(menjanje imena)
            //ali ne radi sa ws iz nekog razloga
            if(changed) {
                this.setName("*"+name);
            } else {
                this.setName(name.substring(1));
            }
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }
    }
}

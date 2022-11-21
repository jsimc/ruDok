package ruNodeModel;

import enums.notifikacija.MyNotification;

import java.util.ArrayList;
import java.util.List;

public abstract class RuNodeComposite extends RuNode{
    private List<RuNode> children;

    public RuNodeComposite(String name, RuNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }

    public void addChild(RuNode child) {
        if(!children.contains(child)) {
            this.children.add(child);
            notifyObservers(new MyNotification(child, MyNotification.Notifikacija.DODAVANJE));
        }
    }

    public void removeChild(RuNode child) {
        children.remove(child);
        notifyObservers(new MyNotification(child, MyNotification.Notifikacija.BRISANJE));
        /**child.setParent(null);*/
    }

    public List<RuNode> getChildren() {
        return children;
    }

    public void setChildren(List<RuNode> children) {
        this.children = children;
    }
}

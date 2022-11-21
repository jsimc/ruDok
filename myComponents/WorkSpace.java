package myComponents;

import ruNodeModel.RuNode;
import ruNodeModel.RuNodeComposite;

import java.io.Serial;

public class WorkSpace extends RuNodeComposite {

    @Serial
    private static final long serialVersionUID = 7469059196880813280L;

    public WorkSpace(String name, RuNode parent) {
        super(name, null);
    }

    @Override
    public RuNode getParent() {
        return null;
    }

    @Override
    public void setParent(RuNode parent) {
        super.setParent(null);
    }
}

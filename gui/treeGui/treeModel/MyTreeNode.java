package gui.treeGui.treeModel;

import error.ErrorFactory;
import myComponents.Slide;
import ruNodeModel.RuNode;
import ruNodeModel.RuNodeComposite;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Vector;

public class MyTreeNode extends DefaultMutableTreeNode {
    private RuNode ruNode;

    public MyTreeNode(RuNode ruNode) {
        this.ruNode = ruNode;
        this.children = new Vector<>();
    }

    public void addChild(MyTreeNode child) {

        if(!this.children.contains(child)) {
            this.children.add(child);
            if (ruNode instanceof Slide) {
                ErrorFactory.getInstance().generateError("Ne moze da se doda na slajd!!!", "Greska Korisnika!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            ((RuNodeComposite) ruNode).addChild(child.getRuNode());
        }
    }

    public void removeChild(MyTreeNode child) {
        if(this.children.contains(child)) {
            this.children.remove(child);
            if (ruNode instanceof Slide) {
                ErrorFactory.getInstance().generateError("Slajd nema dece!!!", "Greska Korisnika!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            ((RuNodeComposite)ruNode).removeChild(child.getRuNode());
        }
    }

    @Override
    public boolean getAllowsChildren() {
        return !(ruNode instanceof Slide);
    }

    @Override
    public boolean isLeaf() {
        return ruNode instanceof Slide;
    }

    public RuNode getRuNode() {
        return ruNode;
    }

    public void setRuNode(RuNode ruNode) {
        this.ruNode = ruNode;
    }

    @Override
    public String toString() {
        return ruNode.getName();
    }

    public Vector<TreeNode> getChildren() {
        return children;
    }
}

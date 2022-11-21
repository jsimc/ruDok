package gui.treeGui.treeModel;

import myComponents.WorkSpace;

import javax.swing.tree.DefaultTreeModel;

public class MyTreeModel extends DefaultTreeModel {

    public MyTreeModel() {
        super(new MyTreeNode(new WorkSpace("Workspace", null)));
    }

}

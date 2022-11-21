package gui.treeGui.treeController;

import myComponents.Slide;
import gui.treeGui.treeModel.MyTreeNode;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class MyTreeSelectionListener implements TreeSelectionListener {
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();

        for(int i = 0; i < path.getPathCount(); i++) {
            if(path.getPathComponent(i) instanceof MyTreeNode && ((MyTreeNode) path.getPathComponent(i)).getRuNode() instanceof Slide) {
                System.out.println("Putanja slajda: " + e.getNewLeadSelectionPath());
            }
        }
    }
}

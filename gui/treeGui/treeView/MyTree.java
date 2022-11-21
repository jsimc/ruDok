package gui.treeGui.treeView;

import gui.treeGui.treeController.MyMouseAction;
import gui.treeGui.treeController.MyTreeCellEdited;
import gui.treeGui.treeController.MyTreeCellRendered;
import gui.treeGui.treeController.MyTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MyTree extends JTree{
    public MyTree() {
        addTreeSelectionListener(new MyTreeSelectionListener());
        setCellEditor(new MyTreeCellEdited(this,new DefaultTreeCellRenderer()));
        setCellRenderer(new MyTreeCellRendered());

        new MyMouseAction(this);
//        addMouseListener(new MyMouseAction(this));
        setEditable(true);
    }

}

package gui.treeGui.treeController;

import myComponents.Prezentacija;
import myComponents.Projekat;
import myComponents.Slide;
import myComponents.WorkSpace;
import gui.treeGui.treeModel.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class MyTreeCellRendered extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        if (value instanceof MyTreeNode) {
            if(((MyTreeNode)value).getRuNode() instanceof WorkSpace) {
                Icon icon = new ImageIcon("src/src/slike/folder.png");
                setIcon(icon);
            } else if(((MyTreeNode)value).getRuNode() instanceof Projekat) {
                Icon icon = new ImageIcon("src/src/slike/document.png");
                setIcon(icon);
            } else if(((MyTreeNode)value).getRuNode() instanceof Prezentacija) {
                Icon icon = new ImageIcon("src/src/slike/presentation.jpg");
                setIcon(icon);
            } else if(((MyTreeNode)value).getRuNode() instanceof Slide) {
                Icon icon = new ImageIcon("src/src/slike/slide.jpg");
                setIcon(icon);
            }
        }

        return this;
    }

}

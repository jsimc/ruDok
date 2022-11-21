package gui.treeGui.treeController;

import gui.mainview.MainFrame;
import myComponents.Projekat;
import gui.treeGui.treeModel.MyTreeNode;
import gui.treeGui.treeView.MyTree;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseAction implements MouseListener {

    private MyTree myTree; // view
    private MyTreeNode myTreeNode; //model???

    public MyMouseAction(MyTree tree) {
        myTree = tree;
        tree.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object o = MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(e.getClickCount() == 2) {
            if(o instanceof MyTreeNode && ((MyTreeNode)o).getRuNode() instanceof Projekat) {
                Projekat p = (Projekat) ((MyTreeNode)o).getRuNode();
                MainFrame.getInstance().getProjekatView().setProjekat(p);
                MainFrame.getInstance().getMyTree().expandPath(MainFrame.getInstance().getMyTree().getSelectionPath());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

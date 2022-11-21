package factory.myComponentsFactory;

import factory.viewFactory.AbstractViewFactory;
import factory.viewFactory.FactoryViewGenerator;
import gui.treeGui.treeModel.MyTreeNode;
import ruNodeModel.RuNode;

import javax.swing.*;

public abstract class AbstractNodeFactory {

    public RuNode getNewRuNode(MyTreeNode selectedMTN) {
        RuNode deteRuNode = createRuNode(selectedMTN.getRuNode());
        AbstractViewFactory abstractViewFactory = FactoryViewGenerator.returnViewFactory(deteRuNode);
        JPanel myView = abstractViewFactory.createMyView(deteRuNode);
        return deteRuNode;
    }

    public abstract RuNode createRuNode(RuNode parent);
}

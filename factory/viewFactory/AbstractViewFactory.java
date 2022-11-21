package factory.viewFactory;

import ruNodeModel.RuNode;

import javax.swing.*;

public abstract class AbstractViewFactory {
    public JPanel getNewView(RuNode ruNode) {
        return createMyView(ruNode);
    }

    public abstract JPanel createMyView(RuNode ruNode);
}

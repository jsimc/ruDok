package factory.viewFactory;

import myComponents.Prezentacija;
import myComponents.view.PrezentacijaView;
import ruNodeModel.RuNode;

import javax.swing.*;

public class PrezentacijaViewFactory extends AbstractViewFactory{
    @Override
    public JPanel createMyView(RuNode ruNode) {
        return new PrezentacijaView((Prezentacija) ruNode);
    }
}

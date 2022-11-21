package factory.viewFactory;

import myComponents.Projekat;
import myComponents.view.ProjekatView;
import ruNodeModel.RuNode;

import javax.swing.*;

public class ProjekatViewFactory extends AbstractViewFactory{
    @Override
    public JPanel createMyView(RuNode ruNode) {
        return new ProjekatView((Projekat) ruNode);
    }
}

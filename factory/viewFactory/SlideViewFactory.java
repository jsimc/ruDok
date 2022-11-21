package factory.viewFactory;

import myComponents.Slide;
import myComponents.view.SlideView;
import ruNodeModel.RuNode;

import javax.swing.*;

public class SlideViewFactory extends AbstractViewFactory{
    @Override
    public JPanel createMyView(RuNode ruNode) {
        return new SlideView((Slide) ruNode);
    }
}

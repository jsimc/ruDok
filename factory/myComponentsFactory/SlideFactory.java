package factory.myComponentsFactory;

import myComponents.Prezentacija;
import myComponents.Slide;
import ruNodeModel.RuNode;

public class SlideFactory extends AbstractNodeFactory{
    @Override
    public RuNode createRuNode(RuNode parent) {
        return new Slide(String.format("Slide " + (((Prezentacija) parent).getChildren().size()+1)),
                parent,
                ((Prezentacija) parent).getChildren().size()+1);
    }
}

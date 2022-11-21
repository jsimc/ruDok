package factory.myComponentsFactory;

import myComponents.Projekat;
import myComponents.WorkSpace;
import ruNodeModel.RuNode;

public class ProjekatFactory extends AbstractNodeFactory{
    @Override
    public RuNode createRuNode(RuNode parent) {
        return new Projekat("Projekat " + (((WorkSpace) parent).getChildren().size()+1), parent);
    }
}

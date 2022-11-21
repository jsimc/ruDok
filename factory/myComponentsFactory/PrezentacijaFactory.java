package factory.myComponentsFactory;

import myComponents.Prezentacija;
import myComponents.Projekat;
import ruNodeModel.RuNode;

public class PrezentacijaFactory extends AbstractNodeFactory{
    @Override
    public RuNode createRuNode(RuNode parent) {
        return new Prezentacija(String.format("Prezentacija " + (((Projekat) parent).getChildren().size()+1)), parent);
    }
}

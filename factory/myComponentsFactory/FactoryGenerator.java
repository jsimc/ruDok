package factory.myComponentsFactory;

import gui.treeGui.treeModel.MyTreeNode;
import myComponents.Prezentacija;
import myComponents.Projekat;
import myComponents.WorkSpace;
import ruNodeModel.RuNode;

public class FactoryGenerator {
    public static AbstractNodeFactory returnNodeFactory(MyTreeNode selected) {
        RuNode selRuNode = selected.getRuNode();
        if(selRuNode instanceof WorkSpace) return new ProjekatFactory();
        if(selRuNode instanceof Projekat) return new PrezentacijaFactory();
        if(selRuNode instanceof Prezentacija) return new SlideFactory();
        return null;
    }
}

package factory.viewFactory;

import myComponents.Prezentacija;
import myComponents.Projekat;
import myComponents.Slide;
import ruNodeModel.RuNode;

public class FactoryViewGenerator {
    public static AbstractViewFactory returnViewFactory(RuNode ruNode) {
        if(ruNode instanceof Projekat) return new ProjekatViewFactory();
        if(ruNode instanceof Prezentacija) return new PrezentacijaViewFactory();
        if(ruNode instanceof Slide) return new SlideViewFactory();
        return null;
    }
}

package myComponents.view;

import enums.notifikacija.MyNotification;
import myComponents.Prezentacija;
import myComponents.Projekat;
import observer.IObserver;
import ruNodeModel.RuNode;

import javax.swing.*;
import java.awt.*;

public class ProjekatView extends JPanel implements IObserver {
    private Projekat projekat;

    private JLabel imeLbl;
    private JTabbedPane prezentacijeTabbedPane;

    public ProjekatView() {
        imeLbl = new JLabel();
        prezentacijeTabbedPane = new JTabbedPane();

        setLayout(new BorderLayout());

        add(imeLbl, BorderLayout.NORTH);
        add(prezentacijeTabbedPane, BorderLayout.CENTER);
    }

    public ProjekatView(Projekat projekat) {
//        (Projekat) ((MyTreeNode)myTree.getLastSelectedPathComponent()).getRuNode()
        this();
        this.projekat = projekat;
        this.projekat.addObserver(this);
    }

    @Override
    public void updateObserver(Object notification) {
        if(notification instanceof MyNotification) {
            MyNotification mojaNotifikacija = (MyNotification) notification;
            switch(mojaNotifikacija.getEnumNotif()) {
                case BRISANJE:
                    if(mojaNotifikacija.getNotification() instanceof Prezentacija) {
                        for(Component component : prezentacijeTabbedPane.getComponents()) {
//                            System.out.println("da li je component == prezentacija > " +
//                                    component.equals(((Prezentacija) mojaNotifikacija.getNotification()).getSubscribers().get(0)));
                            if(component instanceof PrezentacijaView &&
                            component.equals(((Prezentacija) mojaNotifikacija.getNotification()).getSubscribers().get(0))) {
                                prezentacijeTabbedPane.remove(component);
//                                System.out.println("Obrisalo");
                            }
                        }
                    }
                    break;
                case DODAVANJE:
                    prezentacijeTabbedPane.removeAll();
                    for(RuNode prezentacija : this.projekat.getChildren()) {
                        if (prezentacija instanceof Prezentacija) {
                            prezentacijeTabbedPane.addTab(prezentacija.getName(), (PrezentacijaView) prezentacija.getSubscribers().get(0));
                        }
                    }
                    break;
                case POSTAVLJANJE_IMENA:
                    imeLbl.setText(mojaNotifikacija.getNotification().toString());
                    break;
                default:
                    break;
            }
        }
        projekat.setChanged(true);
    }

    public Projekat getProjekat() {
        return projekat;
    }

    public void setProjekat(Projekat projekat) {
        this.projekat = projekat;

        prezentacijeTabbedPane.removeAll();

        if (this.projekat != null) {
            this.projekat.addObserver(this);
            imeLbl.setText(projekat.getName());
            for(RuNode prezentacija : this.projekat.getChildren()) {
                if(prezentacija instanceof Prezentacija) {
                    prezentacijeTabbedPane.addTab(prezentacija.getName(), (PrezentacijaView) prezentacija.getSubscribers().get(0));
                }
            }
        } else {
            imeLbl.setText("Prazno");
        }
    }

    public JLabel getImeLbl() {
        return imeLbl;
    }

    public void setImeLbl(JLabel imeLbl) {
        this.imeLbl = imeLbl;
    }

    public JTabbedPane getPrezentacijeTabbedPane() {
        return prezentacijeTabbedPane;
    }

    public void setPrezentacijeTabbedPane(JTabbedPane prezentacijeTabbedPane) {
        this.prezentacijeTabbedPane = prezentacijeTabbedPane;
    }
}

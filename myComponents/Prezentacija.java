package myComponents;

import enums.notifikacija.MyNotification;
import error.ErrorFactory;
import ruNodeModel.RuNode;
import ruNodeModel.RuNodeComposite;

import javax.swing.*;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class Prezentacija extends RuNodeComposite {

    @Serial
    private static final long serialVersionUID = -3965157157268078548L;
    private String autor;
    private String pozadinskaSlika = "src/src/slike/green_pozadina.png";

    private List<Projekat> deljeno = new ArrayList<>(); //projekti sa kojim je deljena prezentacija.
    private boolean isDeljena;

    public Prezentacija(String name, RuNode parent) {
        super(name, parent);
        this.deljeno.add((Projekat) parent);
    }
    public Prezentacija(String name, RuNode parent, String autor) {
        super(name, parent);
        this.autor = autor;
        this.deljeno.add((Projekat) parent);
    }
    public Prezentacija(String name, RuNode parent, String autor, String pozadinskaSlika) {
        super(name, parent);
        this.autor = autor;
        this.pozadinskaSlika = pozadinskaSlika;
        this.deljeno.add((Projekat) parent);
    }

    @Override
    public void addChild(RuNode child) {
        if(child instanceof Slide && !getChildren().contains(child)) {
            super.addChild(child);
            for(int i = 0; i < this.getChildren().size(); i++) {
                ((Slide)this.getChildren().get(i)).setRedniBroj(i+1);
            }
        }
    }

    @Override
    public void removeChild(RuNode child) {
        super.removeChild(child);
        for(int i = 0; i < this.getChildren().size(); i++) {
            ((Slide)this.getChildren().get(i)).setRedniBroj(i+1);
        }
    }

    @Override
    public void setChildren(List<RuNode> children) {
        for(RuNode object : children) {
            if(!(object instanceof Slide)) {
                ErrorFactory.getInstance().generateError("Deca prezentacije mogu biti samo slajdovi!!!", "GRESKA!!!", JOptionPane.ERROR);
//                System.out.println("Deca prezentacije mogu biti samo slajdovi!!!");
                return;
            }
        }
        super.setChildren(children);
    }

    @Override
    public void setParent(RuNode parent) {
        if(parent instanceof Projekat) {
            super.setParent(parent);
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if(autor == null || autor.equals("")) {
            ErrorFactory.getInstance().generateError("Autor ne sme biti prezan string", "GRESKA!!!", JOptionPane.ERROR);
            //treba da se ispise greska za autora
//            System.out.println("Autor ne sme biti prezan string");
            return;
        }
        this.autor = autor;
        notifyObservers(new MyNotification(autor, MyNotification.Notifikacija.POSTAVLJANJE_AUTORA));
    }

    public String getPozadinskaSlika() {
        return pozadinskaSlika;
    }

    public void setPozadinskaSlika(String pozadinskaSlika) {
        if(pozadinskaSlika == null || pozadinskaSlika.equals("")) {
            ErrorFactory.getInstance().generateError("Pozadinska slika ne sme biti neoznacena", "GRESKA!!!", JOptionPane.ERROR);
            return;
        }
        this.pozadinskaSlika = pozadinskaSlika;
        notifyObservers(new MyNotification(pozadinskaSlika, MyNotification.Notifikacija.POSTAVLJANJE_POZADINSKE_SLIKE));
    }

    public boolean isDeljena() {
        return isDeljena;
    }

    public void setDeljena(boolean deljena) {
        isDeljena = deljena;
    }

    public List<Projekat> getDeljeno() {
        return deljeno;
    }

    public void addDeljeno(Projekat projekat) {
        if(!this.deljeno.contains(projekat)) {
            this.deljeno.add(projekat);
            setDeljena(true);
            projekat.addChild(this); //na projekat dodajemo ovu presentaciju kao dete
            projekat.setHasDeljeno(true);
        }
        if(deljeno.size()!=1) {
            //TODO promena ikonice, ili imena
            // ukoliko IMA deljenja
        }
    }

    public void removeFromDeljeno(Projekat projekat) {
        if(this.deljeno.contains(projekat)) {
            this.deljeno.remove(projekat);
            projekat.removeChild(this);
            if(!projekat.isHasDeljeno()) {
                projekat.setHasDeljeno(false);
            }
        }
        if(deljeno.size()==1) {
            setDeljena(false);
            //TODO promena ikonice, ili imena
            // ukoliko NEMA deljenja, tj vracanje na staro
        }
    }

    public Slot getSelectedSlot() {
        for(RuNode child : this.getChildren()) {
            if(((Slide)child).getSelectedSlot() != null) {
                //vraća prvi selektovani slot među svim slajdovima
                return ((Slide)child).getSelectedSlot();
            }
        }
        ErrorFactory.getInstance().generateError("Nijedan slot nije selektovan!", "Nema selekcije",
                JOptionPane.ERROR_MESSAGE);
        return null;
    }
}

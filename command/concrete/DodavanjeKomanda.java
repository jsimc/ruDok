package command.concrete;

import command.MojaKomanda;
import factory.myComponentsFactory.AbstractNodeFactory;
import gui.mainview.MainFrame;
import gui.treeGui.treeModel.MyTreeNode;
import myComponents.Prezentacija;
import myComponents.Projekat;
import ruNodeModel.RuNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


//u Konstruktor ove klase prosledjujem roditelja, ali radim sa decom, tako da za
//doCommand pravim dete ukoliko vec nije napravljeno i dodajem kao dete od parenta,
// a za undo ga brisem kao dete od parenta, ali necu ga brisati (u smislu da prestane da postoji).
public class DodavanjeKomanda implements MojaKomanda {

    private MyTreeNode myTreeNodeParent;
    private List<MyTreeNode> myTreeNodeRoditelji = new ArrayList<>();
    private RuNode ruNodeParent;
    private AbstractNodeFactory abstractNodeFactory;

    private RuNode ruNodeDete;
    private MyTreeNode myTreeNodeDete;
    private List<MyTreeNode> myTreeNodeDeca = new ArrayList<>();

    public DodavanjeKomanda(MyTreeNode myTreeNode, AbstractNodeFactory anf) {
        this.myTreeNodeParent = myTreeNode;
        this.ruNodeParent = this.myTreeNodeParent.getRuNode();
        this.abstractNodeFactory = anf;
    }

    @Override
    public void doCommand() {
        if(ruNodeDete == null) {
            ruNodeDete = abstractNodeFactory.getNewRuNode(myTreeNodeParent);

            if(ruNodeParent instanceof Prezentacija && ((Prezentacija) ruNodeParent).isDeljena()) {
                Prezentacija prezentacija = (Prezentacija) ruNodeParent;
                //pravimo mtnDece onoliko koliko puta je prezentacija deljena
                for(int i = 0; i < prezentacija.getDeljeno().size(); i++) {
                    myTreeNodeDeca.add(new MyTreeNode(ruNodeDete));
                }

            } else {
                //samo jedan primerak;
                myTreeNodeDete = new MyTreeNode(ruNodeDete);
            }
        }
        if(ruNodeParent instanceof Prezentacija && ((Prezentacija) ruNodeParent).isDeljena()) {
            potraziMtnProjekat();
        } else {
            myTreeNodeParent.addChild(myTreeNodeDete);
            myTreeNodeDete.setParent(myTreeNodeParent);
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

    @Override
    public void undoCommand() {
        if(ruNodeParent instanceof Prezentacija && ((Prezentacija) ruNodeParent).isDeljena()) {
            for(int i = 0; i < myTreeNodeRoditelji.size(); i++) {
                myTreeNodeRoditelji.get(i).removeChild(myTreeNodeDeca.get(i));
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
            }
        } else {
            myTreeNodeParent.removeChild(myTreeNodeDete);
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

    public MyTreeNode getMyTreeNodeParent() {
        return myTreeNodeParent;
    }

    public RuNode getRuNodeParent() {
        return ruNodeParent;
    }

    public List<MyTreeNode> getMyTreeNodeDeca() {
        return myTreeNodeDeca;
    }

    public void setMyTreeNodeDeca(List<MyTreeNode> myTreeNodeDeca) {
        this.myTreeNodeDeca = myTreeNodeDeca;
    }

    public void potraziMtnProjekat() {
        /**prolazim kroz sve mtnProjekte*/
        for(int i = 0; i < ((MyTreeNode)MainFrame.getInstance().getMyTreeModel().getRoot()).getChildCount(); i++)  {
            /**proveravam da li moja prezentacija sadrzi neki od tih projekata kao deljen (tj. kao parenta),
             * tj da li je deljena u nekom od projekata a jedan od tih je sigurno njen roditeljski cvor **/
            MyTreeNode childAt = (MyTreeNode) ((MyTreeNode)MainFrame.getInstance().getMyTreeModel().getRoot()).getChildAt(i);
            if(((Prezentacija) ruNodeParent).getDeljeno().contains(
                    (Projekat) childAt.getRuNode())) {
                /**ako jeste onda prolazim kroz mtnDecu tog projektaMtn i nalazim onaj TreeNode koji wrappuje moju prezentaciju
                 * na taj MtnPrezentacija dodajem deteMtn od novog slajda**/
                for(int j = 0; j < childAt.getChildCount(); j++) {
                    //prezentacijaMtn             //prezentacija na koju se dodaje
                    if(((MyTreeNode)childAt.getChildAt(j)).getRuNode().equals(ruNodeParent)) {
                        ((MyTreeNode) childAt.getChildAt(j)).addChild(myTreeNodeDeca.get(j)); //dodajemo mtnDete na mtnPrezentaciju
                        myTreeNodeDeca.get(j).setParent((MyTreeNode)childAt.getChildAt(j)); //dodajemo tu prezentaciju kao roditelja mtnSlajda
                        myTreeNodeRoditelji.add((MyTreeNode) childAt.getChildAt(j)); //pravimo roditelje prezentacije da znamo kako da brisemo posle
                        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
                    }
                }
            }
        }
    }
}

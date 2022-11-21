package command.concrete;

import command.MojaKomanda;
import gui.mainview.MainFrame;
import gui.treeGui.treeModel.MyTreeNode;
import myComponents.Prezentacija;
import myComponents.Slide;
import ruNodeModel.RuNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


//cuva cvor koji se obrisao
public class BrisanjeKomanda implements MojaKomanda {
    private MyTreeNode obrisaniMTN;
    private MyTreeNode roditeljObrisanogMTN;

    private RuNode obrisaniRuNode;
    private RuNode roditeljObrisanogRuNode;

    private List<MyTreeNode> obrisaniMtnovi = new ArrayList<>();
    private List<MyTreeNode> roditeljiMtnovi = new ArrayList<>();


    public BrisanjeKomanda(MyTreeNode myTreeNode) {
        obrisaniMTN = myTreeNode;
        roditeljObrisanogMTN = (MyTreeNode) obrisaniMTN.getParent();
        roditeljObrisanogRuNode = roditeljObrisanogMTN.getRuNode();
        obrisaniRuNode = obrisaniMTN.getRuNode();
    }

    @Override
    public void doCommand() {
        if(obrisaniMTN.getRuNode().equals(MainFrame.getInstance().getProjekatView().getProjekat())) {
            MainFrame.getInstance().getProjekatView().setProjekat(null);
        }
        if(obrisaniRuNode instanceof Prezentacija &&
                ((Prezentacija)obrisaniMTN.getRuNode()).isDeljena()) {
            obrisiIzMtnProjekta();
        } else if(obrisaniRuNode instanceof Slide && ((Prezentacija)roditeljObrisanogRuNode).isDeljena()) {
            obrisiIzMtnPrezentacije();
        } else {
            roditeljObrisanogMTN.removeChild(obrisaniMTN);
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

    @Override
    public void undoCommand() {
        if((obrisaniMTN.getRuNode() instanceof Prezentacija && ((Prezentacija)obrisaniRuNode).isDeljena()) ||
                (obrisaniMTN.getRuNode() instanceof Slide) && ((Prezentacija)roditeljObrisanogRuNode).isDeljena()) {
            for(int i = 0; i < roditeljiMtnovi.size(); i++) {
                roditeljiMtnovi.get(i).addChild(obrisaniMtnovi.get(i));
                obrisaniMtnovi.get(i).setParent(roditeljiMtnovi.get(i));
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
            }
        } else {
            roditeljObrisanogMTN.addChild(obrisaniMTN);
            obrisaniMTN.setParent(roditeljObrisanogMTN);
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

    public MyTreeNode getObrisaniMTN() {
        return obrisaniMTN;
    }

    public MyTreeNode getRoditeljObrisanogMTN() {
        return roditeljObrisanogMTN;
    }

    //TODO kolko tolko raaaadi
    private void obrisiIzMtnProjekta() {
        /**prolazim kroz sve mtnProjekte*/
        for(int i = 0; i < ((MyTreeNode)MainFrame.getInstance().getMyTreeModel().getRoot()).getChildCount(); i++)  {
            MyTreeNode projekatMtn = (MyTreeNode) ((MyTreeNode) MainFrame.getInstance().getMyTreeModel().getRoot()).getChildAt(i);
            /** Prolazimo kroz decu projekta koji je treeNode
             * i proveravamo da li je neko njegovo dete wrapper za prezentaciju koju brisemo.
             * ako jeste obrisemo prezentacijuMtn
             */
            for(int j = 0; j < projekatMtn.getChildCount(); j++) {
                if(((MyTreeNode)projekatMtn.getChildAt(j)).getRuNode().equals(obrisaniRuNode)) {
                    MyTreeNode obrisanaPrez = (MyTreeNode)projekatMtn.getChildAt(j);
                    obrisaniMtnovi.add(obrisanaPrez);
                    roditeljiMtnovi.add(projekatMtn);
                    projekatMtn.removeChild(obrisanaPrez);
                    SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
                }
            }

        }
    }

    private void obrisiIzMtnPrezentacije() {
        /** prolazim kroz sve mtnProjekte */
        for(int i = 0; i < ((MyTreeNode)MainFrame.getInstance().getMyTreeModel().getRoot()).getChildCount(); i++) {
            MyTreeNode projekatMtn = (MyTreeNode) ((MyTreeNode) MainFrame.getInstance().getMyTreeModel().getRoot()).getChildAt(i);
//            System.out.println("projekatMtn : " + projekatMtn);
            /** prolazim kroz sve mtnPrezentacije od datog mtnProjekta*/
            for(int j = 0; j < projekatMtn.getChildCount(); j++) {
                MyTreeNode prezentacijaMtn = (MyTreeNode) projekatMtn.getChildAt(j);
                /** proveravam da li je to ta deljena prezentacija */
                if(prezentacijaMtn.getRuNode().equals(roditeljObrisanogMTN.getRuNode())) {
                    roditeljiMtnovi.add(prezentacijaMtn);
//                    System.out.println("\tPrezentacijaMtn: " + prezentacijaMtn);
                    for(int k = 0; k < prezentacijaMtn.getChildCount(); k++) {
                        MyTreeNode slideMtn = (MyTreeNode) prezentacijaMtn.getChildren().get(k);
                        if(slideMtn.getRuNode().equals(obrisaniMTN.getRuNode())) {
                            System.out.println("Slide: " + slideMtn + " Prezentacija: " + prezentacijaMtn);
                            obrisaniMtnovi.add(slideMtn);
                            prezentacijaMtn.removeChild(slideMtn); /** brisem slajd iz te prezentacije **/
                            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
                        }
                    }
                }
            }
        }
    }
}

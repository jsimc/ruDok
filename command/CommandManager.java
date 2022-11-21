package command;

import gui.mainview.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private List<MojaKomanda> komande = new ArrayList<>();

    private int currentCommand = 0;

    /*
     * Dodaje novu komandu na stek i poziva izvršavanje komande
     */
    public void addCommand(MojaKomanda command){
        while(currentCommand < komande.size())
            komande.remove(currentCommand);
        komande.add(command);
        //ne mora odmah da se pise doCommand
        //Komanda MOZE da stoji na steku i da ceka svoj red kad treba da se izvrsi
        //u nasem slucaju radimo odmah komandu cim se desi
        doCommand();
    }

    /*
     * Metoda koja poziva izvršavanje konkretne komande
     */
    public void doCommand(){
        if(currentCommand < komande.size()){
            komande.get(currentCommand++).doCommand();
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
        }
        if(currentCommand==komande.size()){
            MainFrame.getInstance().getActionManager().getDoAction().setEnabled(false);
        }
    }

    /*
     * Metoda koja poziva redo konkretne komande
     */
    public void undoCommand(){
        if(currentCommand > 0){
            MainFrame.getInstance().getActionManager().getDoAction().setEnabled(true);
            komande.get(--currentCommand).undoCommand();
        }
        if(currentCommand==0){
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
        }
    }

}

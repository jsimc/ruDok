package myComponents;

import error.ErrorFactory;
import ruNodeModel.RuNode;
import ruNodeModel.RuNodeComposite;

import javax.swing.*;
import java.io.File;
import java.io.Serial;
import java.util.List;

public class Projekat extends RuNodeComposite {
    @Serial
    private static final long serialVersionUID = -7820286689652987008L;

    private File projectFile;

    private boolean hasDeljeno;

    public Projekat(String name, RuNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if(child instanceof Prezentacija && !getChildren().contains(child)) {
            super.addChild(child);
        }
    }

    @Override
    public void setChildren(List<RuNode> children) {
        for(RuNode object : children) {
            if(!(object instanceof Prezentacija)) {
                ErrorFactory.getInstance().generateError("Deca projekta mogu biti samo prezentacije!!!", "GRESKA!!!", JOptionPane.ERROR);
                return;
            }
        }
        super.setChildren(children);
    }


    @Override
    public void setParent(RuNode parent) {
        if(parent instanceof WorkSpace) {
            super.setParent(parent);
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public File getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }

    public boolean isHasDeljeno() {
        for(RuNode dete : this.getChildren()) {
            if(!((Prezentacija)dete).getDeljeno().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void setHasDeljeno(boolean hasDeljeno) {
        this.hasDeljeno = hasDeljeno;
    }


}

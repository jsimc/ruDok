package serialization;

import myComponents.Projekat;
import ruNodeModel.RuNode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serijalizacija {

    public static void writeToFile(RuNode ruNode) throws IOException {
        Projekat p = (Projekat) ruNode;
        if(p.getProjectFile() == null) {
            p.setProjectFile(new File(ruNode.getName() + ".bin"));
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(p.getProjectFile()));
        objectOutputStream.writeObject(ruNode);
    }

    public static void readFromFile() {
        //standardni txt fajl za workspace: workspace.txt

    }

}

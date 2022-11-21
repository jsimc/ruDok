package fileFilter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class MyFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return (f.isDirectory() ||
                f.getName().toLowerCase().endsWith(".rdpf"));
    }

    @Override
    public String getDescription() {
        return "RuDok Project Files (*.rdpf)";
    }
}

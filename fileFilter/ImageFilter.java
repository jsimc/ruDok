package fileFilter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ImageFilter extends FileFilter {

        @Override
        public boolean accept(File pathname) {
            String filename = pathname.getName();
            if (pathname.isDirectory()) {
                return true;

            } else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg") ||
                    filename.endsWith(".png") || filename.endsWith(".img")) {
                return true;
            } else {
                return false;
            }
        }

    @Override
    public String getDescription() {
            StringBuilder sb = new StringBuilder();
            sb.append("Picture files: ").append(".jpg, ").append(".img, ")
                    .append(".jpeg, or ").append(".png");
        return sb.toString();
    }
}

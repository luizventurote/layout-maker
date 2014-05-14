package control;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import model.FileManager;

public class FileManagerControl {

    public static File FileChooser(Component comp) throws Exception {

        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(comp);
        return jfc.getSelectedFile();

    }

    public void saveFileInBuild(File file) throws Exception {

        // Destination folder
        File file_dest = new File(FileManager.getPath_build() + file.getName());

        // Copy the file to the folder
        FileManager.copyFile(file, file_dest);

    }

    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
    

}

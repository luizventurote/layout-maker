package model;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import javax.swing.JFileChooser;

public abstract class FileManager {

    private final static String path = "files/";
    private final static String path_build = path + "build/";
    private final static String path_framework = path + "framework/";
    private final static String path_layout = path + "layout/";

    public static String getPath() {
        return path;
    }

    public static String getPath_build() {
        return path_build;
    }

    public static String getPath_framework() {
        return path_framework;
    }

    public static String getPath_layout() {
        return path_layout;
    }
    
    public static void readFile(String file) {

    }

    public static void writeFile(String file) {

    }

    public static void copyFile(File source, File destination) throws IOException {
        if (destination.exists()) {
            destination.delete();
        }

        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;

        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen()) {
                sourceChannel.close();
            }
            if (destinationChannel != null && destinationChannel.isOpen()) {
                destinationChannel.close();
            }
        }
    }

    public static void copyDirectory(File srcDir, File dstDir) throws IOException {
        if (srcDir.isDirectory()) {
            if (!dstDir.exists()) {
                dstDir.mkdir();
            }
            String[] children = srcDir.list();
            for(int i = 0; i < children.length; i++) {
                copyDirectory(new File(srcDir, children[i]),
                        new File(dstDir, children[i]));
            }
        } else {
            copyFile(srcDir, dstDir);
        }
    }
    
    public static File FileChooser(Component comp) throws Exception {
        
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(comp);
            return jfc.getSelectedFile();
           
    }

}

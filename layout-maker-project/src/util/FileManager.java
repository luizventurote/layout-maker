package util;

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

    public static void copyFile(File source, String destination) throws IOException {

        // Destination folder
        File file_dest = new File(destination + source.getName());

        if (file_dest.exists()) {
            file_dest.delete();
        }

        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;

        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(file_dest).getChannel();
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

    public static void copyFile(File source, String destination, String new_name) throws IOException {

        // Destination folder
        File file_dest = new File(destination + new_name);

        if (file_dest.exists()) {
            file_dest.delete();
        }

        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;

        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(file_dest).getChannel();
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
            for (int i = 0; i < children.length; i++) {
                copyDirectory(new File(srcDir, children[i]),
                        new File(dstDir, children[i]));
            }
        } else {
            copyFile(srcDir, dstDir);
        }
    }

    public static void renameFile(File file, String new_name) throws IOException {

        FileManager.copyFile(file, file.getParent() + "\\", new_name);

    }

    /**
     * Apaga um diretório
     *
     * @param dir
     * @return
     */
    public static void deleteDir(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                deleteDir(file);
            }
        }
        dir.delete();
    }

    /**
     * Abre uma janela para seleção de um arquivo
     *
     * @param comp
     * @return
     * @throws Exception
     */
    public static File FileChooser(Component comp) throws Exception {

        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(comp);
        return jfc.getSelectedFile();
    }

    /**
     * Abre uma janela para seleção de um diretório
     *
     * @param comp
     * @return
     * @throws Exception
     */
    public static File FileDirectory(Component comp) throws Exception {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Selecione uma pasta");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(comp) == JFileChooser.APPROVE_OPTION) {
            
            return chooser.getSelectedFile();
            
        } else {
           
            return null;
           
        }
        
    }

    /**
     * Pega a extensão do arquivo
     *
     * @param file
     * @return
     */
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

}

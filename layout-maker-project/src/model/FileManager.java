package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static model.Arquivo.copyFile;

public class FileManager {

    private final static String path = "files/";
    private final static String path_build = path + "build/";
    private final static String path_framework = path + "framework/";
    private final static String path_layout = path + "layout/";

    public static void readFile(String file) {

    }

    public static void writeFile(String file) {

    }

//    public static void copyFile(String input, String output) throws IOException {
//
//        FileInputStream in = null;
//        FileOutputStream out = null;
//
//        try {
//
//            in = new FileInputStream(input);
//            out = new FileOutputStream(output);
//
//            int c;
//            while ((c = in.read()) != -1) {
//                out.write(c);
//            }
//
//        } finally {
//
//            if (in != null) {
//                in.close();
//            }
//
//            if (out != null) {
//                out.close();
//            }
//        }
//    }
//
//    public static void copyFileToLayout(String name, String file_path) throws IOException {
//
//        String output = path_layout + name;
//
//        copyFile(file_path, output);
//
//    }

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
            // Este método está implementado na dica – Copiando um arquivo utilizando o Java
            copyFile(srcDir, dstDir);
        }
    }

}

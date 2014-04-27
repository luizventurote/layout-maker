package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {

    public static void readFile(String file) {

    }

    public static void writeFile(String file) {

    }

    public static void copyFile(String input, String output) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            
            in = new FileInputStream(input);
            out = new FileOutputStream(output);

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            
        } finally {
            
            if (in != null) {
                in.close();
            }
            
            if (out != null) {
                out.close();
            }  
        }
    }
    
}

package runner;

import config.StartUp;
import errorControl.ErrorMessenger;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author pvmeira
 */
public class Runner {

    public static void main(String[] args) {
        StartUp s = new StartUp();
       final String CC = "file";
       final String FILE_NAME = "file0";
        final String EXT = ".txt";

        try {
            for (int i = 1; i <= 4; i++) {
                String doc = CC + System.getProperty("file.separator") + FILE_NAME + i + EXT;
                s.readDocument(doc);
            }


        } catch (FileNotFoundException e) {
            System.out.println(ErrorMessenger.ERROR_MESSAGE + e.getMessage().toUpperCase().toString());
        } catch (IOException e) {
            System.out.println(ErrorMessenger.ERROR_MESSAGE + e.getMessage().toUpperCase().toString());
        }
    }
}

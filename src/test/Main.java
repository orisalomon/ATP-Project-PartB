package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        try (OutputStream output = new FileOutputStream("C:\\Users\\Ori\\IdeaProjects\\ATP-Project-PartB\\resources\\config.properties")) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("threadPoolSize", "4");
            prop.setProperty("mazeGeneratingAlgorithm", "My");
            prop.setProperty("mazeSearchingAlgorithm", "BFS");

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
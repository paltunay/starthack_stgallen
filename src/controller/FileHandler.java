package controller;

import model.Suggestion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.io.*;

public class FileHandler {

    public static void saveData(Map<String, Suggestion> data) {
        try {
            File suggestionData = new File("suggestionData");
            FileOutputStream fileOut = new FileOutputStream(suggestionData);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            objOut.writeObject(data);
            //objOut.flush();
            objOut.close();
            fileOut.close();
        } catch (Exception e) {
            System.out.println("test");
            System.out.println(e.getMessage());
        }
    }

    public static Map<String, Suggestion> readData() {
        Map<String, Suggestion> map = new HashMap<String, Suggestion>();
        try {
            File suggestionData = new File("suggestionData");
            FileInputStream fileIn = new FileInputStream(suggestionData);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            map = (HashMap) objIn.readObject();
        } catch (Exception e) {
            System.out.println("test");
            System.out.println(e.getMessage());
        }

        return map;
    }

}

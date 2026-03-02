package com.smkrvasu.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileIO {
    public static void main(String[] args) {
        String fileName = "example.txt";
        String copyFileName = "copy_example.txt";

        String filePath = createFile(fileName);
        writeFile(filePath, "data");
        readFileLine(filePath);
        copyFile(filePath, copyFileName);
    }

    private static void copyFile(String filePath, String copyFileName) {
        try {
            Files.copy(Paths.get(filePath), Paths.get(copyFileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    private static void readFileLine(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    private static void writeFile(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    private static String createFile(String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile())
                System.out.println("new file created");
            else
                System.out.println("file exists");
            return file.getAbsolutePath();
        } catch (IOException e) {
            System.out.println("Error");
        }
        return null;
    }
}

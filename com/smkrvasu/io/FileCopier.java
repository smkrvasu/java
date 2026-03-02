package com.smkrvasu.io;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopier {
    public static void main(String[] args) {

        List<String[]> files = List.of(
                new String[]{"example.txt", "copy_example.txt"},
                new String[]{"example1.txt", "copy_example1.txt"}
        );

        try (ExecutorService e = Executors.newVirtualThreadPerTaskExecutor()) {
            for (String[] arr : files) {
                e.submit(new CopyFile(arr[0], arr[1]));
            }
        }
    }
}

class CopyFile implements Runnable {
    private final String source;
    private final String destination;

    public CopyFile(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void run() {
        try {
            Files.copy(Paths.get(source), Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
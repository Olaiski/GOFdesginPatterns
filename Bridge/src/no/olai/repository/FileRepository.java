package no.olai.repository;

import no.olai.LogMessage;

import java.io.*;

public class FileRepository implements StorageRepository {

    private final String FILE_NAME = "log.txt";

    @Override
    public void store(LogMessage message) {

        try (Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_NAME, true)))) {
            w.write(message + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

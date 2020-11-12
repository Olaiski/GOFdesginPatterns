package no.olai.strategy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFile implements FileStrategy {

    private final File FILE;
    private String content;

    public TextFile(File file) {
        this.FILE = file;
    }

    @Override
    public void read() {

        try(BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            int i = 1;
            while (line != null) {
                sb.append(i).append(" ").append(line).append(System.lineSeparator());
                line = br.readLine();
                i++;
            }
            content = sb.toString();

        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }


    }

    @Override
    public String display() {
        return content;
    }

    @Override
    public long getSize() {
        return FILE.length();
    }
}

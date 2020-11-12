package no.olai.strategy;

import java.io.File;
import java.util.ArrayList;

public class DirFile implements FileStrategy {

    private final File FILE;
    private final ArrayList<File> FILE_LIST = new ArrayList<>();
    private long size = 0;


    public DirFile(File file) {
        this.FILE = file;
    }

    @Override
    public void read() {
        readRecursive(FILE);
    }

    private long readRecursive(File file) {
        size = 0;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; files != null && i < files.length; i++) {
                FILE_LIST.add(files[i]);
                size += readRecursive(files[i]);
            }
        }
        else
            size += file.length();


        return size;
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        for (File f : FILE_LIST)
            sb.append(f).append("\n");

        return sb.toString();
    }

    @Override
    public long getSize() {
        return size;
    }
}

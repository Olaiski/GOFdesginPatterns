package no.olai.strategy;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZIPFile implements FileStrategy {

    private final static Long MILLS_IN_DAY = 86400000L;
    private final File FILE;
    private final ArrayList<ZipEntry> ZIP_LIST = new ArrayList<>();
    long size = 0;

    public ZIPFile(File file) {
        this.FILE = file;
    }

    @Override
    public void read() {

        try (FileInputStream fis = new FileInputStream(FILE);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ZipInputStream zis = new ZipInputStream(bis)) {

            ZipEntry zipEntry;

            while ((zipEntry = zis.getNextEntry()) != null) {
                ZIP_LIST.add(zipEntry);
                size = zipEntry.getSize();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        for (ZipEntry ze : ZIP_LIST)
            sb.append(String.format("File: %s [Size: %d Last Modified %s] %n",
                    ze.getName(), ze.getSize(),
                    LocalDate.ofEpochDay(ze.getTime() / MILLS_IN_DAY)));



        return sb.toString();
    }

    @Override
    public long getSize() {
        return size;
    }
}

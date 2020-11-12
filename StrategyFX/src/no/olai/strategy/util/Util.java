package no.olai.strategy.util;

import java.text.DecimalFormat;

public final class Util {

    /** Util. method, formats the file size to a readable string
     *
     * @param size File size
     * @return Readable size format, based on size.
     */
    public static String readableFormat(long size) {

        String[] units = {"B", "KB", "MB", "GB", "TB"};
        int unitIndex = (int) (Math.log10(size) / 3);
        double unitValue = 1 << (unitIndex * 10);

        return new DecimalFormat("#,##0.#")
                .format(size / unitValue) + " "
                + units[unitIndex];
    }
}

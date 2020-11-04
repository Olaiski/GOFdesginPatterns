package no.olai;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogMessage {

    private static int idCounter = 1;
    private int id;
    private String message;
    private Date date;

    public LogMessage(String message) {
        this.id = idCounter++;
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogEntry (" + id + ") | " + message + " | Timestamp: " + dateToString();
    }


    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
       return dateToString();
    }

    private String dateToString() {
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z");
        this.date = new Date(System.currentTimeMillis());
        return f.format(date);
    }
}

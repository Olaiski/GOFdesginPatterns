package no.olai.observer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Subscriber implements Observer {

    private String name;
    private Subject subject;
    private Date date;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public String update(String msg) {
        if (msg == null)
            return name + " : No new message";
        return name + " : " + msg + " (" + getTimeString() + ")";
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    private String getTimeString() {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss z");
        this.date = new Date(System.currentTimeMillis());
        return f.format(date);
    }
}

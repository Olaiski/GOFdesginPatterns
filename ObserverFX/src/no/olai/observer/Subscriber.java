package no.olai.observer;

public class Subscriber implements Observer {

    private String name;
    private Subject subject;


    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public String update() {
        String msg = (String) subject.getUpdate(this);
        if (msg == null)
            return name + ":: No new message";
        return name + " :: " + msg;
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}

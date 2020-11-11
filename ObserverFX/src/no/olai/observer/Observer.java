package no.olai.observer;

public interface Observer {

    String update(String msg);
    void setSubject(Subject subject);
}

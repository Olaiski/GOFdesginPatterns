package no.olai.observer;

public interface Observer {

    String update();
    void setSubject(Subject subject);
}

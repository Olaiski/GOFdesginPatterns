package no.olai.observer;

public interface Subject {

    void subscribe(Observer obj);
    void unsubscribe(Observer obj);
    boolean isSubscribed(Observer obj);

    void notifyObservers();

}

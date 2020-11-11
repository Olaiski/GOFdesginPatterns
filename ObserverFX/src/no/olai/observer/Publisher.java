package no.olai.observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements Subject {

    private List<Observer> observers;
    private String message;
    private boolean changed;


    public Publisher() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer obj) {
        if (obj == null)
            throw new NullPointerException("Null obs.");
        if (!isSubscribed(obj)) observers.add(obj);
    }

    @Override
    public boolean isSubscribed(Observer obj) {
        return obj != null && observers.contains(obj);
    }

    @Override
    public void unsubscribe(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersL;
        if (!changed) return;
        observersL = new ArrayList<>(this.observers);
        this.changed = false;
        for (Observer o : observersL)
            o.update(message);
    }

    public void postMessage(String msg) {
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}

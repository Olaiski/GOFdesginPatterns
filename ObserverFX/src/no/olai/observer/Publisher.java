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
        if (obj == null) throw new NullPointerException("Null obs.");
        if (!observers.contains(obj)) observers.add(obj);
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
        List<Observer> observersL = null;
        if (!changed) return;
        observersL = new ArrayList<>(this.observers);
        this.changed = false;
        for (Observer o : observersL)
            o.update();
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    public void postMessage(String msg) {
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}

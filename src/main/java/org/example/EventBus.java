package org.example;

import java.util.ArrayList;
public class EventBus {

    public ArrayList<Subscriber> subscribers = new ArrayList<Subscriber>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifyAll(int number) {
        for (Subscriber subscriber : subscribers) {
            subscriber.notify(number);
        }
    }
}

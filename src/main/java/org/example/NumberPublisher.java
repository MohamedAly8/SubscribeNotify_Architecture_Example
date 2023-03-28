package org.example;

import java.util.ArrayList;

public class NumberPublisher {
    
    private ArrayList<Subscriber> subscribers = new ArrayList();

    public NumberPublisher(){
        this.subscribers = subscribers;
    }

    public ArrayList<Subscriber> getSubscribers(){
        return subscribers;
    }

    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    public void notifyAll(int number) {

        System.out.println(" ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
        System.out.println(" | Publishing number " + number + " to all subscribers |");
        System.out.println(" ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");

        for (Subscriber subscriber : subscribers) {
            subscriber.notify(number);
        }
    }
}


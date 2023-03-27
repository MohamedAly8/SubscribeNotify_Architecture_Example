package org.example;

public class NumberPublisher {
    
    private EventBus eventBus;

    public NumberPublisher(EventBus eventBus){
        this.eventBus = eventBus;
    }

    public void publish(int number) {
        System.out.println(" ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
        System.out.println(" | Publishing number " + number + " to all subscribers |");
        System.out.println(" ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");

        eventBus.notifyAll(number);
    }

}


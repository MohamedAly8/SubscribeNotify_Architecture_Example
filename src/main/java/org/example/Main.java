package org.example;
public class Main {

    public static void main(String[] args) {

        // creating event bus for decouplying publisher from subsribers
        EventBus eventBus = new EventBus();

        // creating publisher
        NumberPublisher numberPublisher = new NumberPublisher(eventBus);

        // creating subsribers
        isEvenSubscriber isEvenSubsriber = new isEvenSubscriber();
        isOddSubscriber isOddSubscriber = new isOddSubscriber();
        isPrimeSubsriber isPrimeSubsriber = new isPrimeSubsriber();
        isCompositeSubscriber isCompositeSubscriber = new isCompositeSubscriber();


        // adding subscribers
        eventBus.subscribe(isEvenSubsriber);
        eventBus.subscribe(isOddSubscriber);
        eventBus.subscribe(isPrimeSubsriber);
        eventBus.subscribe(isCompositeSubscriber);

        System.out.println("Subscribers are:");
        for(Subscriber s : eventBus.subscribers){
            System.out.println(s.toString());
        }

        numberPublisher.publish(23);

        System.out.println("~~~~~~~~~~~~");


        eventBus.unsubscribe(isEvenSubsriber);
        eventBus.unsubscribe(isCompositeSubscriber);

        System.out.println("~~~~~~~~~~~~");

        System.out.println("Subscribers are:");
        for(Subscriber s : eventBus.subscribers){
            System.out.println(s.toString());
        }

        numberPublisher.publish(45);

    }

}


package org.example;

public class isEvenSubscriber implements Subscriber {
        
        public void notify(int number) {
            if (number % 2 == 0) {
                System.out.println("Message from EvenSubscriber: " + number + " is an even number");
            }
            else {
                System.out.println("Message from EvenSubscriber: " + number + " is not an even number");
            }
        }

    @Override
    public String toString() {
        return "Even Subscriber";
    }
}

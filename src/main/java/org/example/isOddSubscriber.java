package org.example;

public class isOddSubscriber implements Subscriber {
    
    public void notify(int number) {
        if (number % 2 != 0) {
            System.out.println("Message from OddSubscriber: " + number + " is an odd number");
        }
        else {
            System.out.println("Message from OddSubscriber: " + number + " is not an odd number");
        }
    }
    @Override
    public String toString() {
        return "Odd Subscriber";
    }
}

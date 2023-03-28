package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // creating event bus for decoupling publisher from subscribers

        // creating publisher
        NumberPublisher numberPublisher = new NumberPublisher();

        // creating subscribers
        isEvenSubscriber isEvenSubscriber = new isEvenSubscriber();
        isOddSubscriber isOddSubscriber = new isOddSubscriber();
        isPrimeSubscriber isPrimeSubscriber = new isPrimeSubscriber();
        isCompositeSubscriber isCompositeSubscriber = new isCompositeSubscriber();

        // adding subscribers
        numberPublisher.subscribe(isEvenSubscriber);
        numberPublisher.subscribe(isOddSubscriber);
        numberPublisher.subscribe(isCompositeSubscriber);
        numberPublisher.subscribe(isPrimeSubscriber);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Welcome to Subscribe/Notify (Publish-Subscribe) Architecture Demo");
        System.out.println("Initially, all of the subscribers (even/odd/prime/composite) are subscribed to the publisher.");
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("___________________________________________");
            System.out.println("To Add Subscriber, Enter 1");
            System.out.println("To Remove Subscriber, Enter 2");
            System.out.println("To Publish Number, Enter 3");
            System.out.println("To View All Current Subscribers, Enter 4");
            System.out.println("To Exit, Enter 5");
            System.out.println("___________________________________________");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the type of subscriber (even/odd/prime/composite): ");
                    String type = scanner.next();

                    Subscriber subscriber = null;
                    switch (type) {
                        case "even":
                            subscriber = isEvenSubscriber;
                            break;
                        case "odd":
                            subscriber = isOddSubscriber;
                            break;
                        case "prime":
                            subscriber = isPrimeSubscriber;
                            break;
                        case "composite":
                            subscriber = isCompositeSubscriber;
                            break;
                        default:
                            System.out.println("Invalid subscriber type.");
                            break;
                    }

                    if (subscriber != null) {
                        if(numberPublisher.getSubscribers().contains(subscriber)){
                            System.out.println("heeere");
                            System.out.println(subscriber.toString() + " already subscribed.");
                            break;
                        }
                        else {
                            numberPublisher.subscribe(subscriber);
                            System.out.println(subscriber.toString() + " subscribed.");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Enter the type of subscriber to unsubscribe (even/odd/prime/composite): ");
                    type = scanner.next();

                    subscriber = null;
                    switch (type) {
                        case "even":
                            subscriber = isEvenSubscriber;
                            break;
                        case "odd":
                            subscriber = isOddSubscriber;
                            break;
                        case "prime":
                            subscriber = isPrimeSubscriber;
                            break;
                        case "composite":
                            subscriber = isCompositeSubscriber;
                            break;
                        default:
                            System.out.println("Invalid subscriber type.");
                            break;
                    }

                    if (subscriber != null) {
                        if(numberPublisher.getSubscribers().contains(subscriber)) {
                            numberPublisher.unsubscribe(subscriber);
                            System.out.println(subscriber.toString() + " unsubscribed.");
                        }
                        else {
                            System.out.println(subscriber.toString() + " not currently subscribed");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter a number to publish: ");
                    int number = scanner.nextInt();
                    if(numberPublisher.getSubscribers().isEmpty()){
                        System.out.println("Error: No Subscribers, Subscribe to Subscriber first before publishing");
                        break;
                    }
                    numberPublisher.notifyAll(number);
                    break;

                case 4:

                    if (numberPublisher.getSubscribers().isEmpty()){
                        System.out.println("There are currently no subscribers!");
                    }
                    else {

                        System.out.println(numberPublisher.getSubscribers().size() + " subscribers");
                        System.out.println("~~~~~~~~~~");
                        for (Subscriber s : numberPublisher.getSubscribers()) {
                            System.out.println(s.toString());
                        }
                        System.out.println("~~~~~~~~~~");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}

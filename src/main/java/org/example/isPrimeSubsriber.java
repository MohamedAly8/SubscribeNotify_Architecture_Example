package org.example;

public class isPrimeSubsriber implements Subscriber {
        
        public void notify(int number) {
            if (isPrime(number)) {
                System.out.println("Message from isPrimeSubscriber: " + number + " is a prime number");
            }
            else {
                System.out.println("Message from isPrimeSubscriber: " + number + " is not a prime number");
            }
        }
        
        private boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    @Override
    public String toString() {
        return "Prime Subscriber";
    }
}

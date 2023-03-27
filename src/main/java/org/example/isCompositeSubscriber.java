package org.example;

public class isCompositeSubscriber implements Subscriber {
        
        public void notify(int number) {
            if (isComposite(number)) {
                System.out.println("Message from isCompositeSubscriber: " + number + " is a composite number");
            }
            else {
                System.out.println("Message from isCompositeSubscriber: " + number + " is not a composite number");
            }
        }
        
        private boolean isComposite(int number) {
            if (number <= 1) {
                return false;
            }
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return true;
                }
            }
            return false; 
        }
    @Override
    public String toString() {
        return "Composite Subscriber";
    }
}

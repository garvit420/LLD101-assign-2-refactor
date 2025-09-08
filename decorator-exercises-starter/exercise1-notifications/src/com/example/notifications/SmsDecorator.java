package com.example.notifications;

/**
 * Concrete decorator that adds SMS notification functionality.
 * Sends an SMS and then delegates to the wrapped notifier.
 */
public class SmsDecorator extends NotifierDecorator {
    private final String phoneNumber;

    public SmsDecorator(Notifier notifier, String phoneNumber) {
        super(notifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notify(String text) {
        // Add SMS functionality
        System.out.println("[SMS -> " + phoneNumber + "]: " + text);
        
        // Delegate to wrapped notifier
        super.notify(text);
    }
}

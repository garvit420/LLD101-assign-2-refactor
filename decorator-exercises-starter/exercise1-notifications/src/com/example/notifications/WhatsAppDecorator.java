package com.example.notifications;

/**
 * Concrete decorator that adds WhatsApp notification functionality.
 * Sends a WhatsApp message and then delegates to the wrapped notifier.
 */
public class WhatsAppDecorator extends NotifierDecorator {
    private final String whatsAppId;

    public WhatsAppDecorator(Notifier notifier, String whatsAppId) {
        super(notifier);
        this.whatsAppId = whatsAppId;
    }

    @Override
    public void notify(String text) {
        // Add WhatsApp functionality
        System.out.println("[WHATSAPP -> " + whatsAppId + "]: " + text);
        
        // Delegate to wrapped notifier
        super.notify(text);
    }
}

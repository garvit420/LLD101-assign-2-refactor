package com.example.notifications;

/**
 * Base decorator class that implements Notifier and wraps another Notifier.
 * This allows us to add additional notification behaviors while delegating
 * to the wrapped notifier.
 */
public abstract class NotifierDecorator implements Notifier {
    protected final Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void notify(String text) {
        notifier.notify(text);
    }
}

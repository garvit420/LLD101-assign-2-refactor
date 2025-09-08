package com.example.notifications;

/**
 * Concrete decorator that adds Slack notification functionality.
 * Sends a Slack message and then delegates to the wrapped notifier.
 */
public class SlackDecorator extends NotifierDecorator {
    private final String slackChannel;

    public SlackDecorator(Notifier notifier, String slackChannel) {
        super(notifier);
        this.slackChannel = slackChannel;
    }

    @Override
    public void notify(String text) {
        // Add Slack functionality
        System.out.println("[SLACK -> #" + slackChannel + "]: " + text);
        
        // Delegate to wrapped notifier
        super.notify(text);
    }
}

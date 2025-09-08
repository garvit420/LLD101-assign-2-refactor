package com.example.notifications;

/**
 * Starter demo that uses only the existing Email notifier.
 * TODOs guide you to add decorators and compose them.
 */
public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline behavior (already works)
        base.notify("Baseline email only.");

        System.out.println("1. Email + SMS:");
        Notifier emailAndSms = new SmsDecorator(base, "+91-99999-11111");
        emailAndSms.notify("Build green ✅");
        
        System.out.println("\n2. Email + WhatsApp:");
        // b) Email + WhatsApp
        Notifier emailAndWhatsApp = new WhatsAppDecorator(base, "user_wa");
        emailAndWhatsApp.notify("Code review requested 📝");
        
        System.out.println("\n3. Email + Slack:");
        // c) Email + Slack
        Notifier emailAndSlack = new SlackDecorator(base, "deployments");
        emailAndSlack.notify("Server maintenance scheduled 🔧");
        
        System.out.println("\n4. Email + WhatsApp + Slack:");
        // d) Email + WhatsApp + Slack
        Notifier emailWhatsAppAndSlack = new SlackDecorator(
            new WhatsAppDecorator(base, "user_wa"), 
            "deployments"
        );
        emailWhatsAppAndSlack.notify("Deployment completed 🚀");
        
        System.out.println("\n5. All notifications (Email + SMS + WhatsApp + Slack):");
        // Bonus: All four notification types
        Notifier allNotifications = new SlackDecorator(
            new WhatsAppDecorator(
                new SmsDecorator(base, "+91-99999-11111"),
                "user_wa"
            ),
            "alerts"
        );
        allNotifications.notify("Critical system alert! 🚨");
    }
}

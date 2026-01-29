package design.lowleveldesign.observerpattern.observer;

import design.lowleveldesign.observerpattern.observeable.StockObserveable;

public class EmailNotificationAlertObserver implements NotificationAlertObserver {
    String email;
    StockObserveable stockObserveable;

    public EmailNotificationAlertObserver(StockObserveable stockObserveable, String email) {
        this.stockObserveable = stockObserveable;
        this.email = email;
    }

    @Override
    public void update() {
        sendEmail(email,"Email Stock Notification Alert");
    }

    private void sendEmail(String email, String message) {
        System.out.println("Sending email to " + email + ": " + message);
    }
}

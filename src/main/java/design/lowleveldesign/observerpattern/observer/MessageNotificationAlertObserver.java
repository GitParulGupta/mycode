package design.lowleveldesign.observerpattern.observer;

import design.lowleveldesign.observerpattern.observeable.StockObserveable;

public class MessageNotificationAlertObserver implements NotificationAlertObserver {
    String userName;
    StockObserveable stockObserveable;

    public MessageNotificationAlertObserver(StockObserveable stockObserveable, String userName) {
        this.stockObserveable = stockObserveable;
        this.userName = userName;
    }

    @Override
    public void update() {
        sendMessage(userName,"Mobile message Stock Notification Alert");
    }

    private void sendMessage(String username, String message) {
        System.out.println("Sending message to " + username + ": " + message);
    }
}

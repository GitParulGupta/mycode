package design.lowleveldesign.observerpattern;


import design.lowleveldesign.observerpattern.observeable.IphoneObservableImpl;
import design.lowleveldesign.observerpattern.observeable.StockObserveable;
import design.lowleveldesign.observerpattern.observer.EmailNotificationAlertObserver;
import design.lowleveldesign.observerpattern.observer.MessageNotificationAlertObserver;
import design.lowleveldesign.observerpattern.observer.NotificationAlertObserver;

/**
 * Implement notify me for Iphone availability on amazone
 */
public class AmazonStore {
    public static void main(String[] args) {
        StockObserveable obj = new IphoneObservableImpl();

        NotificationAlertObserver obs1 = new EmailNotificationAlertObserver(obj,"abc@gmail.com");
        NotificationAlertObserver obs2 = new EmailNotificationAlertObserver(obj,"xyz@gmail.com");
        NotificationAlertObserver obs3 = new MessageNotificationAlertObserver(obj,"abc");

        obj.addObserver(obs1);
        obj.addObserver(obs2);
        obj.addObserver(obs3);

        obj.setStockCount(10);

        obj.notifyObservers();

    }
}

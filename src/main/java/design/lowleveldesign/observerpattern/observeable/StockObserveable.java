package design.lowleveldesign.observerpattern.observeable;

import design.lowleveldesign.observerpattern.observer.NotificationAlertObserver;

public interface StockObserveable {

    public void addObserver(NotificationAlertObserver observer);
    public void removeObserver(NotificationAlertObserver observer);
    public void notifyObservers();
    public void setStockCount(int stockCount);
    public int getStockCount();
}

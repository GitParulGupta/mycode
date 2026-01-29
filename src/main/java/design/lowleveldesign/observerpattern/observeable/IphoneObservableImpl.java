package design.lowleveldesign.observerpattern.observeable;

import design.lowleveldesign.observerpattern.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObserveable{

    List<NotificationAlertObserver> observers = new ArrayList<>();
    int stockCount;

    @Override
    public void addObserver(NotificationAlertObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(NotificationAlertObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(NotificationAlertObserver observer : observers){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int stockCountAdded) {//Product coming out of stock
        if(stockCountAdded==0){
            notifyObservers();
        }
        stockCount = stockCount+ stockCountAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}

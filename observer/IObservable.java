package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class IObservable {
    private List<IObserver> subscribers;

    public IObservable() {
        subscribers = new ArrayList<>();
    }

    public void addObserver(IObserver observer) {
        if(!subscribers.contains(observer)) {
            subscribers.add(observer);
        }
    }

    public void removeObserver(IObserver observer) {
        subscribers.remove(observer);
    }

    public void notifyObservers(Object notification) {
        if(this.subscribers == null || this.subscribers.isEmpty()) {
//            System.out.println("Lista subskrajbera je prazna");
            return;
        }
        for(int i = 0; i < subscribers.size(); i++) {
            subscribers.get(i).updateObserver(notification);
        }
    }

    public List<IObserver> getSubscribers() {
        return subscribers;
    }
}

package error;

import enums.notifikacija.*;
import observer.IObservable;

public class ErrorFactory extends IObservable {
    private static ErrorFactory instance;

    private ErrorFactory() {
        super();
    }

    public static ErrorFactory getInstance(){
        if(instance == null){
            instance = new ErrorFactory();
        }
        return instance;
    }

    public void generateError(String message, String title, int type){
        notifyObservers(new MyNotification(new MyError(message, title, type), MyNotification.Notifikacija.ERROR));
    }

}

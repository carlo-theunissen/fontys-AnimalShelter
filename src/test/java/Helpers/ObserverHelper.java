package Helpers;

import java.util.Observable;
import java.util.Observer;

public class ObserverHelper implements Observer {

    public boolean Updated;
    public void update(Observable o, Object arg) {
        Updated = true;
    }
}

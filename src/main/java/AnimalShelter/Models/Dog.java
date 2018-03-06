package AnimalShelter.Models;

import java.util.Date;

public class Dog extends Animal {


    /**
     * Mulithreaded, protected by "this" and partly immortality
     */
    private volatile Date WalkTime;

    public boolean needsWalk(){
        Date date = new Date();
        date.setTime(0);

        //because WalkTime is partly immortal, we don't need
        //synchronization to prevent race-conditions
        return WalkTime.before(date);

    }

    public void walk(){
        Date date = new Date();
        date.setTime(0); //setting the time to 0, only the date will remain

        //synchronization is needed because we're editing two properties
        // - the walk time
        // - that the observable has been changed
        synchronized (this) {
            WalkTime = (Date) date.clone(); //partly immortal!
            setChanged();
        }

        //notify the observers outside the synchronization block
        //to prevent dead-locking
        notifyObservers();
    }

    public Dog(String name, Gender gender) {
        super(name, gender);
        walk();
    }

    @Override
    public String toString() {
        return super.toString() + ", last walk: "+ WalkTime;
    }
}

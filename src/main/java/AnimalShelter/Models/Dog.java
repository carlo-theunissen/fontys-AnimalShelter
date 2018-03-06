package AnimalShelter.Models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dog extends Animal {


    /**
     * Mulithreaded, protected by "this" and partly immortality
     */
    private volatile Date WalkTime;

    public boolean needsWalk(){
        //because WalkTime is partly immortal, we don't need
        //synchronization to prevent race-conditions
        return WalkTime.before(getWalkTime());

    }

    private Date getWalkTime(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public void walk(){


        //synchronization is needed because we're editing two properties
        // - the walk time
        // - that the observable has been changed
        synchronized (this) {
            WalkTime = getWalkTime(); //partly immortal!
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
        return super.toString() + ", last walk: "+ new SimpleDateFormat("yyyy-MM-dd").format(WalkTime);
    }
}

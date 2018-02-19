package AnimalShelter.Models;

import java.util.Date;

public class Dog extends Animal {
    private volatile Date WalkTime;

    public boolean needsWalk(){
        Date date = new Date();
        date.setTime(0);
        return WalkTime.before(date);
    }

    public void walk(){
        Date date = new Date();
        date.setTime(0);
        WalkTime = (Date) date.clone(); //partly immortal!
    }

    public Dog(String name, Gender gender) {
        super(name, gender);
        walk();
    }
}

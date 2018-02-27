package AnimalShelter.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Cat extends Animal{

    private final Collection<Habit> Habits;

    public Cat(String name, Gender gender) {
        super(name, gender);
        Habits = Collections.synchronizedList(new ArrayList<Habit>());
    }

    public Collection<Habit> getHabits() {
        return Collections.unmodifiableCollection(Habits);
    }

    public boolean containsHabit(Habit habit) {
        return Habits.contains(habit);
    }

    public void removeHabit(Habit habit) {
        synchronized (this) {
            Habits.remove(habit);
            setChanged();
        }
        notifyObservers();
    }

    public void addHabit(Habit habit) {
        synchronized (this) {
            Habits.add(habit);
            setChanged();
        }
        notifyObservers();
    }
}

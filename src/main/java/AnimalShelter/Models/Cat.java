package AnimalShelter.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Cat extends Animal {

    private Collection<Habit> Habits;

    public Cat(String name, Gender gender) {
        super(name, gender);
        Habits = Collections.synchronizedList(new ArrayList<Habit>());
    }


    public Collection<Habit> getHabits() {
        return Collections.unmodifiableCollection(Habits);
    }

    private boolean containsHabit(Habit habit) {
        return Habits.contains(habit);
    }

    private void removeHabit(Habit habit) {
        Habits.remove(habit);
    }

    private void addHabit(Habit habit) {
        Habits.add(habit);
    }
}

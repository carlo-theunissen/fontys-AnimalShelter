package AnimalShelter.Models;

public abstract class Habit {
    Habit(String description) {
        Description = description;
    }

    public String getDescription() {
        return Description;
    }

    private final String Description;

    @Override
    public String toString() {
        return Description;
    }
}

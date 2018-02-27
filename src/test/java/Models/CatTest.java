package Models;

import AnimalShelter.Models.BadHabit;
import AnimalShelter.Models.Cat;
import AnimalShelter.Models.Gender;
import AnimalShelter.Models.Habit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CatTest {
    private Cat cat;

    @Before
    public void setupCat() {
        cat = new Cat("Charley", Gender.Male);
    }

    @Test
    public void testConstructor()
    {
        Assert.assertEquals("Charley", cat.getName());
        Assert.assertEquals(Gender.Male, cat.getGender());
    }

    @Test
    public void addHabit(){
        Habit habit = new BadHabit("Smells");
        cat.addHabit(habit);
        Assert.assertTrue(cat.containsHabit(habit));
        Assert.assertEquals(1, cat.getHabits().size());
    }

    @Test
    public void removeHabit(){
        Habit habit = new BadHabit("Smells");
        cat.addHabit(habit);
        Assert.assertTrue(cat.containsHabit(habit));
        Assert.assertEquals(1, cat.getHabits().size());

        cat.removeHabit(habit);
        Assert.assertFalse(cat.containsHabit(habit));
        Assert.assertEquals(0, cat.getHabits().size());
    }

}

package Logic;

import AnimalShelter.Logic.ReservationSystem;
import AnimalShelter.Models.Cat;
import AnimalShelter.Models.Gender;
import Helpers.ObserverHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

public class ReservationSystemTest {

    @Test
    public void TestBasicReservation(){
        ReservationSystem system = new ReservationSystem();
        Cat cat = new Cat("Charley", Gender.It);
        Cat oldCat = new Cat("Felix", Gender.Female);

        system.reserveAnimal(cat, "Carlo");

        Assert.assertTrue(system.isAnimalReserved(cat));
        Assert.assertFalse(system.isAnimalReserved(oldCat));
    }

    @Test
    public void ObservableReservationTest(){
        ReservationSystem system = new ReservationSystem();
        ObserverHelper observer = new ObserverHelper();
        system.addObserver(observer);

        Cat cat = new Cat("Charley", Gender.It);
        system.reserveAnimal(cat, "Sjaak");

        Assert.assertTrue(observer.Updated);
    }
}

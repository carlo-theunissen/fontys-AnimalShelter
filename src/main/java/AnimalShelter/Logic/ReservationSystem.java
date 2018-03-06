package AnimalShelter.Logic;

import AnimalShelter.Models.Animal;

import java.util.*;

public class ReservationSystem extends Observable {
    private final HashMap<Animal, String> animals;

    public ReservationSystem(){
        animals = new HashMap<Animal, String>();
    }

    public synchronized boolean isAnimalReserved(Animal animal){
        return animals.containsKey(animal);
    }
    public synchronized String getReserver(Animal animal){
        return animals.get(animal);
    }

    public void reserveAnimal(Animal animal, String reserver){
        synchronized (this) {
            animals.put(animal, reserver);
            setChanged();
        }
        notifyObservers();
    }

    public void removeAnimal(Animal animal){
        synchronized (this) {
            animals.remove(animal);
            setChanged();
        }
        notifyObservers();
    }
}

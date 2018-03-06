package AnimalShelter.Logic;

import AnimalShelter.Models.Animal;

import java.util.*;

public class ReservationSystem extends Observable {
    private final Set<Animal> animals;

    public ReservationSystem(){
        animals = new HashSet<Animal>();
    }

    public synchronized boolean isAnimalReserved(Animal animal){
        return animals.contains(animal);
    }

    public void reserveAnimal(Animal animal){
        synchronized (this) {
            animals.add(animal);
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

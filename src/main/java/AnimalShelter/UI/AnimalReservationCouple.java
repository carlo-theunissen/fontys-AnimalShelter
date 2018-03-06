package AnimalShelter.UI;

import AnimalShelter.Logic.ReservationSystem;
import AnimalShelter.Models.Animal;

public class AnimalReservationCouple {
    private ReservationSystem system;
    private Animal animal;
    public AnimalReservationCouple(ReservationSystem system, Animal animal){
        this.system = system;
        this.animal = animal;
    }
    public Animal GetAnimal(){
        return animal;
    }

    @Override
    public String toString() {
        return animal.toString() + (system.isAnimalReserved(animal) ? ", Animal reserved by: " + system.getReserver(animal) : ", Animal not reserved ");
    }
}

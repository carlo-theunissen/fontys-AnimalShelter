package AnimalShelter.Models;

public abstract class Animal
{
    public Animal(String name, Gender gender) {
        Name = name;
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Gender getGender() {
        return Gender;
    }

    public void setGender(Gender gender) {
        Gender = gender;
    }

    private String Name;
    private Gender Gender;
}

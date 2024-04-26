package Model;

import java.util.HashMap;

public class AnimalRegister {
    private HashMap<String, Animal> animals;
    static int countAnimal = 0;


    public AnimalRegister() {
        animals = new HashMap<>();
        Animal newA = new Animal("Fido","Dog","2020-01-01");
        Animal newAn = new Animal("Whiskers","Cat","2019-05-15");

        animals.put("Fido", newA);
        animals.put("Whiskers", newAn);


    }

    public void addAnimal(String name, String type, String birthDate) {
        //Integer newId = animals.isEmpty() ? 1 : animals.get(animals.size() - 1).id + 1; //используем последний id элемента
        Animal animal = new Animal(name, type, birthDate);
        animals.put(name, animal);
    }

    public void addCommand(String name, String command) {
        Animal animal = animals.get(name);
        if (animal != null) {
            animal.addCommand(command);
        } else {
            System.out.println("Animal not found. You can't add command!");
        }
    }

    public void displayCommands(String name) {
        Animal animal = animals.get(name);
        if (animal != null) {
            animal.displayCommands();
        } else {
            System.out.println("Animal not found.");
        }
    }

    public void sortAnimalsByBirthDate() {
        System.out.println("Animals sorted by birth date:");
        animals.values().stream()
                .sorted((a1, a2) -> a1.getBirthDate().compareTo(a2.getBirthDate()))
                .forEach(a -> System.out.println(a.getName() + " - " + a.getBirthDate()));
    }
    public void setCountAnimalt() {
        countAnimal = animals.size();
        System.out.println("The amount of animals is " + countAnimal);
        System.out.println(animals);


    }

}

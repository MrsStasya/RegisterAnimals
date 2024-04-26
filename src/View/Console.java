package View;

import Model.AnimalRegister;

import java.util.Scanner;

public class Console implements View {
    private Scanner scanner;
//    private boolean work;
    public Console() {
        scanner = new Scanner(System.in);
       // work = true;

    }
    @Override
    public void start() {
        hello();
        printMenu();
    }

    private void hello() {
        answer("Добро пожаловать в меню приложение");
    }
    public void finish() {
        answer("Сеанс завершен. До свидания!");
        //work = false;
        scanner.close();
    }
    private void printMenu(){
        AnimalRegister registry = new AnimalRegister();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to menu. Select the desired option:");
            System.out.println("1. Add new animal");
            System.out.println("2. Add command to animal");
            System.out.println("3. Display animal commands");
            System.out.println("4. Display animals by birth date");
            System.out.println("5. Display number of animals");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter animal name: ");
                    String name = scanner.next();
                    System.out.print("Enter animal type: ");
                    String type = scanner.next();
                    System.out.print("Enter animal birth date: ");
                    String birthDate = scanner.next();
                    registry.addAnimal(name, type, birthDate);
                    break;
                case 2:
                    System.out.print("Enter animal name: ");
                    String animalName = scanner.next();
                    System.out.print("Enter command: ");
                    String command = scanner.next();
                    registry.addCommand(animalName, command);
                    break;
                case 3:
                    System.out.print("Enter animal name: ");
                    String animalName2 = scanner.next();
                    registry.displayCommands(animalName2);
                    break;
                case 4:
                    registry.sortAnimalsByBirthDate();
                    break;
                case 5:
                    registry.setCountAnimalt();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    @Override
    public void answer(String text) {

    }
}

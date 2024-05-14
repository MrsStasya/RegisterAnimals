package View;

import Model.AnimalRegister;
import Model.Exception.MyException;

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
        try {
            printMenu();
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }

    //Выход из программы
       public void finish() {
           System.out.println("Exiting program.");
           System.exit(0);
           scanner.close();
    }
    private void printMenu() throws MyException {
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
//                    System.out.print("Enter animal name: ");
//                    String name = scanner.next();
//                    System.out.print("Enter animal type: ");
//                    String type = scanner.next();
//                    System.out.print("Enter animal birth date: ");
//                    String birthDate = scanner.next();
//                    registry.addAnimal(name, type, birthDate);
                    registry.addAnimal();

                    break;
                case 2:
                    System.out.print("Enter animal name: ");
                    String animalName = scanner.next();
                    System.out.print("Enter command: ");
                    String command = scanner.next();
                    //registry.addCommand(animalName, command);
                    break;
                case 3:
                    System.out.print("Введите кличку животного: ");
                    String nameOfAnimal = scanner.next();
                    registry.displayCommands(nameOfAnimal);
                    break;
                case 4:
                    //registry.sortAnimalsByBirthDate();
                    registry.sortByBrith();
                    break;
                case 5:
                    registry.setCountAnimalt();
                    break;
                case 6:
                    finish();
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

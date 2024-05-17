package View;

import Model.AnimalRegister;

import java.util.Scanner;

public class Console implements View {
    private Scanner scanner;
    public Console() {
        scanner = new Scanner(System.in);

    }
    @Override
    public void start() throws MyException {
        printMenu();

    }

    //Выход из программы
       public void finish() {
           System.out.println("Exiting program.");
           System.exit(0);
           scanner.close();
    }
    private void printMenu() {
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
                    registry.addAnimal();
                    break;
                case 2:
                    System.out.print("Введите кличку животного: ");
                    String nameAnimal = scanner.next();
                    System.out.print("Необходимо ввести команду(несколько команд вводится через пробел): ");
                    String command = scanner.next();
                    registry.addCommand(nameAnimal, command);
                    break;
                case 3:
                    System.out.print("Введите кличку животного: ");
                    String nameOfAnimal = scanner.next();
                    registry.displayCommands(nameOfAnimal);

                    break;
                case 4:
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

package Model;

import Model.Exception.MyException;

import java.util.*;

public class AnimalRegister {
    private HashMap<String, Animal> animals;
    private List<Animal> register; //делаем массив данных
    //private ArrayList<String> command; //для команд

    static int countAnimal = 0;


    public AnimalRegister() {
        animals = new HashMap<>();
        register = new ArrayList<Animal>();//новая
        //command = new ArrayList<String>();//новая

        Animal newA = new Animal(1, "Fido",  "Dog","2020-01-01", "Sit, Stay, Fetch");
        Animal newAn = new Animal(2,"Whiskers","Cat","2019-05-15", "Sit, Pounce");
        Animal newAnn = new Animal(3,"Hammy","Hamster","2021-03-10", "Roll, Hide");


        //animals.put("Fido", newA);
        //animals.put("Whiskers", newAn);

        //Добавляем животных в лист
        register.add(newA);
        register.add(newAn);
        register.add(newAnn);

    }

//    public void addAnimal(String name, String type, String birthDate) {
//        //Integer newId = animals.isEmpty() ? 1 : animals.get(animals.size() - 1).id + 1; //используем последний id элемента
//        Animal animal = new Animal(name, type, birthDate);
//        animals.put(name, animal);
//    }

    //Пробуем создать кусок кода, где автоматом определяется класс


// Добавление нового животного в список - работает не трогать!
    public void addAnimal() throws MyException {
        Animal newA = createAnimal();
        try {
            if(newA != null) {
                register.add(newA);
                System.out.println("Животное успешно добавлено!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Выполнен неверный ввод. Животное не может быть добавлено. Попробуйте снова");
        }
    }

    // Создание животного - работает не трогать!

    public Animal createAnimal() {
        Scanner scanner = new Scanner(System.in);
        Integer newId = register.isEmpty() ? 1 : register.get(register.size() - 1).id + 1; //используем последний id элемента
        System.out.println("Введите кличку животного: ");
        String name = scanner.nextLine();
        System.out.println("\"Какого питомца хотите завести? \n" + "1 - Кошка\n" +"2 - Собака\n" + "3 - Хомяк\n" + "4 - Лошадь\n" + "5 - Осел\n" + "6 - Верблюд\n");
        String type = scanner.nextLine();
        System.out.println("Введите дату рождения животного в формате год-месяц-дата(пример ввода: 2011-11-02): ");
        String brith = scanner.nextLine();
        //LocalDate birthDate = LocalDate.parse(brith); дата в формате стринг, поэтому не нужна
        System.out.println("Введите команды для животного: ");
        String commands = scanner.nextLine();

        switch (type.toLowerCase()) {
            case "1":
                return new Cat(newId, name, type, brith, commands);
            case "2":
                return new Dog(newId, name, type, brith, commands);
            case "3":
                return new Homa(newId, name, type, brith, commands);
            case "4":

                return new Horse(newId, name, type, brith, commands);
            case "5":

                return new Donkey(newId, name, type, brith, commands);
            case "6":

                return new Camel(newId, name, type, brith, commands);
            default:
                System.out.println("Попробуй еще раз, введите число от 0 до 6");
                return null;
        }

    }
    /* Этот кусок для команд в формате ArrayList
//    public ArrayList<String> setCommand(String com) throws MyException {
//        String[] command = com.split(" ");
//        if(checkIfText(com) == true){
//            this.command = new ArrayList<>(List.of(com));
//        } else {
//            throw new MyException("Повторите ввод");
//        }
//        return null;
//    }



    public boolean checkIfText(String com){
        return com.matches("\\D+");
    }

     */

    /* Пока убрала, чтобы проверить как работает п.1 , п.4. и п.5

    //Добавление команды для животного
    public void addCommand(String name, String command) {
        Animal animal = animals.get(name);
        if (animal != null) {
            animal.addCommand(command);
        } else {
            System.out.println("Animal not found. You can't add command!");
        }
    }
    */
//Вывод команд для животного

     /* Это работает для HashMap
    public void displayCommands(String name) {
        Animal animal = animals.get(name);
        if (animal != null) {
            animal.displayCommands();
        } else {
            System.out.println("Animal not found.");
        }
    }

      */
//Метод для вывода команд животного по его кличке. Работает, не трогай!!!
    public void displayCommands(String nameOfAnimal) throws MyException {
        for (Animal show : register) {
            if (show.getName().equals(nameOfAnimal)) {
                System.out.println(nameOfAnimal + " умеет выполнять следующие команды " + show.getCommands());
                break;
            }
            else {
                System.out.println(nameOfAnimal + " отсутствует в регистре ");

            }
            break;
        }
    }


    /* Это работает для HashMap
    public void sortAnimalsByBirthDate() {
        System.out.println("Animals sorted by birth date:");
        animals.values().stream()
                .sorted((a1, a2) -> a1.getBirthDate().compareTo(a2.getBirthDate()))
                .forEach(a -> System.out.println(a.getName() + " - " + a.getBirthDate()));
    }

     */


    // Сортировка по дате рожденияи - работает не трогать!
    public void sortByBrith () {
        System.out.println("Сортировка животных по дате рождения:");
        register.sort(Comparator.comparing(Animal::getBirthDate));
        for (Animal animal: register) {
            System.out.println(animal.toString());
        }


    }

    // Вывод сколько животных всего + вывод всего регистра животных
    public void setCountAnimalt() {
        //countAnimal = animals.size();
        countAnimal = register.size();
        System.out.println("The amount of animals is " + countAnimal);
        //System.out.println(animals);
        System.out.println(register);


    }

}

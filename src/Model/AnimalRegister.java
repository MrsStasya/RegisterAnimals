package Model;

import Model.Exception.MyException;

import java.util.*;

public class AnimalRegister {
    private HashMap<String, String> animals;
    private List<Animal> register; //делаем массив данных

    static int countAnimal = 0;


    public AnimalRegister() {
        animals = new HashMap<>();
        register = new ArrayList<Animal>();//новая
        Animal newA = new Animal(1, "Fido",  "Dog","2020-01-01", "Sit, Stay, Fetch");
        Animal newAn = new Animal(2,"Whiskers","Cat","2019-05-15", "Sit, Pounce");
        Animal newAnn = new Animal(3,"Hammy","Hamster","2021-03-10", "Roll, Hide");
        register.add(newA);
        register.add(newAn);
        register.add(newAnn);

    }

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

    //Добавление команды для животного
    public void addCommand(String nameAnimal, String command) {
        String newCommands;
        Animal newanimal = findName(nameAnimal);
        int indexE;

        if (newanimal != null) {
            newCommands = newanimal.getCommands() + ", " + command;
            Animal animalToReestr = new Animal(newanimal.id, newanimal.getName(), newanimal.getType(), newanimal.getBirthDate(), newCommands);
            removeAnimal(nameAnimal);
            register.add(animalToReestr);
            System.out.println(register);
        }
        else {
            System.out.println("Животного нет в реестре");
        }
    }

    //Поиск по имени
    private Animal findName(String nameAnimal) {
        for (Animal animal : register) {
            if (animal.getName().equalsIgnoreCase(nameAnimal)) {
                return animal;
            }
        }
        return null;
    }

    //Поиск и удаление элемента из register
    public List<Animal> removeAnimal (String nameAnimal){

        Iterator<Animal> iterator = register.iterator();
        while (iterator.hasNext()) {
            Animal nextAnimal = iterator.next(); //получаем следующий элемент
            if (nextAnimal.getName().equals(nameAnimal)) { //условие, когда будет происходить удаление
                iterator.remove(); //удаление элемента
            }

        }
        return new ArrayList<>(register);
    }


//Вывод команд для животного
    public void displayCommands(String nameOfAnimal) {
        convertToMap(register);
        if (animals.containsKey(nameOfAnimal)) {
            System.out.println(nameOfAnimal + " выполняет команды: " + animals.get(nameOfAnimal));
        } else {
            System.out.println("Животное отсутствует в списке");
        }
    }


    //Метод преобразования ArrayList в Map (для метода displayCommands)
    public void convertToMap (List<Animal> register) {
        for (Animal map: register) {
            animals.put(map.getName(), map.getCommands());
        }
    }

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
        System.out.println(register);
    }
}

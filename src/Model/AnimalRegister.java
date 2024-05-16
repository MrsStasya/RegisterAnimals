package Model;

import java.util.*;

public class AnimalRegister {
    private HashMap<String, String> animals;
    private HashMap<String, List<Animal>> animalHashMap;

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
//    public void addAnimal() throws MyException {
//        Animal newA = createAnimal();
//        try {
//            if(newA != null) {
//                register.add(newA);
//                System.out.println("Животное успешно добавлено!");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Выполнен неверный ввод. Животное не может быть добавлено. Попробуйте снова");
//        }
//    }

    public void addAnimal() {
        Animal newA = createAnimal();

            if(newA != null) {
                register.add(newA);
                System.out.println("Животное успешно добавлено!");
            }
        else {
                System.out.println("Выполнен неверный ввод. Животное не может быть добавлено. Попробуйте снова");
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
    //Вариант 1 - не ищет нормально
//    public void addCommand(String nameAnimal, String command) {
//        String str;
//        Set<Animal> set = new LinkedHashSet<Animal>();
//        //Set<Animal> set2 = new LinkedHashSet<Animal>();
//        for (Animal number : register) {
//            if (number.getName().equals(nameAnimal)) {
//                str = number.getCommands() + ", " + command; //беру команды и соединяю с теми, что ввели
//                Animal changeComands = new Animal(number.id, number.getName(), number.getType(), number.getBirthDate(), str); //создаю новое животное с обновленным набором команд
//                set.add(changeComands); //добавление нового животного в Set
////                set2.addAll(removeAnimal(nameAnimal));
////                set2.addAll(set);
//                //register.addAll(set2);
//                removeAnimal(nameAnimal);
//                register.addAll(set);
//                //register.add(changeComands);
//                System.out.println("Изменения внесены успешно");
//                System.out.println(register);
//    }
//            else {
//                System.out.println(nameAnimal + " отсутствует в регистре ");
//                System.out.println(register.toString());
//                break;
//
//            }
//        }
//    }

//    //Вариант 2
//    public void addCommand(String nameAnimal, String command) {
//        removeAnimal(nameAnimal);
//        //getString(nameAnimal,command);
//        register.add(getString(nameAnimal, command));
//
//
//    }
//
//    //Создаем строку с командой
//    public Animal getString(String nameAnimal, String command) {
//        String str;
//        Set<Animal> set = new LinkedHashSet<Animal>();
//
//        Animal changeAnimal = null;
//        for (Animal number : register) {
//            if (number.getName().equals(nameAnimal)) {
//                str = number.getCommands() + ", " + command; //беру команды и соединяю с теми, что ввели
//                changeAnimal = new Animal(number.id, number.getName(), number.getType(), number.getBirthDate(), str);
//                //set.add(changeAnimal);
//            }
//        }
//        return changeAnimal;
//    }
//
//    //Поиск и удаление элемента из register
//    public List<Animal> removeAnimal (String nameAnimal){
//
//        Iterator<Animal> iterator = register.iterator();
//        while (iterator.hasNext()) {
//            Animal nextAnimal = iterator.next(); //получаем следующий элемент
//            if (nextAnimal.getName().equals(nameAnimal)) { //условие, когда будет происходить удаление
//                iterator.remove(); //удаление элемента
//            }
//
//        }
//        return new ArrayList<>(register);
//    }
//

    //Вариант 3 - пора спать
    public void addCommand(String nameAnimal, String command) {
        convertMap(register);
        List<Animal> animalCom = animalHashMap.get(nameAnimal);
        if(animalHashMap.containsKey(nameAnimal)){

        }
     }
    //Метод преобразования ArrayList в Map (для метода AddCommands)
    public void convertMap (List<Animal> register) {
        for (Animal map: register) {
            animalHashMap.put(map.getName(), register);

        }
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
        //System.out.println(animals);
        System.out.println(register);
    }
}

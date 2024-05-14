package Model;

public class Animal {
    public Integer id;
    //private Integer id;
    private String name;
    private String type;
    private String birthDate;
    private String commands;

    //private ArrayList<String> commands;

    public Animal (Integer id, String name, String type, String birthDate, String commands ){ //ArrayList<String> commands
        this.id = id;
        this.name =  name;
        this.type = type;
        this.birthDate = birthDate;
        this.commands = commands;
        //this.commands = commands;
    }
    // Этот кусок для варианта с ArrayList
//    public void addCommand(String command) {
//        commands.add(command);
//    }
//
//    public void displayCommands() {
//        System.out.println("Commands for " + name + ":");
//        for (String command : commands) {
//            System.out.println(command);
//        }
//    }

    //public Integer getId() {
   //     return id;
    //}
    public String getName() {
        return name;
    }
    public String getType() {return type;}
    public String getBirthDate() {
        return birthDate;
    }
    public String getCommands() {
        return commands;
    }


    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("Кличка: ");
        info.append(getName());
        info.append(" ");
        info.append(", тип: ");
        info.append(getType());
        info.append(" ");
        info.append(", дата рождения: ");
        info.append(getBirthDate());
        info.append(" ");
        info.append(", команды: ");
        info.append(getCommands());

        //displayCommands();
        return info.toString();
    }
    @Override
    public String toString(){
        return getInfo();
    }

}

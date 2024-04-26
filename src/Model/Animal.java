package Model;

import java.util.ArrayList;

public class Animal {
    public Integer id;
    //private Integer id;
    private String name;
    private String type;
    private String birthDate;

    private ArrayList<String> commands;

    public Animal (String name, String type, String birthDate ){
        //this.id = id;
        this.name =  name;
        this.type = type;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }
    public void addCommand(String command) {
        commands.add(command);
    }

    public void displayCommands() {
        System.out.println("Commands for " + name + ":");
        for (String command : commands) {
            System.out.println(command);
        }
    }

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
        return info.toString();
    }
    @Override
    public String toString(){
        return getInfo();
    }

}

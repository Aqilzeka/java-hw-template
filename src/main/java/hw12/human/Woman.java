package hw12.human;

import hw12.pet.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Woman extends Human {

    public Woman(String name, String surname, long  year){
        super(name, surname, year);
    }

    public Woman(String name, String surname, long  year, Family family){
        super(name, surname, year, family);
    }

    public Woman(String name, String surname, long year, Pet pet, Family family, Map<String, List<String>> schedule){
        super(name, surname, year, pet, family, schedule);
    }


    public Woman(String name, String surname, String birthday, int iq){
        super(name, surname, birthday, iq);
    }

    public Woman(String name, String surname, long birthday, int iq){
        super(name, surname, birthday, iq);
    }

    @Override
    public void greetPet() {
        System.out.println("GreetPet method from Woman Class");
    }

    public void makeUp() {
        System.out.println("Mother has MakeUp");
    }
}

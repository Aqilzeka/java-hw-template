package hw09.app;

public class Man extends Human {

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public void greetPet() {
        System.out.println("GreetPet method from Woman Class");
    }

    public void repairCar() {
        System.out.println("Father repair the car");
    }
}

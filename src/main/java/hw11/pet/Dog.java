package hw11.pet;

import java.util.List;
import java.util.Random;

public class Dog extends Pet implements Foulable {
    private Random random = new Random();
    public Dog( String nickname, int age, int trickLevel, List<String> habits) {
        super( nickname, age, trickLevel, habits);
        this.setSpecies(Species.DOG);
    }

    public Dog(Species species, String  nickname) {
        super(nickname);
        this.setSpecies(species);
    }

    public Dog() {
    }

    @Override
    public void foul() {
        System.out.println( String.format("I am a Dog, %d", random.nextInt(254)));
    }

    @Override
    public void respond() {
        System.out.println(String.format("I am, %s. Who are you?", this.getNickname()));
    }
}

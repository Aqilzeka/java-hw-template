package hw11.pet;

import java.util.List;
import java.util.Random;

public class Fish extends Pet implements Foulable {

    private Random random = new Random();
    public Fish( String nickname, int age, int trickLevel, List<String> habits) {
        super( nickname, age, trickLevel, habits);
        setSpecies(Species.FISH);
    }

    public Fish(Species species, String  nickname) {
        super(nickname);
        this.setSpecies(species);
    }

    public Fish() {
    }

    @Override
    public void foul() {
        System.out.println( String.format("I am a Fish, %d", random.nextInt(254)));
    }

    @Override
    public void respond() {
        System.out.println(String.format("I am, %s. Who are you?", this.getNickname()));
    }
}

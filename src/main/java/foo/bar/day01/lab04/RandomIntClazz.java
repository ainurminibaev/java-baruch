package foo.bar.day01.lab04;

public class RandomIntClazz {

    private int randomInt;

    @InjectRandomInt(max = 50)
    public void setRandomInt(int randomInt) {
        this.randomInt = randomInt;
    }

    public int getRandomInt() {
        return randomInt;
    }
}
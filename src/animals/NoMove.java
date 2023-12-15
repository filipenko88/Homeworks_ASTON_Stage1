package animals;

public class NoMove implements Moveable {
    @Override
    public void move() {
        System.out.println("Не двигаюсь");
    }
}

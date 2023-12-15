package animals;

public class Cat extends Animal{
    public Cat(double age, double height, double weight, String name){
        setAge(age);
        setHeight(height);
        setWeight(weight);
        setName(name);
        setMovement(new MoveByRun());
    }
    public Cat(String name){
        this.name = name;
        setMovement(new MoveByRun());
    }
    @Override
    public void sound() {
        System.out.println("Мяу!");
    }
}

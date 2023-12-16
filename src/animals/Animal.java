package animals;


public abstract class Animal implements Comparable<Animal> {
    private double height = 50;      // рост, высота от поверхности в см
    private double age = 2;         // возраст в годах
    private double weight = 8;      // в килограммах
    protected String name = "unknown";
    private Moveable movement = new NoMove();

    // издаваемые звуки
    public abstract void sound();

    //
    @Override
    public String toString(){
        return this.getClass().toString()+": "+name +" "+ weight;
    }

    // пока не использую, надо разобраться с вложенными статическими классами
    static class Limb{
        private double length;
        private Limb(double length){
            this.length = length;
        }
    }

    // для сравнения
    public boolean equals(Object obj){
        if (this==obj) return true;
        if (this.getClass() != obj.getClass() || this.hashCode()!=obj.hashCode()) return false;
        if (this.age==((Animal) obj).age && this.height== ((Animal) obj).height
                && this.weight==((Animal) obj).weight && this.name.equals(((Animal) obj).name) ) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return (int)(age+height+weight);
    }

    @Override
    public int compareTo(Animal animal){
        return this.getName().compareTo(animal.getName());
    }

    // геттеры
    public double getAge(){
        return age;
    }
    public double getHeight(){
        return height;
    }
    public double getWeight(){
        return weight;
    }
    public String getName(){
        return name;
    }
    public Moveable getMovement(){
        return movement;
    }

    // сеттеры
    public void setHeight(double height){
        this.height = height;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public void setAge(double age){
        this.age = age;
    }
    public void setName( String name){
        this.name = name;
    }
    protected void setMovement(Moveable movement){
        this.movement = movement;
    }

}


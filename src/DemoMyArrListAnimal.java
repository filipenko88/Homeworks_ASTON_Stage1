import animals.*;

import java.util.ArrayList;

public class DemoMyArrListAnimal {
    public static void main(String[] args) throws ClassNotFoundException {
        MyArrList<Animal> zoo = new MyArrList<>(5);
        System.out.println("zoo пустой? "+zoo.isEmpty()+ " "+zoo.size());
        zoo = new MyArrList<>(createTestData());

        //System.out.println("Удалили: "+zoo.remove(2));



        System.out.println(zoo);
        System.out.println("zoo пустой? "+zoo.isEmpty()+ " "+zoo.size());
        zoo.sort();
        System.out.println(zoo);


    }
    // создадим набор тестовых данных из кошек и собак
    private static ArrayList<Animal> createTestData(){
        ArrayList<Animal> pets = new ArrayList<>();
        pets.add(new Cat(2,25, 4 , "Кошь"));
        pets.add(new Dog(8,38, 10 , "Бобик"));
        pets.add(new Dog(3,25, 4 , "Шарик"));
        pets.add(new Dog(2,22, 3.5, "Кента" ));
        pets.add(new Cat(3,25, 4 , "Барсик"));
        pets.add(new Cat(2,22, 3.5, "Пушок" ));
        pets.add(new Dog(4,28, 4, "Кукуша"));
        pets.add(new Dog(10,45, 9 , "Дэвид"));
        pets.add(new Cat(3,25, 4.1, "Зося"));
        pets.add(new Cat(2.5,28, 6 , "Люма"));
        pets.add(new Dog(7,50, 12 , "Арчи"));
        pets.add(new Dog(5.5,38, 8.2 , "Бара"));
        pets.add(new Cat(10,26, 6.4, "Тяпа" ));
        pets.add(new Cat(5,24, 5 , "Кыш"));
        pets.add(new Cat(0.5,15, 2 , "Цапа"));
        pets.add(new Dog(0.5,24, 3, "Жучка"));
        pets.add(new Cat(7,23, 3.9, "Чика"));
        pets.add(new Cat(1,23, 3.5 , "Муся"));
        pets.add(new Dog(4.5,30, 7, "Лора"));
        pets.add(new Dog(2,60, 18, "Ганс"));
        return pets;
    }
}

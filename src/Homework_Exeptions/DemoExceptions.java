import java.util.ArrayList;
import java.util.Random;

public class DemoExceptions {
    public static void main(String[] args) {
        //Demo1();
        //Demo2();
        Demo3();
        //Demo4();
        //Demo5();


    }

    //1. Объявите ссылочную переменную со значением null.
    //      Вызовите метод у этой переменной. Отловить возникшее исключение c помощью блока try-catch.
    static void Demo1() {
        try {
            ArrayList<Integer> list = null;
            System.out.println(list.add(5));
        } catch (NullPointerException ex) {
            System.out.printf("Возникла ошибка: %s (%s)\n", ex, ex.getMessage());
        }
    }

    // 2. Написать код, который создаст, а затем отловит ArrayIndexOutOfBoundsException.
    static void Demo2() {
        try {
            int[] arr = {1, 4, 2, 8, 5};
            System.out.println(arr[8]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.printf("Возникла ошибка: %s. Попытка обратиться к элементу № %s\n",
                    ex, ex.getMessage());
        }
    }

    // 3. Создать собственный класс-исключение - наследник класса Exception.
    //      Создать метод, выбрасывающий это исключение. Вызвать этот метод и отловить исключение.
    //      Вывести stack trace в консоль.
    static void Demo3() {

        Person ivan = new Person("Иван", 25);
        Person tatiana = new Person("Татьяна", 30);
        Person petr = new Person("Пётр", 15);

        try {
            tatiana.buy("Молоко");
            tatiana.buy("Алкоголь");
            petr.buy("Макароны");
            ivan.buy("Сигареты");
            petr.buy("Сигареты");
            tatiana.buy("Хлеб");
        }catch(MyIllegalSaleException ex){
            ex.printStackTrace();
        }
    }

    // 4. Бросить одно из существующих в JDK исключений, отловить его и
    //      оберните его в свое кастомное исключение указав в качестве причины отловленное.
    static void Demo4(){
        try {
            int[] arr = {1, 4, 2, 8, 5};
            System.out.println(arr[8]);
        } catch (Exception ex) {
            throw new MyIllegalSaleException(ex);
        }
    }

    // 5. Создать метод случайным образом выбрасывающий одно из 3-х видов исключений.
    //      Вызвать этот метод в блоке try-catch, отлавливающим любое из 3-х.
    static void Demo5(){
        try{
            throwRandomException();
        }catch(RuntimeException ex){
            System.out.println("Выброшено исключение: "+ex);
        }
    }
    static void throwRandomException(){
        Random rnd = new Random();
        switch (rnd.nextInt(1000)%3){
            case 0:
                throw new ArrayIndexOutOfBoundsException();
            case 1:
                throw new NullPointerException();
            case 2:
                throw new MyIllegalSaleException();
        }
    }
}

// Классы для выполнения задания
    class MyIllegalSaleException extends RuntimeException {
        MyIllegalSaleException(String product) {
            super("Попытка незаконной продажи товара \""+product+"\"\n");
        }
        MyIllegalSaleException(Throwable ex) {
            super("Оборачиваем отловленное исключение.", ex);
        }
        MyIllegalSaleException() {
            super();
        }
    }

    class Person {
        private int age;
        private String name;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge(){return age;}
        public String getName(){return name;}
        public void buy(String product){
            System.out.printf("%s (возраст: %d) покупает %s\n", name, age, product);
            if( (product.equals("Сигареты") || product.equals("Алкоголь")) && age<18 )
                throw new MyIllegalSaleException(product);
            else
                System.out.printf("    %s (возраст: %d) приобрёл %s\n", name, age, product);
        }
    }
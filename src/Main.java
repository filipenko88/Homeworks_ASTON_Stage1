public class Main {
    public static void main(String[] args){
        MyArrList<Integer> arr = new MyArrList<>(5);
        arr.set(0,5);
        arr.set(1,7);
        arr.set(2,11);
        arr.set(3,9);
        arr.set(4,1);
        arr.set(0,4);
        System.out.println(arr);
        System.out.printf("длина массива: %d \n", arr.getLen());
        System.out.println("размер коллекции: "+ arr.size());

        arr.add(3);
        arr.add(1,33);
        arr.add(3333);
        arr.add(1,3333);
        System.out.println(arr);
        System.out.println("длина массива: "+ arr.getLen());
        System.out.println("размер коллекции: "+ arr.size());

        System.out.println("incrSize:"+arr.incrSize());
        arr.remove(1);
        System.out.println("incrSize:"+arr.incrSize());
        arr.remove(1);
        System.out.println("incrSize:"+arr.incrSize());
        arr.remove(1);
        System.out.println("incrSize:"+arr.incrSize());
        System.out.println(arr);
        System.out.println("длина массива: "+ arr.getLen());
        System.out.println("размер коллекции: "+ arr.size());

    }
}

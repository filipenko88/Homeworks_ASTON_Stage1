public class DemoMyArrListInteger {
    public static void main(String[] args) {
        MyArrList<Integer> arr = new MyArrList<>(5);
        arr.add(5);
        arr.add(7);
        arr.add(11);
        arr.add(9);
        arr.add(1);
        arr.set(0,4);
        arr.add(18);
        arr.add(1);
        arr.add(-18);
        arr.add(7);
        arr.add(0,14);

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


        arr.remove(1);

        arr.remove(1);

        arr.remove(1);

        System.out.println(arr);
        System.out.println("длина массива: "+ arr.getLen());
        System.out.println("размер коллекции: "+ arr.size());
        arr.sort();
        System.out.println(arr);


    }

}

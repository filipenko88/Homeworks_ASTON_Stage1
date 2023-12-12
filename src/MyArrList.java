// Класс-обёртка над массивом элементов одного типа
public class MyArrList<T> { //implements List<T>
    private T[] elements;
    private int size;
    private int userIncrSize = -1;

    //- конструктор
    public MyArrList(int size){
       this.elements = (T[]) new Object[size];
       this.size = size;
    }
    //- перегружаем конструктор
    public MyArrList(int size, int incrSize) {
        this.elements = (T[]) new Object[size];
        this.size = size;
        this.userIncrSize = incrSize;
    }
    // размер списка - соответствует размеру массива, задействованного пользователем
    public int size() {
        return size;
    }
    // количество элементов, на которое увеличивается массив
    public int incrSize(){
        return (userIncrSize==-1)?elements.length/2:userIncrSize;
    }
    public int getLen() {
        return elements.length;
    }
    // проверка на отсутствие элементов В КОЛЛЕКЦИИ
    public boolean isEmpty() {
        return size==0;
    }

    // для наглядного вывода
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i=0; i<size; i++){
            str.append(elements[i].toString()+" ");
        }
        return str.toString();
    }

    // 1. Получить элемент по индексу
    public T get(int index) {
        return elements[index];
    }
    // 2.1 Получение индекса элемента по значению
    public int indexOf(T o) {
        for(int i=0; i<size; i++)
            if (elements[i].equals(o)) return i;
        return -1;
    }
    // 2.2 Проверка на наличие конкретного элемента
    public boolean contains(T o) {
        for(T elem: elements)
            if ( elem.equals(o) )
                return true;
        return false;
    }

    // 3.1 Установка значения элемента на позиции index в коллекции
    public T set(int index, T element) {
        // если индекс за пределами массива elements
        if (index>=elements.length) {
            // определяем, сколько раз incrSize укладывается в разницу
            int factor = (int) Math.ceil( (double)(index - elements.length+1)/incrSize() );
            // переписываем elements в массив большей длины (с учётом incrsize)
            elements = rewriteElements(elements.length+factor*incrSize(), size-1);
            // актуализируем текущий размер, доступный пользователю
            size = index+1;
        }
        return elements[index] = element;
        // нужно понимать, что все неназначенные элементы - null - ПРОВЕРИТЬ
    }

    // 3.2 Вставка элемента на позицию index в коллекции
    public void add(int index, T element) {
        // если уже нет запаса по длине массива elements
        if ((++size) > elements.length) {
            // переписываем в новый массив все эл-ты до позиции index
            T[] temp = rewriteElements(size+incrSize(), index - 1);
            //temp[index] = element;
            // и дописываем оставшиеся элементы
            for (int i = index + 1; i < size; i++)
                temp[i] = elements[i - 1];
            elements = temp;
        } else
            for (int i = size-1; i >index; i--)
                elements[i] = elements[i-1];
        // не забываем вставить новый элемент
        elements[index] = element;

    }
    // 3.3 Вставка в конец коллекции
    public void add(T element) {
        add(size, element);
    }

    // 4. Удаление элемента из коллекции
    public T remove(int index) {
        T result = elements[index];
        if(elements.length-(--size)>incrSize()){
            T[] temp = rewriteElements(size, index-1);
            for(int i=index; i<size; i++)
                temp[i] = elements[i+1];
            elements = temp;
        }else
            for(int i=index; i<size; i++)
                elements[i]=elements[i+1];
        return result;
    }
    // вспомогательный метод, переписывающий elements в новый массив длиной length до позиции index включительно
    private T[] rewriteElements(int length, int index){
        // создаём временный массив
        T[] temp = (T[]) new Object[length];
        // переписываем в него elements и присваиваем эту ссылку
        for(int i=0; i<=index ; i++)
            temp[i] = elements[i];
        return temp;
    }


    /*
    T[] temp = rewriteElements(--size, index-1);
        for(int i=index; i<size; i++)
            temp[i] = elements[i+1];
        T result = elements[index];
        elements = temp;
        return result;




    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }



    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        for(int i=0; i<size; i++)
            if (elements[i].equals( (T)o )) lastIndex = i;
        return lastIndex;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    */





}

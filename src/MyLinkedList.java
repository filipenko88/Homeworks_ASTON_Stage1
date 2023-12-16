import java.util.Comparator;
import java.util.List;

// класс-обёртка над элементами, последовательно связанными друг с другом
public class MyLinkedList<T extends Comparable<? super T>>{
    private MyLink first;    // ссылка на 1-й элемент
    private MyLink last;     // ссылка на последний элемент
    private int size;

    public MyLink getFirst(){
        return first;
    }
    public MyLink getLast(){
        return last;
    }
    public int size(){ return size;};

    public MyLinkedList(List<T> list){
        size = list.size();
        MyLink prevLink =  new MyLink(list.get(0), null, null);
        MyLink curLink =new MyLink(list.get(1), prevLink, null);
        prevLink.next = curLink;
        first = prevLink;
        for(int i=2; i<list.size(); i++){
                prevLink = curLink;
                curLink = new MyLink(list.get(i), prevLink, null);
                prevLink.next = curLink;
        }
        last = curLink;
    }

    // проверка на отсутствие элементов в коллекции
    public boolean isEmpty() {
        return size==0;
    }

    // 1. Получить элемент по индексу
    public T get(int index) {   // уточнить: искать можно с конца
        MyLink<T> link = first;
        for(int i=0; i<size; i++)
            if (i==index){ return link.getObj();}
            else{ link = link.next;}
        return null;
    }

    // 2. Получение индекса элемента по значению, если такого нет - возвращает -1
    public int indexOf(T element) {
        for(int i=0; i<size; i++) {
            MyLink link = first;
            if (link.obj.equals(element)){ return i; }
            else{ link = link.next;}        // повторяется код =>  можно ли убрать его в отдельный метод Обход коллекции
        }
        return -1;
    }

    // 3.1 Установка значения элемента на позиции index в коллекции
    public T set(int index, T element) {
        // если индекс в пределах массива elements
        if (index<size)
            return (T) (getLink(index).obj = element);
        return null;
    }

    // 3.2 Вставка элемента на позицию index в коллекции
    public void add(int index, T element) {
        try{
            if(index>0){
                MyLink prev = getLink(index-1);
                MyLink next = getLink(index);
                MyLink curLink = new MyLink(element, prev, next);
                prev.next = curLink;
                next.prev = curLink;
            }else{
                MyLink link = new MyLink(element, null, first);
                first.prev = link;
            }
        }catch(NullPointerException e){
            System.out.println(e.toString());
        }
    }

    // 3.3 Вставка в конец коллекции
    public void add(T element) {
        try{
            MyLink link = new MyLink(element, last, null);
            last.next = link;
        }catch(NullPointerException e){
            System.out.println(e.toString());
        }
    }

    // 4. Удаление элемента из коллекции
    public T remove(int index) {
        // если индекс в пределах коллекции    }
        if (index<size) {
            MyLink link = getLink(index);
            link.prev.next = link.next;
            link.next.prev = link.prev;
            return (T) link.obj;
        }
        return null;
    }

    // 5. Сортировка элементов методом пузырька
    public void sort(Comparator<T> comparator){
        for(int i=0; i<size-1; i++)
            for (int j = 0; j < (size-1)-i; j++) {
                MyLink<T> link1 = getLink(j);
                MyLink<T> link2 = getLink(j + 1);
                if (comparator.compare( link1.obj, link2.obj) > 0)
                    reput(link1, link2);
            }

    }

    // для наглядного вывода
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i=0; i<size; i++){
            str.append(get(i).toString()+" \n");
        }
        return str.toString();
    }

    // внутренний метод: возвращает элемент-обёртку по индексу
    private MyLink<T> getLink(int index){
        if (index<size){
            MyLink link = first;
            for(int i=0; i<size; i++) {
                if (i == index)
                    return link;
                link = link.next;
            }
        }
        return null;
    }
    // внутренний метод: меняет местами объекты в элементах-обёртках (т.е. перекладывает)
    private void reput(MyLink<T> link1, MyLink<T> link2){
        T obj = link1.obj;
        link1.obj = link2.obj;
        link2.obj = obj;
    }



    // внутренний класс-обёртка над объектами в составе MyLinkedList
     private class MyLink<T>{
        private T obj;
        private MyLink prev;
        private MyLink next;
        MyLink(T obj, MyLink prev, MyLink next){
            this.obj =  obj;
            this.prev = prev;
            this.next = next;
        }

        T getObj(){
            return obj;
        }

    }


}

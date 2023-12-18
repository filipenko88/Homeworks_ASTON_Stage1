
import java.util.*;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        System.out.println("Все транзакции за 2011 год:");
        transactions.stream()
                .filter(t-> t.getYear()==2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);

        // 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        System.out.println("Города, в которых работают трейдеры:");
        Trader[] traders = {raoul, mario, alan, brian};
        List<String> cities = Arrays.stream(traders)
                .map(tr->tr.getCity())
                .collect(Collectors.toList());
        cities.stream().distinct().forEach(System.out::println);

        // 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        System.out.println("Все трейдеры из Кембриджа:");
        Arrays.stream(traders)
                .filter( tr->tr.getCity().equals("Cambridge") )
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        // 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        StringBuilder names = new StringBuilder();
        Arrays.stream(traders)
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(tr -> names.append(tr.getName()+" "));
        System.out.println("Все трейдеры:"+names); //Collector.joining?


        // 5. Выяснить, существует ли хоть один трейдер из Милана.
        List<Trader> isFrom = Arrays.stream(traders)
                .filter( tr->tr.getCity().equals("Milan") )
                .collect(Collectors.toList());
        System.out.println("Трейдеров из Милана: "+ isFrom.size());

        // 6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        System.out.println("Суммы всех транзакций трейдеров из Кембриджа: ");
        transactions.stream()
                .filter(tran->tran.getTrader().getCity().equals("Cambridge"))
                .forEach(tran->System.out.println(tran.getValue()));

        // 7. Какова максимальная сумма среди всех транзакций?
        int max = transactions.stream().map(tran->tran.getValue())
                .collect(Collectors.toList()).stream().max((val1, val2)->val1-val2).get();
System.out.println("Максимальная сумма: "+max);

        // 8. Найти транзакцию с минимальной суммой.
        System.out.print("Минимальная сумма: ");
        transactions.stream()
                .map(Transaction::getValue)
                .sorted((val1, val2)->val1-val2)
                .limit(1)
                .forEach(System.out::println);

    }
}

package modern_in_java.chap5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class main {
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

        //1. 2011년에 일어난 모든 트랜잭션을 찾아 오름차순으로 정리
        List<Transaction> tr2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        //2. 거래자가 근무하는 모든 도시를 중복 없이 나열
        List<String> cities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(toList());

        //3. 케임브리지에서 근무하는 모든 거래자를 찾아 이름순으로 정렬
        List<Trader> trandersInCB = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equalsIgnoreCase("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());

        //4. 모든 거래자의 이름을 알파벳순으로 정렬해 반환
        String traderStr = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2); //cf. collect(joining()) --> joining은 내부적으로 StringBuilder를 이용

        //5. 밀라노에 거래자가 있는가?
        boolean milanBased = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equalsIgnoreCase("Milan")); //anyMatch에 프레디케이트를 전달
        
        //6. 케임브리지에 거래하는 거래자의 모든 트랜잭션값을 출력
        transactions.stream()
                .filter(t -> "Cambridge".equalsIgnoreCase(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //7. 전체 트랜잭션 중 최댓값
        Optional<Integer> higestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        //8. 전체 트랜잭션 중 최솟값
//        Optional<Transaction> smallestTransaction = transactions.stream()
//                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        Optional<Transaction> smallestTransaction = transactions.stream()
                .min(comparing(Transaction::getValue));


        //퀴즈 5-4 피보나치수열 집합
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0]+t[1]} ).limit(20).forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));

    }
}

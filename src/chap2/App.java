package chap2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {

	public static void main(String[] args) {
		List<String> name = new ArrayList<>();
		name.add("keesun");
		name.add("whiteship");
		name.add("toby");
		name.add("foo");
		
//		name.forEach(System.out::println);
		
		Spliterator<String> spliterator = name.spliterator();
		Spliterator<String> spliterator1 = spliterator.trySplit();
		while (spliterator.tryAdvance(System.out::println));
		System.out.println("========================");	
		while (spliterator1.tryAdvance(System.out::println));
		
		System.out.println("========================");
		
		long k = name.stream().map(String::toUpperCase)
				.filter(s -> s.startsWith("K"))
				.count();
		
		System.out.println(k);
		
		Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
		name.sort(compareToIgnoreCase.reversed());
		
		name.removeIf(s -> s.startsWith("k"));
		name.forEach(System.out::println);
		
	}
}

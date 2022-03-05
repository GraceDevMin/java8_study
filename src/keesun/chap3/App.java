package keesun.chap3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		List<String> name = new ArrayList<>();
		name.add("keesun");
		name.add("whiteship");
		name.add("toby");
		name.add("foo");
		
		//중개형 오퍼레이터들이 lazy하게 처리가 됨
		List<String> collect = name.stream().map(s -> {	
			System.out.println(s);
			return s.toUpperCase();
		}).collect(Collectors.toList());
		collect.forEach(System.out::println);
		
		System.out.println("==================");
		
		name.forEach(System.out::println);
	}

	
	
}

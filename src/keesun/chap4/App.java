package keesun.chap4;

import keesun.chap4.OnlineClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		Optional<OnlineClass> spring = springClasses.stream()
				.filter(oc -> oc.getTitle().startsWith("spring"))
				.findFirst();

		boolean present = spring.isPresent();
		System.out.println(present);

		Optional<OnlineClass> jpa = springClasses.stream()
				.filter(oc -> oc.getTitle().startsWith("jpa"))
				.findFirst();

		present = jpa.isEmpty();
		System.out.println(present);

		Optional<OnlineClass> optional = springClasses.stream()
				.filter(oc -> oc.getTitle().startsWith("spring"))
				.findFirst();

//		OnlineClass onlineClass = optional.orElseGet(App::createNewClass); //cf. orElse
//		System.out.println(onlineClass.getTitle());

//		Optional<OnlineClass> onlineClass = optional.filter(oc -> !oc.isClosed());	//filter의 결과가 Optional
//		System.out.println(onlineClass.isEmpty());

		Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);
	}

	private static OnlineClass createNewClass() {
		System.out.println("creating new online class");
		return new OnlineClass(10, "New class", false);
	}


}

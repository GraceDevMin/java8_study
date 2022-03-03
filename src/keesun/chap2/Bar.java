package keesun.chap2;

public interface Bar{

	//만약 Foo의 default메서드를 그대로 구현하기 싫다면 이렇게 추상메서드로 구현할 수 있음
	//그렇다면  Bar의 구현체들이 모두 이 메서드를 무조건 구현해야함.
//	void printNameUpperCase();
	
	default void printNameUpperCase() {
		System.out.println("BAR");
	}
}

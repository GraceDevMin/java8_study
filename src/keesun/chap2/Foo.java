package keesun.chap2;

public interface Foo {

	void printName();
	
	/**
	 * @implSpec 
	 * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출련한다.
	 */
	default void printNameUpperCase() {
		System.out.println(getName().toUpperCase());
	}
	
	static void printAnyString() {
		System.out.println("Foo");
	}
	
	String getName();
}

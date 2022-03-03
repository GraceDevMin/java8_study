package chap2;

public class App {

	public static void main(String[] args) {
		Foo foo = new DefaultFoo("keesun");
		foo.printName();
		foo.printNameUpperCase();
		
		Foo.printAnyString();
	}
}

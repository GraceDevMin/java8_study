package keesun.chap2;

public class DefaultFoo implements Foo, Bar{

	String name;
	
	public DefaultFoo(String name) {
		super();
		this.name = name;
	}
	
	
//	//인터페이스 구현체가 default 메서드를 재정의
//	@Override
//	public void printNameUpperCase() {
//		System.out.println(this.name.toUpperCase());
//	}


	@Override
	public void printName() {
		System.out.println(this.name);
	}

	@Override
	public String getName() {
		return this.name;
	}


	//Foo, Bar 모두를 구현하는 경우 둘다 default메서드로 같은 메서드를 가지고 있으므로 컴파일 에러
	//직접 오버라이딩해야 컴파일 에러가 사라짐
	@Override
	public void printNameUpperCase() {
		// TODO Auto-generated method stub
		Bar.super.printNameUpperCase();
	}

}

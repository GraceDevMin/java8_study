package chap1;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class Foo {

    public static void main(String[] args) {
    	Foo foo = new Foo();
    	foo.run();

    }
    
    private void run() {
    	int baseNumber = 10; //effective final
    	
    	//로컬 클래스 (셰도잉 O)
    	class LocalClass { 
    		void printBaseNumber() {
    			int baseNumber = 11;
    			System.out.println(baseNumber);
    		}
    	}
    	
    	//익명 클래스 (셰도잉 O)
    	Consumer<Integer> integerConsumer = new Consumer<Integer>() {

			@Override
			public void accept(Integer baseNumber) {
				System.out.println(baseNumber);
				
			}
		};
    	
    	//람다 (셰도잉 X, 이 람다를 감싸고 있는 run과 같은 scope)
		IntConsumer printInt = (i) -> {
			System.out.println(i + baseNumber);
		};
		
		printInt.accept(10);
		
//		baseNumber++; 
    }
}

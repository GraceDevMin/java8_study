package chap1;

//추상메서드가 하나만 있으면 함수형 인터페이스
@FunctionalInterface
public interface RunSomething {

    int doIt(int number);

    static void printName() {
        System.out.println("Keesun");
    }

    default void printAge() {
        System.out.println("40");
    }

//    void doItAgain(); //추상메서드가 두개 있으면 함수형 인터페이스 아님..
}

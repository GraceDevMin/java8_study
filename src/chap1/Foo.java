package chap1;

public class Foo {

    public static void main(String[] args) {
        // 익명 내부 클래스 (anonymous inner class)
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("Hello");
//            }
//        }

        RunSomething runSomething = new RunSomething() {
            final int baseNumber = 10; //함수 밖에 있는 값, 상태값을 가지고 있다. 의존한다. -> 퓨어한 함수X
            //또는 외부의 있는 값을 변경하는 경우 -> 퓨어한 함수 X
            @Override
            public int doIt(int number) {
                return number + baseNumber;
            }
        }


    }
}

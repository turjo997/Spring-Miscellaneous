package inheritance_pck;

import java.io.IOException;

class Parent{
    void message(){
        System.out.println("Parent Method");
    }
}
public class TestExceptionChild1 extends Parent{

    // give compile time error as IOException is a checked exception

//    void message() throws IOException {
//        System.out.println("child method");
//    }


    // no error will show as ArithmeticException is an unchecked exception
    @Override
    void message() throws ArithmeticException {
        System.out.println("child method");
    }

    public static void main(String[] args) {
         Parent p = new TestExceptionChild1();
         p.message();
    }
}

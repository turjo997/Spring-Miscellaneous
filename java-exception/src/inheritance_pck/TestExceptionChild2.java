package inheritance_pck;

import java.io.IOException;

class Father{
    void msg() throws ArithmeticException{
        System.out.println("parent method");
    }

    void msg2() throws ArithmeticException{
        System.out.println("parent method");
    }
}
public class TestExceptionChild2 extends Father {

    // give error as super class declare exception which is parent of all exception

//    @Override
//    void msg() throws Exception{
//        System.out.println("child method");
//    }


    // give error as super class declared exception does not match
//    void msg() throws IOException {
//        System.out.println("child method");
//    }


    // no error will occur as super class declared exception matches
    void msg()throws ArithmeticException {
        System.out.println("child method");
    }

    void msg2() {
        System.out.println("child method");
    }

    public static void main(String[] args) {
        Father p = new TestExceptionChild2();

        try {
            p.msg();
        }
        catch(Exception e) {

        }

}
}

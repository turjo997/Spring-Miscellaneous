package throws_pck;

class MyClass{
    void validate(int age){
        if (age < 18){
              throw new ArithmeticException("Not eligible to vote");
        }else{
            System.out.println("Eligible to vote");
        }

    }
}

public class TestThrow {

    public static void main(String[] args) {
          MyClass ob = new MyClass();
          ob.validate(13);
          System.out.println("normal workflow");
    }
}

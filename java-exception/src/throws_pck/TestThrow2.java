package throws_pck;

class UserDefinedException extends Exception{

    public UserDefinedException(String message){
        super(message);
    }
}

class MyClassB{
    void validate(int age) throws UserDefinedException {
        if (age < 18){
            throw new UserDefinedException("Not eligible to vote");
        }else{
            System.out.println("Eligible to vote");
        }

    }

    void validate2(int age){
        if (age < 18){
            try {
                throw new UserDefinedException("Not eligible to vote");
            } catch (UserDefinedException e) {
                //throw new RuntimeException(e);
                System.out.println("Caught the exception");
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Eligible to vote");
        }

    }

    void validate3(int age) throws UserDefinedException {
        if (age < 18){
            throw new UserDefinedException("Not eligible to vote. So sorry !");
        }else{
            System.out.println("Eligible to vote");
        }

    }
}

public class TestThrow2 {

    public static void main(String[] args) throws UserDefinedException {
        MyClassB ob = new MyClassB();

        //ob.validate(13);
        //ob.validate2(17);

        try{
            ob.validate3(12);
        }catch (UserDefinedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("normal workflow");
    }
}
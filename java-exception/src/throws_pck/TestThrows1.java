package throws_pck;

import java.io.IOException;

public class TestThrows1 {

    void M() throws IOException{
        throw new IOException("device error"); //checked exception
    }


    void N() throws IOException {
      M();
    }

    void P(){
       try {
           N();
       }catch (Exception e){
           System.out.println("exception handled");
       }
    }

    public static void main(String[] args) {
        TestThrows1 ob = new TestThrows1();
        ob.P();
        System.out.println("normal flow...");

    }
}

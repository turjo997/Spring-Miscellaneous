package throws_pck;

import java.io.IOException;

class MM{
    void method() throws IOException{
        System.out.println("device operation performed");
    }
}

public class Testthrows3 {

    public static void main(String[] args) throws IOException {
         MM ob = new MM();
         ob.method();
         System.out.println("normal flow...");

    }
}

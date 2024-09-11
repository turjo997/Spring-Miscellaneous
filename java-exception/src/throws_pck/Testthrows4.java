package throws_pck;

import java.io.IOException;

class MMM{
    void method() throws IOException {
        throw new IOException("device error");
    }
}

public class Testthrows4 {

    public static void main(String[] args) throws IOException {
        MMM ob = new MMM();
        ob.method();
        System.out.println("normal flow...");

    }
}

package problems;

import java.util.Scanner;

class fibonacci {

    public static Long[] fib = new Long[51];

    public static Long getFib(Long n) {
        if (n <= 1) {
            fib[Math.toIntExact(n)] = n;
            return n;
        }
        if (fib[(int) (n - 1)] == -1) {
            fib[(int) (n - 1)] = getFib(n-1);
        }

        if (fib[(int) (n - 2)] == -1) {
            fib[(int) (n - 2)] = getFib(n-2);
        }
        return fib[(int) (n - 1)] + fib[(int) (n - 2)];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        for (int i = 0; i < 51; ++i) {
            fib[i] = (long) -1;
        }

        getFib(n);

        for (long x : fib){
            System.out.println(x);
        }


    }
}
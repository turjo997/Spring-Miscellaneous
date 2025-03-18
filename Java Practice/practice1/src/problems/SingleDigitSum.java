package problems;

import java.util.Scanner;

public class SingleDigitSum {

    public static int singleDigit(int n){

        while(n >= 10){
            int sum = 0 ;
            while (n > 0){
                sum += n%10;
                n /= 10;
            }
            n = sum;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(singleDigit(n));
    }
}

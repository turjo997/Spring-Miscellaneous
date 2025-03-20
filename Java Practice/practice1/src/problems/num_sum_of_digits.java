package problems;

import java.util.Scanner;

public class num_sum_of_digits {
    public static int cnt = 0;
    public static int numberDigits(int n){
        if(n == 0){
            return cnt;
        }
        ++cnt;
        return numberDigits(n/10);
    }

    public static int sumDigits(int n){
        int sum = 0;
        while (n != 0){
             sum += (n % 10);
             n /= 10;
         }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(numberDigits(num));
        System.out.println(sumDigits(num));
    }
}

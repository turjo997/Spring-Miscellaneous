package problems;

import java.util.Scanner;

public class IntegerPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = n;
        int rev = 0;

        while(x != 0){
            int rem = x%10;
            rev = rev*10 + rem;
            x = x/10;
        }
        if(rev == n){
            System.out.println("palindrome");
        }else{
            System.out.println("not palindrome");
        }
    }
}

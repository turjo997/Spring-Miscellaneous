package problems;

import java.util.Scanner;

public class StringPalindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s2 = "";

        for (int i = s.length() - 1; i >= 0 ; i--){
            s2 += s.charAt(i);
        }

        if(s.equals(s2)){
            System.out.println("palindrome");
        }else{
            System.out.println("not palindrome");
        }


    }
}

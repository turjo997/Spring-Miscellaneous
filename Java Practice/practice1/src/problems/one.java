package problems;

import java.util.Scanner;

public class one {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int s = 0;
//        for(int i = 0 ; i < n ; ++i){
//            s += i;
//        }

//        String s = sc.nextLine();
//
//        System.out.println("The string is " +s);

        String s = "abcde";

        // Remove first character
        String removeFirst = s.substring(1);
        System.out.println("Without first character: " + removeFirst); // "bcde"

        // Remove last character
        String removeLast = s.substring(0, s.length() - 1);
        System.out.println("Without last character: " + removeLast); // "abcd"


    }
}

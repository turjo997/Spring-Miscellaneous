package problems;

import java.util.Scanner;

public class oddOccurences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] ar = new int[n];
        for(int i = 0 ; i < n ; ++i){
            ar[i] = sc.nextInt();
        }

        int res = 0 ;

        for(int x : ar){
            res = res ^ x;
        }

        System.out.println(res);

    }
}

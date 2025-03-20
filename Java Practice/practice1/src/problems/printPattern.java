package problems;

import java.util.Scanner;

public class printPattern {

    public static void print(int n){
        int a = n , b = n;
        for(int i = 1 ; i <= n ; ++i){
            for(int j = 1; j <= n*2 - 1 ;++j){
                if(j < a || j >b){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            --a;
            ++b;
            System.out.println();
        }

    }

    public static void print5(int n){
        int a = 1 , b = n*2 - 1;
        for(int i = 1 ; i <= n ; ++i){
            for(int j = 1; j <= n*2 - 1 ;++j){
                if(j < a || j >b){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            ++a ; --b;
            System.out.println();
        }

    }

    public static void print1(int n){
        for(int i = 1 ; i <= n ; ++i){
            for(int j = 1; j <= i ;++j){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void print2(int n){
        for(int i = 1 ; i <= n ; ++i){
            for(int j = i; j <= n ;++j){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void print3(int n){
        for(int i = n ; i >= 1 ; --i){
            for(int j = 1; j <= i ;++j){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void print4(char ch){
        char ch1 = 'A';
        for(int i = 1 ; i <= ch - 'A' + 1 ; ++i){
            for(int j = 1; j <= i ;++j){
                System.out.print(ch1);
            }
            ++ch1;
            System.out.println();        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        print(n);
        print5(n);
        print1(n);
        print2(n);
        print3(n);
        print4('E');

    }
}

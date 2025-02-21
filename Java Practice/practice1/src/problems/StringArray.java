package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        sc.nextLine();
        ArrayList<String> fruitsArray = new ArrayList<>();

        for(int i = 0 ; i < n ; ++i){
            fruitsArray.add(sc.nextLine());
        }

//        for(int i = 0 ; i < fruitsArray.size() ; ++i){
//            System.out.println(fruitsArray.get(i));
//        }
//
//        for(String fruit : fruitsArray){
//            System.out.println(fruit);
//        }

    //    fruitsArray.remove(1);

        System.out.println(fruitsArray);

        fruitsArray.set(1 , "Janina");
        System.out.println(fruitsArray);

        System.out.println(fruitsArray.contains("Janina"));

        Collections.sort(fruitsArray);

        System.out.println("sorted list is " +fruitsArray);

        String [] arr = fruitsArray.toArray(new String[0]);
        System.out.println(java.util.Arrays.toString(arr));

        for (int i = 0 ; i < arr.length ; ++i){
            System.out.println(arr[i]);
        }

        String []countries = new String[n];

        for(int i = 0; i < countries.length ; ++i){
            countries[i] = sc.nextLine();
        }
        System.out.println(java.util.Arrays.toString(countries));


    }
}

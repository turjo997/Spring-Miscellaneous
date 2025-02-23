package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pair<I extends Number, S> {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tar = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; ++i){
            arr.add(sc.nextInt());
        }
        Map<Integer , Integer> mp = new HashMap<>();
        for(int i = 0 ; i < n ; ++i){
            mp.put(arr.get(i) , i);
        }

        for(int i = 0 ; i < n ; ++i){
            int complement = tar - arr.get(i);
            if(mp.containsKey(complement) && mp.get(complement) != i){
                System.out.println(i + " " +mp.get(complement));
                break;
            }
        }

    }
}

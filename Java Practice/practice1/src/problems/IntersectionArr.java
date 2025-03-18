package problems;

import java.util.*;

public class IntersectionArr {

    public static List<Integer> interSections(int[] ar1, int[] ar2){

        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer , Integer> mp = new HashMap<>();

        for(int num : ar1){
            if(mp.containsKey(num)){
                int cnt = mp.get(num) ;
                mp.put(num , cnt + 1);
            }else{
                mp.put(num , 1);
            }
        }
        Set<Integer> set = new HashSet<>();

        for(int num : ar2){
            if(mp.containsKey(num)){
                 set.add(num);
            }
        }

        for(int num : set) {
            res.add(num);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] ar1 = new int[n];
        int [] ar2 = new int[m];

        for(int i = 0 ; i < n ; ++i){
            ar1[i] = sc.nextInt();
        }

        for(int i = 0 ; i < m ; ++i){
            ar2[i] = sc.nextInt();
        }

        Arrays.sort(ar1);
        Arrays.sort(ar2);

        ArrayList<Integer> res = (ArrayList<Integer>) interSections(ar1 , ar2);

        System.out.println();
        for(int num : res){
            System.out.println(num);
        }
    }
}

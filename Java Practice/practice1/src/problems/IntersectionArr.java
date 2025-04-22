package problems;

import java.util.*;

public class IntersectionArr {

    public static List<Integer> interSections(int[] ar1, int[] ar2) {

        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int num : ar1) {
            if (mp.containsKey(num)) {
                int cnt = mp.get(num);
                mp.put(num, cnt + 1);
            } else {
                mp.put(num, 1);
            }
        }
        Set<Integer> set = new HashSet<>();

        for (int num : ar2) {
            if (mp.containsKey(num)) {
                set.add(num);
            }
        }

        for (int num : set) {
            res.add(num);
        }

        return res;
    }

    public static int[] findIntersection(int[] arr1, int[] arr2) {
        List<Integer> resultList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                if (resultList.isEmpty() || resultList.get(resultList.size() - 1) != arr1[i]) {
                    resultList.add(arr1[i]);
                }
                ++i;
                ++j;
            } else if (arr1[i] < arr2[j]) {
                ++i;
            }else{
                ++j;
            }
        }

        int [] res = new int[resultList.size()];
        for(int k = 0 ; k < resultList.size() ; ++k){
            res[k] = resultList.get(k);
        }

        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        int[] ar1 = new int[n];
//        int[] ar2 = new int[m];
//
//        for (int i = 0; i < n; ++i) {
//            ar1[i] = sc.nextInt();
//        }
//
//        for (int i = 0; i < m; ++i) {
//            ar2[i] = sc.nextInt();
//        }
//
//        Arrays.sort(ar1);
//        Arrays.sort(ar2);
//
//        ArrayList<Integer> res = (ArrayList<Integer>) interSections(ar1, ar2);
//
//        System.out.println();
//        for (int num : res) {
//            System.out.println(num);
//        }


        int[] arr1 = {1, 1, 2, 2, 3, 3, 4, 6, 7 , 7 , 20 , 20 ,50 , 60 ,70};
        int[] arr2 = {2, 2, 3, 4, 4, 5, 10 , 10 , 15 , 15, 20 , 20 , 45 , 60 , 60 , 90};

        int [] result = findIntersection(arr1 , arr2);

        for(int num : result){
            System.out.println(num);
        }

    }
}

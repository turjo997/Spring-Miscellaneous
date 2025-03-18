package problems;

import java.util.Scanner;

public class Anagram {

    public static boolean areAnagrams(String str1 , String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        int [] count = new int[26];

        for(char c : str1.toCharArray()){
            count[c - 'a']++;
        }
        for(char c : str2.toCharArray()){
            count[c - 'a']--;
        }

        for(int num : count){
               if(num != 0){
                   return false;
               }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine().toLowerCase();
        String s2 = scanner.nextLine().toLowerCase();

        if(areAnagrams(s1 , s2)){
            System.out.println("They are anagrams");
        }else{
            System.out.print("They are not anagrams");
        }
    }
}

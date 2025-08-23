package problems.matrix;

import java.util.Scanner;

public class ProgressBar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();

        int total = (n * k * t) / 100;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (total >= k) {
                result[i] = k;
                total -= k;
            } else {
                result[i] = total;
                total = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
    }
}

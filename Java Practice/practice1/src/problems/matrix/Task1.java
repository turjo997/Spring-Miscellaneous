package problems.matrix;

import java.util.Scanner;

public class Task1 {

    public static int diagonalDifference(int [][] mat){
        int n = mat.length;
        int sum1 = 0 ;
        int sum2 = 0 ;

        for(int i = 0 , j =  n-1; i < n ; ++i , --j){
            sum1 += mat[i][i];
            sum2 += mat[i][j];
        }

        return Math.abs(sum1-sum2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [][] matrix = new int[n][n];

        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < n ; ++j){
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(diagonalDifference(matrix));


    }
}

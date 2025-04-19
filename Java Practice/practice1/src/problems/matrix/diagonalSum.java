package problems.matrix;

public class diagonalSum {
    public static int diagonalSum(int [][] mat){
        int n = mat.length;
        int sum = 0 ;

        for(int i = 0 , j =  n-1; i < n ; ++i , --j){
            // primary diagonal
            sum += mat[i][i];
            //secondary diagonal
            sum += mat[i][j];
        }
        if(n % 2 != 0){
            sum -= mat[n/2][n/2];
        }
        return sum;
    }

    public static int [][] transposeMat(int [][] mat){
        int n = mat.length , m = mat[0].length;
        int [][] res = new int[m][n];

        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < m ; ++j){
                res[j][i] = mat[i][j];
            }
        }

        return res;
    }

    public static boolean isIdentityMatrix(int [][] matrix){
        for(int i  = 0 ; i < matrix.length ; ++i){
            for(int j = 0 ; j < matrix[0].length ; ++j){
                if((i == j && matrix[i][j] != 1) || (i != j && matrix[i][j] != 0) ){
                       return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int [][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        System.out.println("Matrix diagonal sum : "+diagonalSum(matrix));

        int [][] transposeMat = transposeMat(matrix);

        for(int i = 0 ; i < transposeMat.length ; ++i){
            for(int j = 0 ; j < transposeMat[0].length ; ++j){
                System.out.print(transposeMat[i][j]+" ");
            }
            System.out.println();
        }

        int[][] matrix2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        System.out.println("Is Identity Matrix? " + isIdentityMatrix(matrix2));
    }
}

import java.util.Scanner;

public class MatrixFunctions {
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                matrix[i][j] = (int)(Math.random() * 10);  
        return matrix;
    }

    public static void displayMatrix(double[][] matrix) {
        for(double[] row : matrix) {
            for(double val : row)
                System.out.printf("%8.2f", val);
            System.out.println();
        }
    }

    public static void displayMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            for(int val : row)
                System.out.printf("%5d", val);
            System.out.println();
        }
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                transposed[j][i] = matrix[i][j];
        return transposed;
    }

    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static int determinant3x3(int[][] m) {
        int det = m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
                - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0])
                + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
        return det;
    }

    public static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        if(det == 0) {
            System.out.println("Inverse does not exist (det = 0)");
            return null;
        }
        double[][] inverse = new double[2][2];
        inverse[0][0] = m[1][1] / (double) det;
        inverse[0][1] = -m[0][1] / (double) det;
        inverse[1][0] = -m[1][0] / (double) det;
        inverse[1][1] = m[0][0] / (double) det;

        return inverse;
    }

    public static double[][] inverse3x3(int[][] m) {
        int det = determinant3x3(m);
        if (det == 0) {
            System.out.println("Inverse does not exist (det = 0)");
            return null;
        }

        double[][] inv = new double[3][3];

        inv[0][0] = (m[1][1]*m[2][2] - m[1][2]*m[2][1]);
        inv[0][1] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]);
        inv[0][2] = (m[1][0]*m[2][1] - m[1][1]*m[2][0]);

        inv[1][0] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]);
        inv[1][1] = (m[0][0]*m[2][2] - m[0][2]*m[2][0]);
        inv[1][2] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]);

        inv[2][0] = (m[0][1]*m[1][2] - m[0][2]*m[1][1]);
        inv[2][1] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]);
        inv[2][2] = (m[0][0]*m[1][1] - m[0][1]*m[1][0]);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                inv[i][j] /= det;

        return inv;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Generating 3x3 random matrix M:");
        int[][] matrix3x3 = createRandomMatrix(3, 3);
        displayMatrix(matrix3x3);

        System.out.println("\nTranspose of Matrix M:");
        int[][] transpose = transposeMatrix(matrix3x3);
        displayMatrix(transpose);
        System.out.println("\nDeterminant of M: " + determinant3x3(matrix3x3));
        System.out.println("\nInverse of M:");
        double[][] inverse = inverse3x3(matrix3x3);
        if (inverse != null)
            displayMatrix(inverse);
        System.out.println("\nGenerating 2x2 random matrix N:");
        int[][] matrix2x2 = createRandomMatrix(2, 2);
        displayMatrix(matrix2x2);
        System.out.println("\nDeterminant of N: " + determinant2x2(matrix2x2));
        System.out.println("\nInverse of N:");
        double[][] inv2 = inverse2x2(matrix2x2);
        if (inv2 != null)
            displayMatrix(inv2);;
    }
}

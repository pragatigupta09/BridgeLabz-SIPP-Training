import java.util.Scanner;

public class MatrixOperations {
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10); 
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = B[0].length;
        int common = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix, String name) {
        System.out.println("\n" + name + ":");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows for Matrix A: ");
        int rowsA = sc.nextInt();
        System.out.print("Enter number of columns for Matrix A (and rows for B): ");
        int colsA = sc.nextInt();
        System.out.print("Enter number of columns for Matrix B: ");
        int colsB = sc.nextInt();
        int[][] A = createRandomMatrix(rowsA, colsA);
        int[][] B = createRandomMatrix(colsA, colsB); 
        printMatrix(A, "Matrix A");
        printMatrix(B, "Matrix B");
        int[][] product = multiplyMatrices(A, B);
        printMatrix(product, "A x B (Product)");
        if (rowsA == colsA && colsA == colsB) {
            int[][] BsameSize = createRandomMatrix(rowsA, colsA);
            printMatrix(BsameSize, "Matrix B (Same Size as A)");
            int[][] sum = addMatrices(A, BsameSize);
            int[][] diff = subtractMatrices(A, BsameSize);
            printMatrix(sum, "A + B");
            printMatrix(diff, "A - B");
        } else {
            System.out.println("\nMatrix addition and subtraction skipped (size mismatch).");
        }
    }
}

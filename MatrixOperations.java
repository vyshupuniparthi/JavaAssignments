package assignfive;

import java.util.Scanner;

public class MatrixOperations {

    // Method to add two matrices
    public static int[][] addMatrices(int[][] mat1, int[][] mat2) {
        if (mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }

        int rows = mat1.length;
        int cols = mat1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
        }

        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
        if (mat1[0].length != mat2.length) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix");
        }

        int rows = mat1.length;
        int cols = mat2[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < mat1[0].length; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }

        return result;
    }

    // Method to transpose a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result[i][j] = matrix[j][i];
            }
        }

        return result;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter dimensions of first matrix (rows columns):");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();
        int[][] mat1 = new int[rows1][cols1];
        System.out.println("Enter elements of first matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                mat1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter dimensions of second matrix (rows columns):");
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();
        int[][] mat2 = new int[rows2][cols2];
        System.out.println("Enter elements of second matrix:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                mat2[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Select operation: ");
        System.out.println("1. Addition");
        System.out.println("2. Multiplication");
        System.out.println("3. Transposition");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                try {
                    int[][] sum = addMatrices(mat1, mat2);
                    System.out.println("\nSum of matrices:");
                    printMatrix(sum);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 2:
                try {
                    int[][] product = multiplyMatrices(mat1, mat2);
                    System.out.println("\nProduct of matrices:");
                    printMatrix(product);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 3:
                System.out.println("\nTranspose of first matrix:");
                int[][] transposed = transposeMatrix(mat1);
                printMatrix(transposed);
                break;
            default:
                System.out.println("Invalid choice");
        }
        scanner.close();
    }
}

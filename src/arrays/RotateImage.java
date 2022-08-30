package arrays;

/**
 * transpose and then reverse row wise
 *      transpose loop DRY for a 3*3, swap symmetrically across diagonal
 *      (0,0),(0,1),(0,2)
 *      (1,1),(1,2)
 *      (2,2)
 *
 *      reverse row wise using two pointers swap
 *
 */

public class RotateImage {
    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    private void reverseRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }

    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);

    }
}

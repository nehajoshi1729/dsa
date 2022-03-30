package arrays;

/**
 * binary search in a 2D matrix
 */

public class SearchMatrix {
    private static boolean searchMatrix(int[][] matrix, int target) {
        int columnSize = matrix[0].length;
        int rowSize = matrix.length;
        int low = 0;
        int high = columnSize * rowSize - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = matrix[mid / columnSize][mid % columnSize];
            if (midValue == target)
                return true;
            else if (midValue < target)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 100;
        System.out.println(searchMatrix(matrix,target));
    }


}

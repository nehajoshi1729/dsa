package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a grid return the number of equal rows and columns
 * Create hash to store cols and rows with their frequencies to get the all possibilities of EqualRowsAndColumns
 * for example if [[1,3],[1,3]] is the grid 2 * 2 = 4 is the correct response, not just 2
 * Iterate over rowHash or colHash to find the intersecting items and do colHash.get(currentRowHash) * rowHash.get(currentRowHash)
 */

public class EqualRowsAndColumns {
    private static int get(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;

        Map<String, Integer> rowHash = new HashMap<>();
        Map<String, Integer> colHash = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String s = getStringRow(i, grid);
            rowHash.put(s, rowHash.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            String s = getStringCol(i, grid);
            colHash.put(s, colHash.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : rowHash.entrySet()) {
            String currentRowHash = entry.getKey();
            if (colHash.containsKey(currentRowHash))
                result += colHash.get(currentRowHash) * rowHash.get(currentRowHash);
        }
        return result;
    }

    private static String getStringRow(int r, int[][] grid) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < grid[0].length; i++) {
            stringBuilder.append(grid[r][i]).append("#");
        }
        return stringBuilder.toString();
    }

    private static String getStringCol(int c, int[][] grid) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            stringBuilder.append(grid[i][c]).append("#");
        }
        return stringBuilder.toString();
    }
}

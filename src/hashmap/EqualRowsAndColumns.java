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
        int n = grid.length;
        int result = 0;
        //<HashString,FrequencyCount>
        Map<String, Integer> rowHash = new HashMap<>();
        Map<String, Integer> colHash = new HashMap<>();
        for (int[] row : grid) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : row) {
                stringBuilder.append(i).append("#"); //creating a hash
            }
            rowHash.put(stringBuilder.toString(), rowHash.getOrDefault(stringBuilder.toString(), 0) + 1);

        }
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                stringBuilder.append(grid[j][i]).append("#");
            }
            colHash.put(colHash.toString(), colHash.getOrDefault(colHash.toString(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : rowHash.entrySet()) {
            String currentRowHash = entry.getKey();
            if (colHash.containsKey(currentRowHash))
                result += colHash.get(currentRowHash) * rowHash.get(currentRowHash);
        }
        return result;
    }
}

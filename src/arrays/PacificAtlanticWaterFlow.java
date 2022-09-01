package arrays;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    private void dfs(int i, int j, boolean[][] canReach, int[][] heights, int prevHeight) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || canReach[i][j] || heights[i][j] < prevHeight)
            return;
        canReach[i][j] = true;
        dfs(i + 1, j, canReach, heights, heights[i][j]);
        dfs(i, j + 1, canReach, heights, heights[i][j]);
        dfs(i - 1, j, canReach, heights, heights[i][j]);
        dfs(i, j - 1, canReach, heights, heights[i][j]);

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return ans;
        int rows = heights.length;
        int columns = heights[0].length;
        boolean[][] pacificReach = new boolean[rows][columns];
        boolean[][] atlanticReach = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            dfs(0, i, pacificReach, heights, Integer.MIN_VALUE);
            dfs(rows - 1, i, atlanticReach, heights, Integer.MIN_VALUE);
        }
        for (int i = 0; i < columns; i++) {
            dfs(i, 0, pacificReach, heights, Integer.MIN_VALUE);
            dfs(i, columns - 1, atlanticReach, heights, Integer.MIN_VALUE);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (pacificReach[i][j] && atlanticReach[i][j]) {
                    List<Integer> indexes = new ArrayList<>();
                    indexes.add(i);
                    indexes.add(j);
                    ans.add(indexes);
                }
            }
        }
        return ans;

    }
}

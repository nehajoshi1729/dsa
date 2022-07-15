package recursion;

/**
 * classic dfs
 */

public class MaxIslands {
    private int get(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    maxArea = Math.max(maxArea, getArea(grid, i, j));
            }
        }
        return maxArea;
    }

    private int getArea(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j >= grid[0].length || j < 0 || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        return 1 + getArea(grid, i + 1, j) + getArea(grid, i, j + 1) + getArea(grid, i - 1, j) + getArea(grid, i, j - 1);

    }
}

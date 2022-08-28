package arrays;

import java.util.PriorityQueue;

public class SortMatrixDiagonally {
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    public int[][] diagonalSort(int[][] mat) {
        int[][] visited = new int[mat.length][mat[0].length];
        for(int i = 0;i < mat.length;i++)
        {
            for(int j = 0; j < mat[0].length;j++)
            {
                if(visited[i][j] != 1)
                {
                    loadQueue(mat,i,j);
                    loadDiagonal(mat,visited,i,j);
                }
            }
        }

        return mat;
    }

    private void loadDiagonal(int[][] mat, int[][] visited, int i, int j) {
        if(i >= mat.length || j >= mat[0].length || i < 0 || j < 0)
            return;
        mat[i][j] = priorityQueue.poll();
        visited[i][j] = 1;
        loadDiagonal(mat,visited,i+1,j+1);
    }

    private void loadQueue(int[][] mat, int i, int j) {
        if(i >= mat.length || j >= mat[0].length || i < 0 || j < 0)
            return;
        priorityQueue.add(mat[i][j]);
        loadQueue(mat,i+1,j+1);
    }
}

class Solution {
    public int closedIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && dfs(grid, i, j, m, n)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean dfs(int[][] grid, int a, int b, int m, int n) {
        boolean result = true;
        grid[a][b] = 1;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i < directions.length; i++) {
            int[] direction = directions[i];
            int x = a + direction[0], y = b + direction[1];
            if(x < 0 || y < 0 || x >= m || y >= n) result = false;
            else if(grid[x][y] == 0) {
                if(!dfs(grid, x, y, m, n)) result = false;
            }
        }
        
        return result;
    }
}
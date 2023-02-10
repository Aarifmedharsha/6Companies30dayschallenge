class Solution {
    
    private static final int[][] DIRS = new int[][]{ { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
    public int swimInWater(int[][] grid) {
        PriorityQueue<List<Integer>> q = new PriorityQueue<>((a, b) -> {
            return a.get(2) - b.get(2);
        });
        Set<List<Integer>> visited = new HashSet<>();
        q.add(create(0, 0, grid[0][0]));
        visited.add(create(0, 0, grid[0][0]));
        int max = 0;
        while (!q.isEmpty()) 
        {
            List<Integer> cur = q.poll();
            int i = cur.get(0);
            int j = cur.get(1);
            int elevation = cur.get(2);
            max = Math.max(max, elevation);
            if (i == grid.length - 1 && j == grid[0].length - 1) 
            {
                return max;
            }
            for (int[] dir : DIRS) 
            {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (!valid(grid, ni, nj)) 
                {
                    continue;
                }
                List<Integer> n = create(ni, nj, grid[ni][nj]);
                if (!visited.contains(n)) {
                    q.add(n);
                    visited.add(n);
                }
            }
        }
        return max;
    }
    
    private static List<Integer> create(int i, int j, int elevation) {
        List<Integer> ls = new ArrayList<>();
        ls.add(i);
        ls.add(j);
        ls.add(elevation);
        return ls;
    }
    
    private static boolean valid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
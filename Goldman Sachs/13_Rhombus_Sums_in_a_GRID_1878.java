class Solution {
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> s = new TreeSet<>((x , y) -> y-x);
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                s.add(grid[i][j]);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int length = 1;
                while(true){
                    if(i+2*length >= n || j-length < 0 || j + length >= m)
                        break;
                    boolean possible = true;
                    int sum = grid[i][j] + grid[i+2*length][j];
                    for(int k=1;k<=length;k++){
                        sum += grid[i+k][j-k] + grid[i+k][j+k];
                    }
                    int iNew = i+2*length;
                    int jNew = j;
                    for(int k=1;k<length;k++){
                        sum += grid[iNew-k][jNew-k] + grid[iNew-k][jNew+k];
                    }
                    s.add(sum);
                    length++;
                }
            }
        }
        int ans[] = new int[Math.min(s.size() , 3)];
        int i = 0;
        while(i<ans.length){
            ans[i++] = s.pollFirst();
        }
        return ans;
    }
}

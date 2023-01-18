class Solution {
     public boolean canFinish(int numCourses, int[][] prerequisites) {        
        List<Integer>[] adj = new List[numCourses];
        int[] visited = new int[numCourses];
        int count = 0;
        for (int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] r : prerequisites) {
            adj[r[1]].add(r[0]);
            visited[r[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (visited[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            count++;
            int n=q.poll();
            for (int i:adj[n]){
                if (--visited[i]==0){
                    q.add(i);
                }
            }
        }
        return count == numCourses;
    }
}

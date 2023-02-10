class Solution {
    int count = 0;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int minCount = n-1, res = n-1;
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int[] edge:edges){
            map.putIfAbsent(edge[0],new ArrayList<>());
            map.get(edge[0]).add(new int[]{edge[1],edge[2]});
            map.putIfAbsent(edge[1],new ArrayList<>());
            map.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        for(int i=n-1;i>=0;i--){
            boolean[] visited = new boolean[n];
            bfs(i,map,visited,distanceThreshold);
            if(count < minCount){
                minCount = count;
                res = i;
            }
            count = 0;
        }
        
        return res;
    }
    
    private void bfs(int start,Map<Integer,List<int[]>> map,boolean[] visited,int distanceThreshold){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});
        while(!q.isEmpty()){
            int[] city = q.poll();
            int index = city[0];
            int sum = city[1];
            visited[index] = true;
            List<int[]> list = map.getOrDefault(index,new ArrayList<int[]>());
            for(int[] item:list){
                if(!visited[item[0]] && sum+item[1] <= distanceThreshold){
                    q.add(new int[]{item[0],sum+item[1]});
                    count++;
                }
            }
        }
    }
}
class Pair{
    int node;
    int distance;
    Pair(int node,int distance){
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        int m = roads.length;
        for(int i=0;i<m;i++){
            adj.get(roads[i][0])
            .add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1])
            .add(new Pair(roads[i][0],roads[i][2]));
        }
        
        int[] distance = new int[n];
        int[] ways = new int[n];
        
        Arrays.fill(distance,Integer.MAX_VALUE);
        Arrays.fill(ways,0);
        
        
        ways[0] = 1;
        distance[0] = 0;
        
        int mod = (int)(1e9+7);
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)-> x.distance-y.distance);
        pq.add(new Pair(0,0));
        
        while(!pq.isEmpty()){
            
            Pair pair = pq.poll();
            int node = pair.node;
            int dist = pair.distance;
            
            
            for(Pair it:adj.get(node)){
                int adjNode = it.node;
                int adjDist = it.distance;
                if(adjDist+dist<distance[adjNode]){
                    distance[adjNode] = adjDist+dist;
                    pq.add(new Pair(adjNode,adjDist+dist));
                    ways[adjNode] = ways[node];
                }else if(adjDist+dist==distance[adjNode]){
                    ways[adjNode] = (ways[adjNode]+ ways[node])%mod;
                }
            }
            
        }
        
        return ways[n-1];
        
    }
}

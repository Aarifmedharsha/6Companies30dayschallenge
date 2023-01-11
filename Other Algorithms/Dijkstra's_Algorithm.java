public class Dijkstra's_Algorithm{
    private static final int V=9;
    int mind(int key[],boolean[]visite){
        int min_i=-1;
        int minv=Integer.MAX_VALUE;
        for(int i=0;i<V;i++){
            if(!visite[i]&&key[i]<=minv){
                min_i=i;
                minv=key[i];
            }
        }
        return min_i;
    }
    void print(int key[],int s){
        System.out.println("Edge \tDistance");
        for(int i=0;i<V;i++){
            System.out.println(s+"-->"+i+"\t"+key[i]);
        }
    }
    void dijkstra(int [][]graph,int s){
        boolean visited[] =new boolean[V];
        int key[]=new int[V];
        for(int i=0;i<V;i++){
            key[i]=Integer.MAX_VALUE;
            visited[i]=false;
        }
        key[s]=0;
        for(int j=0;j<V-1;j++){
            int u=mind(key,visited);
            visited[u]=true;
            for(int i=0;i<V;i++){
            if(graph[u][i]!=0&&!visited[i]&&graph[u][i]+key[u]<key[i]&&key[u]!=Integer.MAX_VALUE){
                key[i]=graph[u][i]+key[u];
            }
        }
        }
        print(key,s);
    }
    public static void main(String[] args) {
        int graph[][]
			= new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
							{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
							{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
							{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
							{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
							{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
							{ 0, 0, 0, 0, 0, 2, 0, 1, 6 },
							{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
							{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		djilstra t = new djilstra();
		t.dijkstra(graph, 0);
    }
}

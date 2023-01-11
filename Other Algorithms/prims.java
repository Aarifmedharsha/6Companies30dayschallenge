/* Minimum Spanning Time */
public class prims {
    private static final int V=5;
    int mini(boolean visited[],int key[]){
        int min_i=-1;
        int minv=Integer.MAX_VALUE;
        for(int i=0;i<visited.length;i++){
            if(!visited[i]&&key[i]<minv){
                minv=key[i];
                min_i=i;
            }
        }
        return min_i;
    }
    void printans(int graph[][],int[]parent){
        System.out.println("Edge \tWeight");
        for(int i=1;i<V;i++){
            System.out.println(parent[i]+"-->"+i+"\t"+graph[i][parent[i]]);
        }
    }
    void printMST(int graph[][]){
        int parent[]=new int[V];
        int key[]=new int[V];
        boolean visited[]=new boolean[V];
        
        for(int i=0;i<V;i++){
            key[i]=Integer.MAX_VALUE;
        }
        key[0]=0;
        parent[0]=-1;
        for(int i=0;i<V-1;i++){
            int u=mini(visited,key);
            visited[u]=true;
            for(int j=0;j<V;j++){
                if(graph[u][j]!=0&&!visited[j]&&graph[u][j]<key[j]){
                    key[j]=graph[u][j];
                    parent[j]=u;
                }
            }
        }
        printans(graph,parent);

    }
    public static void main(String[] args) {
        prims t= new prims();
        int graph[] [] =new int[][] { { 0, 2, 0, 6, 0 },
        { 2, 0, 3, 8, 5 },
        { 0, 3, 0, 0, 7 },
        { 6, 8, 0, 0, 9 },
        { 0, 5, 7, 9, 0 } };
        t.printMST(graph);
    }
    
}

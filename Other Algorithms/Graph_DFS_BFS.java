import java.util.*;
class Graph_DFS_BFS{
    private static int V;
    private static LinkedList<Integer> adj[];
    Graph_DFS_BFS(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i] =new LinkedList<>();
        }
    }
    void addEdge(int v,int w){
        adj[v].add(w);
    }
    static void BFS(int s){
        LinkedList<Integer> queue =new LinkedList<>();
        boolean visited [] =new boolean[V];
        visited[s]=true;
        queue.add(s);
        while(queue.size()!=0){
            s=queue.poll();
            System.out.println(s+" ");
            Iterator<Integer> i=adj[s].listIterator();
            while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }
    static void dfsu(int v,boolean visited[]){
        visited[v]=true;
        Iterator<Integer> i=adj[v].listIterator();
        while(i.hasNext()){
            int n=i.next();
            if(!visited[n]){
                dfsu(n, visited);
            }
        }
    }
    static void DFS(int v){
        boolean visited1[] =new boolean[V];
        dfsu(v,visited1);
        System.out.println(Arrays.toString(visited1));
    }
    public static void main(String[] args) {
        Graph_DFS_BFS g =new Graph_DFS_BFS(2);
        g.addEdge(1,0);
        g.addEdge(0, 1);
        BFS(0);
        DFS(0);
    }
}

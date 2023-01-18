class Solution {
    int max=Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<List<Integer>>adj=new ArrayList<>();
        int n =amount.length;
        for(int i =0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i =0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer>path=new ArrayList<>();
        int parent[]=new int [n];
        dfs1(adj,parent,0,-1);
        int bobCopy=bob;
        path.add(bob);
        while(parent[bobCopy]!=-1){
            path.add(parent[bobCopy]);
            bobCopy=parent[bobCopy];
        }
        boolean vis[]=new boolean[n];
        dfs(adj,amount,path,vis,0,0,-1);
        return max;
    }
    int itr=0;
    void dfs(List<List<Integer>>adj,int amt[],List<Integer>path,boolean[] vis,int sum,int i,int parent){
        if(itr<path.size() && path.get(itr)==i){
            sum+=amt[i]/2;
        }
        else if(!vis[i])
            sum+=amt[i];

        if(adj.get(i).size()==1 && adj.get(i).get(0)==parent)
            max=Math.max(max,sum);
        vis[i]=true;
        if(itr++<path.size())
            vis[path.get(itr-1)]=true;
        for(int neigh:adj.get(i)){
            if(parent==neigh)
                continue;
            dfs(adj,amt,path,vis,sum,neigh,i);
        }
        vis[i]=false;
        itr--;
        if(itr<path.size())
            vis[path.get(itr)]=false;
    }
    void dfs1(List<List<Integer>>adj,int par[],int i,int parent){
        par[i]=parent;
        for(int neigh:adj.get(i)){
            if(neigh==parent)
                continue;
            dfs1(adj,par,neigh,i);
        }
    }
}

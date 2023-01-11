class Solution {
    public int dist(int a[],int b[]){
        return (((a[0]-b[0])*(a[0]-b[0]))+((a[1]-b[1])*(a[1]-b[1])));
    }
    public int numberOfBoomerangs(int[][] points) {
        int boom=0;
        if(points.length<=2) return 0;
        Map<Integer,Integer> a=new HashMap<>();
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                int curr=dist(points[i],points[j]);
                if(a.containsKey(curr)){
                    a.put(curr,a.get(curr)+1);
                }
                else{
                    a.put(curr,1);
                }
            }
            for(int k:a.values()) if(k>=2) boom+=k*(k-1);
            a.clear();
        }
        
        return boom;
    }
}

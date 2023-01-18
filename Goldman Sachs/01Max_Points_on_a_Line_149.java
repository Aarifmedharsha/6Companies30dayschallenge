class Solution {
    public int maxPoints(int[][] points) {                  
        int max=1;
        for (int i=0;i<points.length;i++) {
            Map<Double,Integer> map=new HashMap<>();
            for (int j=i+1;j<points.length;j++) {                
                double slope=computeSlope(points[i],points[j]);
                map.put(slope,map.getOrDefault(slope,1)+1);
                max=Math.max(max,map.get(slope));
            }
        }
        return max;
    }
    public double computeSlope(int[] p1, int[] p2) {
        int x1=p1[0],y1=p1[1];
        int x2=p2[0],y2=p2[1];
        if (x1==x2) return Double.MAX_VALUE;
        else if (y1==y2) return 0;
        else return (y2-y1)/(double)(x2-x1);
    }
}

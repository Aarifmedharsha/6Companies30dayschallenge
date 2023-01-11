class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> s=new HashSet();
        s.add(su(p1,p2));
        s.add(su(p1,p3));
        s.add(su(p1,p4));
        s.add(su(p2,p3));
        s.add(su(p2,p4));
        s.add(su(p3,p4));
        return (!s.contains(0)&&s.size()==2);
    }
    public int su(int []a,int b[]){
        return ((a[0]-b[0])*(a[0]-b[0]))+((a[1]-b[1])*(a[1]-b[1]));
    }
}

import java.util.HashSet;
public class Perfect_Rectangle {
    public static boolean isRectangleCover(int rect[][]){
        int x1=Integer.MAX_VALUE;
        int y1=Integer.MAX_VALUE;
        int x2=Integer.MIN_VALUE;
        int y2=Integer.MIN_VALUE;
        int area1=0;
        HashSet<String> s =new HashSet<String>();
        for(int []r:rect){
            x1=Math.min(r[0],x1);
            y1=Math.min(r[1],y1);
            x2=Math.max(r[2],x2);
            y2=Math.max(r[3],y2);
            area1+=(r[2]-r[0])*(r[3]-r[1]);
            String s1=r[0]+" "+r[1];
            String s2=r[0]+" "+r[3];
            String s3=r[2]+" "+r[3];
            String s4=r[2]+" "+r[1];
            if(!s.add(s1)) s.remove(s1);
            if(!s.add(s2)) s.remove(s2);
            if(!s.add(s3)) s.remove(s3);
            if(!s.add(s4)) s.remove(s4);
        }
        if(!s.contains(x1+" "+y1)||!s.contains(x2+" "+y2)||!s.contains(x1+" "+y2)||!s.contains(x2+" "+y1)||s.size()!=4) return false;
        return area1==(x2-x1)*(y2-y1);
    }
    public static void main(String[] args) {
        int rect[][] ={{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println(isRectangleCover(rect));
    }
}

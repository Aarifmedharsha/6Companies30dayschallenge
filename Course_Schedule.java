import java.util.*;
public class Course_Schedule{
    public static boolean canFinish(int numCourses, int[][] prerequisites) {        
        List<Integer>[] adj=new List[numCourses];
        int[] visited=new int[numCourses];
        int count=0;
        for (int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }
        for (int[] r:prerequisites) {
            adj[r[1]].add(r[0]);
            visited[r[0]]++;
        }
        //System.out.println(Arrays.toString(visited));
        Queue<Integer> q=new LinkedList<>();
        for (int i=0;i<numCourses;i++){
            if (visited[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            count++;
            int n=q.poll();
            for (int i:adj[n]){
                if (--visited[i]==0){
                    q.add(i);
                }
            }
        }
        return count==numCourses;
    }
    public static void main(String[] args) {
        int n=2;
        int p[][]={{1,0},{0,1}};
        System.out.println(canFinish(n,p));
    }
}
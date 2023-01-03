import java.util.Scanner;
public class Longest_Happy_Prefix{
    public static String longestPrefix(String s){
        char []arr =s.toCharArray();
        int len=0;
        int i=1;
        int lp[] =new int[arr.length];
        while(i<arr.length){
            if(arr[i]==arr[len]){
                len++;
                lp[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lp[len-1];
                }
                else{
                    lp[i]=0;
                    i++;
                }
            }
        }
        return s.substring(0,lp[lp.length-1]);
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s =sc.nextLine();
        System.out.println(longestPrefix(s));
    }
}

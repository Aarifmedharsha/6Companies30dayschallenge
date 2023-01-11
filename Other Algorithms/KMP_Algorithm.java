/*Pattern Identification in String*/
import java.util.Scanner;
public class KMP_Algorithm{
    static void search(char []str,char pat[]){
        int m=pat.length;
        int n=str.length;
        int lps[]=lps(pat);
        int i=0;
        int j=0;
        while(n-i>=m-j){
            if(str[i]==pat[j]){
                i++;
                j++;
            }
            if(j==m){
                System.out.println("Pattern Found at : "+(i-m));
                j=lps[j-1];
            }
            else if(str[i]!=pat[j]){
                if(j!=0) j=lps[j-1];
                else i++;
            }
        }
    }
    public static int[] lps(char arr[]){
        int lps[]=new int[arr.length];
        int l=0;
        int i=1;
        while(i<arr.length){
            if(arr[i]==arr[l]){
                l++;
                lps[i]=l;
                i++;
            }
            else{
                if(l!=0){
                    l=lps[l-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String q=sc.nextLine();
        String s =sc.nextLine();
        search(q.toCharArray(),s.toCharArray());
    }
}

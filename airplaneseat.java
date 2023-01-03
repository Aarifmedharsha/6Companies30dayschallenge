import java.util.Scanner;   
public class airplaneseat {
    public static float seat(int n){
        if(n==0||n==1) return 1;
        else return 1/2;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(seat(n));
    }
}

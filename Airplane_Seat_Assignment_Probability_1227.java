import java.util.Scanner;   
public class Airplane_Seat_Assignment_Probability_1227{
    public static double nthPersonGetsNthSeat(int n){
        if(n<=1) return 1;
        else return 0.50000;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(nthPersonGetsNthSeat(n));
    }
}

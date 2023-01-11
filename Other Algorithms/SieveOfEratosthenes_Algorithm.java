/* Prime Number in a range efficient*/
import java.util.*;
class SieveOfEratosthenes {
	public static ArrayList<Integer> sieveOfEratosthenes(int n){
        ArrayList<Integer> ans=new ArrayList<>();
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p * p; i <= n; i += p)
					prime[i] = false;
			}
		}
		for (int i = 2; i <= n; i++) {
			if (prime[i] == true)
				ans.add(i);
		}
        return ans;
	}
	public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
        System.out.println(sieveOfEratosthenes(n));
	}
}

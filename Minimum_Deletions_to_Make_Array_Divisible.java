import java.util.Arrays;
public class Minimum_Deletions_to_Make_Array_Divisible {
        public static int gcd(int a,int b){
            if(b==0) return a;
            return gcd(b,a%b);
        }
        public static int gcdofarray(int []arr){
            int temp =arr[0];
            for(int i:arr){
                temp =gcd(i, temp);
            }
            return temp;
        }
    public int minOperations(int[] nums, int[] numsDivide) {
        int count=0;
        int g =gcdofarray(numsDivide);
        Arrays.sort(nums);
            for(int i=0;i<nums.length;i++){
                if(g%nums[i]==0) return count;
                else count++;
            }
            return -1;
    }
        public static void main(String[] args) {
            int arr1[] ={2,2,3,3,4};
            int arr2[] ={9,6,15,18,21,3};
            System.out.println(minOperations(arr1, arr2));
        }
}

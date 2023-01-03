import java.util.Arrays;

public class Shortest_Unsorted_Continuous_Subarray {
    public static int findUnsortedSubarray(int[] nums) {
        int temp [] = nums.clone();
        Arrays.sort(temp);
        int start =0;
        int end=nums.length-1;
        for(int i=start;i<nums.length;i++){
            if(nums[i]==temp[i]) start++;
            else break;
        }
        for(int i=end;i>=0;i--){
            if(nums[i]==temp[i]) end--;
            else break;
        }
        return end-start+1;
    }
    public static void main(String[] args) {
        int nums [] ={2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }
}

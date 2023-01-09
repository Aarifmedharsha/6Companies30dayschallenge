public class Rotate_Function_396 {
    public static int maxRotateFunction(int[] nums) {
        int temp=0;
        int total=0;
        for(int i=0;i<nums.length;i++){
            temp+=i*(nums[i]);
            total+=nums[i];
        }
        int max=temp;
        for(int i=nums.length-1;i>=1;i--){
            temp=temp+total-(nums.length*nums[i]);
            max=Math.max(temp,max);
        }
        return max;
    }
    }
    public static void main(String[] args) {
        int nums[] ={4,3,2,6};
        System.out.println(maxRotateFunction(nums));
    }
}

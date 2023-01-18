class Solution {
    public int trailingZeroes(int n) {
        if(n==0) return 0;
        else {
            int extra=trailingZeroes(n/5);
            return n/5+extra;
        }
    }
}

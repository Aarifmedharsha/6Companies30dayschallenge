class Solution {
    public int maximumGood(int[][] A) {
        int n = A.length, ans = 0;
    for (int num = 1 << n; num < 1 << (n + 1); num++) {
        String permutation = Integer.toBinaryString(num).substring(1);
        if (check(permutation, A, n)) {
            int count = Integer.bitCount(Integer.parseInt(permutation, 2));
            ans = Math.max(ans, count);
        }
    }
    return ans;
    }
    private boolean check(String perm, int[][] A, int n) {
    for (int i = 0; i < n; i++) {
        if (perm.charAt(i) == '0') continue;
        for (int j = 0; j < n; j++) {
            if (A[i][j] == 2) continue;
            if ((A[i][j] == 1 && perm.charAt(j) == '0') || 
                (A[i][j] == 0 && perm.charAt(j) == '1')) 
                return false;
        }
    }
    return true;
}
}

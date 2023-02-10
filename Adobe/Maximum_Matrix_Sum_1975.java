class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long absTotal = 0, negative = 0, mi = Long.MAX_VALUE;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (matrix[r][c] < 0) {
                    ++negative;
                }
                absTotal += Math.abs(matrix[r][c]);
                mi = Math.min(mi, Math.abs(matrix[r][c]));
            }
        } 
        return absTotal - (negative % 2 == 0 ? 0 : 2 * mi);
    }
}
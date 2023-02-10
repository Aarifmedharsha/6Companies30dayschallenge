class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int row=mat.length;
        int col=mat[0].length;
        int[][] matrix=new int[row][col];
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                matrix[i][j]=calc(mat,i,j,K);
            }
        }
        return matrix;
    }
    public int calc(int[][] result, int row, int col, int k) {
        int rowLeft=row-k;
        int rowRight=row+k;
        int colLeft=col-k;
        int colRight=col+k;
        int rowCount=result.length;
        int colCount=result[0].length;
        if(rowLeft<0)
            rowLeft=0;
        if(rowRight>(rowCount-1))
            rowRight=rowCount-1;
        if(colLeft<0)
            colLeft=0;
        if(colRight>(colCount-1))
            colRight=colCount-1;
        int sum=0;
        for(int i=rowLeft;i<=rowRight;i++) {
            for(int j=colLeft;j<=colRight;j++)
                sum+=result[i][j];
        }
        return sum;
        
    }
}
public class questions{

    //Leetcode 74
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length ==0 || matrix[0].length == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        
        int si = 0, ei = (n * m) - 1;
        
        while(si <= ei){
            int mid = (si + ei) >> 1;
            if(matrix[mid/m][mid%m]==target) return true;
            else if(matrix[mid/m][mid%m] < target) si = mid + 1;
            else ei = mid - 1;
        }
        
        return false;
    }
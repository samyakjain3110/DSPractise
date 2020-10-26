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
   // 658
   public List<Integer> findClosestElements(int[] A, int k, int x) {
    List<Integer> arr = new ArrayList<>();
    for(int ele : A) arr.add(ele); 
    
    int n = A.length;
    
    if(x <= A[0]) return arr.subList(0,k);
    else if(x >= A[n-1]) return arr.subList(n - k ,n);
    else{
        int idx  = Collections.binarySearch(arr,x);
        if(idx < 0){
            idx = -idx - 1; 
        }
        
        int si = Math.max(0,idx - k);
        int ei = Math.min(idx + k, n - 1);
        
        while(ei - si > k - 1){
            if((x - A[si])  > (A[ei] - x)) si++;
            else ei--;
        }
        return arr.subList(si,ei+1);
    }   
}


    // https://practice.geeksforgeeks.org/problems/inversion-of-array/0#
    public static int inversionCount_(int[] arr,int[] sortedArray,int si,int ei){
        if(si >= ei) return 0;
        
        int mid = (si + ei) / 2;
        int count = 0;
        
        count += inversionCount_(arr,sortedArray,si,mid);
        count += inversionCount_(arr,sortedArray,mid + 1,ei);

        count += totalInversion(arr,sortedArray,si,mid + 1, ei);
        return count;
    }

    public static int totalInversion(int[] arr,int[] sortedArray,int si,int mid,int ei){
        int count = 0;
        int i = si, j = mid, k = si;
        while(i <= mid - 1 && j <= ei){
            if(arr[i] <= arr[j])
                sortedArray[k++] = arr[i++];
            else{
                sortedArray[k++] = arr[j++];
                count += mid - i;
            }
        }


}
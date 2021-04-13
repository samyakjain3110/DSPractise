import java.util.Scanner ; 

public class Solution{
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in) ;
        int t = scn.nextInt() ;
        for(int i = 0 ;i < t ;i++ )
        {
            int n = scn.nextInt() ;
            int arr[] = new int[n] ;
            int digs[] = new int[n] ;
            int max = 0 ;
            for(int idx = 0 ;idx < n ;idx++ )
            {
                arr[idx] = scn.nextInt() ;
                digs[idx] = digits(arr[idx]) ;
                if(digs[idx] > max)
                    max = digs[idx] ;
            }
            int val = 0 ;
            for(int idx = 0 ;idx < n ;idx++ )
            {
                val += max - digs[idx] ;
                if(idx > 0 && (arr[idx - 1] == arr[idx]) ) 
                    val++ ;
                if(arr[idx] == 100)
                    val++ ;
            }
            System.out.println("Case #" + i + ": " + val ) ;
        }
    }
    public static int digits(int n)
    {
          
    int digit = 0;
    while(n!=0){
      n = n/10;
      digit++;
    }
    return digit ;
    } 

} 
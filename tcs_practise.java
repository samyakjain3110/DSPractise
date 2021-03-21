import java.util.* ;
import java.math.* ;

public class tcs_practise {
    
    public static void main(String args[])
    {

        // show_primes() ;
        check_palindrome(12345) ;
        // Scanner scn = new Scanner(System.in ) ;
        // int n = scn.nextInt() ;

        // int arr[][] = new int[n][n] ;

        // for(int row = 0 ;row < n;row++ )
        // {
        //     for(int col = 0 ; col < n ;col++ )
        //     {
        //         arr[row][col] = scn.nextInt() ;
        //     }
        // }

        // int diag1 = 0 ;
        // int diag2 = 0 ;

        // // find the sum of diagonals
        // for(int row = 0 ; row < n ;row++ )
        // {
        //     for(int col = 0 ; col < n ; col++ )
        //     {
        //         if(row == col)
        //         {
        //             diag1 += arr[row][col] ;
        //         }
        //         else if(row + col == n - 1)
        //         {
        //             diag2 += arr[row][col] ;
        //         }
        //     }
        // }

        // System.out.println(Math.abs(diag1 - diag2)) ;

    }

    // ==============================================================


    public static void show_primes()
    {

    
    int n = 27 ;

    // find all the prime numbers till n
    boolean arr[] = new boolean[n] ;

    // mark all non primes as true
    for(int idx = 4 ; idx < n ;idx += 2 )
    {
        arr[idx] = true ; 
    }

    for(int idx = 3 ; idx < n ; idx += 2)
    {
        if(arr[idx] != true)
        for(int i = idx + idx ; i < n ;i += idx )
        {
            arr[i] = true ;
        }
    }

    for(int idx = 2 ; idx < n ;idx++ )
    {
        if(arr[idx] == false) 
        System.out.println(idx) ;
    }

    }

    public static void check_palindrome(int num)
    {
        int temp = num ;
        int rev = 0 ;

        while(temp > 0)
        {
            rev = (rev * 10) + (temp % 10) ;
            temp /= 10 ;
        }

        System.out.println(rev) ;
        System.out.println(num) ;

    }


}

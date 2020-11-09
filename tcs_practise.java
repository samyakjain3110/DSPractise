import java.util.* ;
import java.math.* ;

public class tcs_practise {
    
    public static void main(String args[])
    {

        Scanner scn = new Scanner(System.in ) ;
        int n = scn.nextInt() ;

        int arr[][] = new int[n][n] ;

        for(int row = 0 ;row < n;row++ )
        {
            for(int col = 0 ; col < n ;col++ )
            {
                arr[row][col] = scn.nextInt() ;
            }
        }

        int diag1 = 0 ;
        int diag2 = 0 ;

        // find the sum of diagonals
        for(int row = 0 ; row < n ;row++ )
        {
            for(int col = 0 ; col < n ; col++ )
            {
                if(row == col)
                {
                    diag1 += arr[row][col] ;
                }
                else if(row + col == n - 1)
                {
                    diag2 += arr[row][col] ;
                }
            }
        }

        System.out.println(Math.abs(diag1 - diag2)) ;

    }

}

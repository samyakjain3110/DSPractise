public class practise{

    public static void main(String args[] )
    {
        solve() ;
    }

    public static void solve()
    {
        // fibonacci_iterative(9) ;
        // fibonacci_recursive(4) ;
        // fibonacci_memoized(4, new int[5]) ;
        // System.out.println(fibonacci_dp(12) ) ;
        System.out.println(fibonacci_opti(12)) ;
    }

    // ==========================================================================================

    // Traversals

    


    // ------------------------------------------------------------------

    // fibonacci

    // 1. iterative 

    public static void fibonacci_iterative(int n )
    {
        int a = 0 ; 
        int b = 1 ;
        int c = 0 ;

        /*
                0 1 0 
                1 0 1
                0 1 1
                1 1 2
        */

        for(int idx = 0 ;idx < n ;idx++ )
        {
            System.out.println(c) ;

            a = b ;
            b = c ;
            c = a + b ;
        }
        
    }


    // 2. recursive

    public static int fibonacci_recursive(int n )
    {
        if(n == 0 || n == 1)
        {
            System.out.println(n) ;
            return n ;
        } 

        int myans = fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2) ;
        System.out.println(myans) ;
        return myans ;
    }

    // 3. memoization

    public static int fibonacci_memoized(int n , int dp[] )
    {
        if(n == 0 || n == 1) 
        {
            System.out.println(n) ;
            return dp[n] = n ;
        }

        if(dp[n] != 0) 
        {
            System.out.println(dp[n]) ;
            return dp[n] ;
        }

        int myans = fibonacci_memoized(n - 1, dp) + fibonacci_memoized(n - 2, dp) ;
        System.out.println(myans) ;

        return dp[n] = myans ;

    }


    // 4. dynamic programming 

    public static int fibonacci_dp(int n)
    {
        if(n <= 1) return n ;

        int dp[] = new int[n + 1] ;

        for(int idx = 0 ;idx <= n ; idx++ )
        {
            if(idx <= 1)
            {
                dp[idx] = idx ;
                continue ;
            } 
    
            dp[idx] = dp[idx - 1] + dp[idx - 2] ;

        }

            return dp[n] ;
    }

    public static int fibonacci_opti(int n)
    {
        if(n <= 1) return n ;

        int a = 0 ; 
        int b = 1 ;
        int c = 1 ;

        int dp[] = new int[n + 1] ;

        for(int idx = 2 ;idx <= n ; idx++ )
        {
            c = a + b ;
            a = b ;
            b = c ;
        }

            return c ;
    }

    // ===========================================================================================


    public static void print(int arr[])
    {
        for(int idx = 0 ; idx < arr.length ;idx++)
        {
            System.out.print(arr[idx] + " ") ;
        }
        System.out.println() ;
    }

    public static void print2D(int arr[][])
    {
        for(int row = 0 ; row < arr.length ;row++ )
        {
            for(int col = 0 ; col < arr[0].length ;col++ )
            {
                System.out.print(arr[row][col] + " ") ;
            }
            System.out.println() ;
        }
    }




}
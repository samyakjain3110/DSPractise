public class practise {
    
    public static void main(String args[])
    {
        solve() ;
    }

    public static void solve ()
    {
        int ans = count(0,0,3) ;
        System.out.println(ans) ;
        int dp1[][] = new int[3][3] ;
        int ans2 = memo_count(0,0,3,dp1) ;
        System.out.println(ans2) ;
        int dp2[][] = new int[3][3] ;
        int ans3 = tabu_count(0,0,3,dp2) ;
        System.out.println(ans3) ;
        int ans4 = dice_count(1,4) ;
        System.out.println(ans4) ;
    } 

  // q1 - hv ==========================================================
   
    // recursive code
    public static int count(int c , int r , int n )
    {
        if( c >= n || r >= n ) return 0 ;
        else if( c == n - 1 && r == n - 1) return 1  ;
        
        int hcount = count(c + 1,r , n) ;
        int vcount = count(c , r + 1 , n) ;

        return hcount + vcount ;
    }

    // memoization
    public static int memo_count(int c , int r, int n ,int[][] dp)
    {
        if( c >= n || r >= n ) return 0 ;
        else if( c == n - 1 && r == n - 1) return dp[r][c] = 1 ;
        
        if(dp[r][c] != 0) return dp[r][c] ;

        int hcount = memo_count(c + 1,r , n,dp) ;
        int vcount = memo_count(c , r + 1 , n, dp) ;

        return dp[r][c] = hcount + vcount ;

    }

    // tabulation
    public static int tabu_count(int col , int row, int n ,int[][] dp)
    {
        if( col >= n || row >= n ) return 0 ;

        for(int r = n - 1; r>= row; r--)
        {
            for(int c = n - 1 ; c>= col; c--)
            {
                if(c == n - 1 && r == n - 1){
                    dp[r][c] = 1 ;
                    continue ;
                } 
                else{

                    int count = 0 ;
                    if(c+ 1< n ) count +=  dp[r][c + 1] ;
                    if(r + 1 < n) count +=  dp[r + 1][c] ;

                    dp[r][c] = count ;
                }
            }
        }
        return dp[row][col] ;
    }

    // q2 - hvd ======================================================================

        // recursive code
        public static int count2(int c , int r , int n )
        {
            if( c >= n || r >= n ) return 0 ;
            else if( c == n - 1 && r == n - 1) return 1  ;
            
            int hcount = count(c + 1,r , n) ;
            int vcount = count(c , r + 1 , n) ;
            int dcount = count(c + 1, r + 1, n) ;
    
            return hcount + vcount + dcount;
        }
    
        // memoization
        public static int memo_count2(int c , int r, int n ,int[][] dp)
        {
            if( c >= n || r >= n ) return 0 ;
            else if( c == n - 1 && r == n - 1) return dp[r][c] = 1 ;
            
            if(dp[r][c] != 0) return dp[r][c] ;
    
            int hcount = memo_count(c + 1,r , n,dp) ;
            int vcount = memo_count(c , r + 1 , n, dp) ;
            int dcount = memo_count(c+ 1, r+ 1,n ,dp) ;

            return dp[r][c] = hcount + vcount ;
    
        }
    
        // tabulation
        public static int tabu_count2(int col , int row, int n ,int[][] dp)
        {
            if( col >= n || row >= n ) return 0 ;
    
            for(int r = n - 1; r>= row; r--)
            {
                for(int c = n - 1 ; c>= col; c--)
                {
                    if(c == n - 1 && r == n - 1){
                        dp[r][c] = 1 ;
                        continue ;
                    } 
                    else{
    
                        int count = 0 ;
                        if(c+ 1< n ) count +=  dp[r][c + 1] ;
                        if(r + 1 < n) count +=  dp[r + 1][c] ;
                        if(r + 1 < n && c + 1< n) count+= dp[r + 1][c + 1] ;
    
                        dp[r][c] = count ;
                    }
                }
            }
            return dp[row][col] ;
        }
    
 // q3 hvd infinite jumps ================================================================

     // recursive code
    //  public static int count(int c , int r , int n )
    //  {
    //      if( c >= n || r >= n ) return 0 ;
    //      else if( c == n - 1 && r == n - 1) return 1  ;
         
    //      int hcount = count(c + 1,r , n) ;
    //      int vcount = count(c , r + 1 , n) ;
 
    //      return hcount + vcount ;
    //  }
 
    //  // memoization
    //  public static int memo_count(int c , int r, int n ,int[][] dp)
    //  {
    //      if( c >= n || r >= n ) return 0 ;
    //      else if( c == n - 1 && r == n - 1) return dp[r][c] = 1 ;
         
    //      if(dp[r][c] != 0) return dp[r][c] ;
 
    //      int hcount = memo_count(c + 1,r , n,dp) ;
    //      int vcount = memo_count(c , r + 1 , n, dp) ;
 
    //      return dp[r][c] = hcount + vcount ;
 
    //  }
 
    //  // tabulation
    //  public static int tabu_count(int col , int row, int n ,int[][] dp)
    //  {
    //      if( col >= n || row >= n ) return 0 ;
 
    //      for(int r = n - 1; r>= row; r--)
    //      {
    //          for(int c = n - 1 ; c>= col; c--)
    //          {
    //              if(c == n - 1 && r == n - 1){
    //                  dp[r][c] = 1 ;
    //                  continue ;
    //              } 
    //              else{
 
    //                  int count = 0 ;
    //                  if(c+ 1< n ) count +=  dp[r][c + 1] ;
    //                  if(r + 1 < n) count +=  dp[r + 1][c] ;
 
    //                  dp[r][c] = count ;
    //              }
    //          }
    //      }
    //      return dp[row][col] ;
    //  }
 



    // q4 dice result ==================================================================================

        // recursive code

        public static int dice_count(int si , int ei)
        {
            if(si == ei ) return 1 ;

            int count = 0 ;
            for(int idx = si; idx <= si + 6; idx++ )
            {
                count += dice_count(idx + 1,ei) ;
            }
            return count ;
        }


        public static int dice_count2(int si , int ei, int[] dp)
        {
            if(si == ei) return 0 ;

            for(si = ei; si>= 0 ; si--)
            {
                if(si == ei)
                {
                    dp[si] = 1 ;
                    continue ;
                }

                int count = 0 ; 
                for(int dice = 1 ; dice <= 6 && si + dice <= ei; dice++)
                {
                    count += dp[si + dice] ;
                }

                dp[si] = count ;
            }
            return dp[0] ;
        }

        public static int dice_arr_given(int arr[])
        {

        }

}

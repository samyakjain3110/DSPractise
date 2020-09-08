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

        // public static int dice_arr_given(int arr[])
        // {

        // }













public static int minCostPath(int grid[][],int sr,int sc , int[][] dp)
{
    for(sr = grid.length - 1; sr >= 0; sr-- )
    {
        for(sc = grid[0].length - 1; sc >= 0; sc--)
        {
            if(sc == grid.length - 1&& sc == grid[0].length - 1 )
            {
                dp[sr][sc] = grid[sr][sc] ;
                continue ;
            }
            int minCost = (int) 1e8 ;
            if(sr + 1 < grid.length) minCost = Math.min(minCost,dp[sr+1][sc]) ;
            if(sc + 1 < grid[0].length) minCost = Math.min(minCost,dp[sr][sc]) ;

            dp[sr][sc] = minCost + grid[sr][sc] ;
        }
    }
    return dp[0][0] ;
}

public static int goldmine(int arr[][] , int dp[][])
{
      for (int j = arr[0].length - 1; j >= 0; j--) {
         for (int i = arr.length - 1; i >= 0; i--) {
            if (j == arr[0].length - 1) 
            {
               dp[i][j] = arr[i][j];
            } 
            else if (i == arr.length - 1) 
            {
               dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
            }
             else if (i == 0) 
            {
               dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
            } 
            else 
            {
               dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]));
            }
         }
      }
}

public static int gold(int[][] grid,int sr,int sc,int[][] dp,int[][] dir)
{
    for(sc = grid[0].length -1 ; sc >= 0; sc--)
    {
        for(sr = grid.length -1 ; sr >= 0;sr--)
        {
            if(sc == grid[0].length - 1)
            {
                dp[sr][sc] = grid[sr][sc] ;
                continue ;
            }
        }
        for(int d = 0 ; d < 3 ; d++)
        {
            int r = sr + dir[d][0] ;
            int c = sc + dir[d][1] ;

            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length)
            {
                dp[sr][sc] = Math.max(dp[sr][sc], dp[r][c] + grid[sr][sc]) ;
            }
        }
    }
}

 public static int getgold(int arr[][])
 {
    int dp[][] = new int[arr.length][arr[0].length] ;
    goldmine(arr,dp) ;
    int max = dp[0][0];
    for (int i = 1; i < dp.length; i++) {
       max = Math.max(max, dp[i][0]);
    }

 }     


 public static int friends_pairing(int n)
 {
     int a = 1 ;
     int b = 1 ;
     for(int i = 2 ; i < n ; i++)
     {
         int sum = a * (i - 1) + b ;
         a = b ;
          b = sum ;
     }
     return b ;
 }

}

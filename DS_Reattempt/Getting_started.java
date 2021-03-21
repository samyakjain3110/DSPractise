import java.util.* ;

public class Getting_started {
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in) ;
        //int n = scn.nextInt() ;
        // printz(n) ; // O(n)  [O(n)[3k]] -> [k] O(n2) 
        //grading_system(n) ;

        // int t = scn.nextInt() ; 
        // for(int i = 0; i < t ; i++)  // O(t) [O(rootn)]
        // {
        //     int n = scn.nextInt() ;
        //     if(check_prime(n)) 
        //         System.out.println("prime") ;
        //     else
        //         System.out.println("not prime") ;
        // }

        // int low = scn.nextInt() ;
        // int high = scn.nextInt() ;
        // print_all_primes(low, high) ;

        int n = scn.nextInt() ;
        print_fibonacci(n) ;
        
    }

    public static void printz(int n)
    {
        for(int row = 1 ; row <= n ;row++) // O(n)  [O(n)[3k]]
        {
            for(int col = 1; col <= n ;col++) // O(n)[3k]
            {
                if(row == 1 || row == n)
                {
                    System.out.print("*") ; // O(1) -> k
                }
                else
                {
                    if( col == n - row + 1)
                    {
                        System.out.print("*"); // O(1) -> k
                    }
                    else 
                    {
                        System.out.print(" ") ; // O(1) -> k
                    }
                }
            }
            System.out.println() ;
        }
    }

    public static void grading_system(int n)
    {
        if(n > 90)
        {
            System.out.println("excellent") ;
        }
        else if( n > 80)
        {
            System.out.println("good") ;
        }
        else if(n > 70)
        {
            System.out.println("fair") ;
        }
        else if(n > 60)
            System.out.println("meets expectations") ;
        else
            System.out.println("below par");
    }

    public static boolean check_prime(int n) 
    {
        for(int i = 2 ;i * i <= n ;i++) // O (rootn)
        {
            if( n % i == 0)
            {
                return false ;
            }
        }
        return true ;
    }

    public static void print_all_primes(int low, int high)
    {
        for(int val = low ; val <= high ; val++)
        {
            if(check_prime(val))
            {
                System.out.println(val) ;
            }
        }
    }

    public static void print_fibonacci(int n )
    {
        int first = 0 ;
        int second = 0 ; 
        int third = 1 ;

        // 001
        // 011
        // 112
        // 123


        for(int i = 0 ; i < n ;i++ )
        {

            first = second ;
            second = third ;
            third = first + second ;

            System.out.println(first) ;

        }
    }

}

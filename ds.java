import java.util.* ;

public class ds {

    public static void main(String args[])
    {
        int num = 111001 ;
        int base = 2 ;
        // System.out.println(decimaltoanybase(num,base)) ; 

        // System.out.println(anybasetodecimal(num,base)) ;

        // System.out.println(anybaseaddition(111 , 11, 2)) ;
        // System.out.println(anybasesubtraction(10 , 1000 , 2)) ;
        // System.out.println(anybasemultiplication(21, 200 , 10)) ;

        // int arr[] = {1,2,3,4,5} ;
        // int span = spanofarray(arr) ;
        // System.out.println(span) ;
    
        // int arr[] = {1, 3, 4, 5 ,6 , 7 } ;
        // int d = 8 ;
        // System.out.println(findeleinarr(arr, d)) ;

        // int arr[] = {3,1,0,7,5} ;
        // int n = 5 ;
        // barchart(arr, n) ;

        
    }

    public static void barchart(int arr[], int n)
    {
        int max = arr[0] ;
        for(int idx = 0 ; idx < n ; idx++)
        {
            if(arr[idx] > max )
                max = arr[idx] ;
        }

        for(int row = max ; row > 0 ;row--)
        {
            for(int col = 0 ;col < n ;col++ )
            {
                if(row <= arr[col])
                    System.out.print("*\t") ;
                else 
                    System.out.print("\t") ;
            }
            System.out.println() ;
        }
    }

    public static int findeleinarr(int arr[], int d)
    {
        int index = -1 ;
        for(int idx = 0 ;idx < arr.length ;idx++ )
        {
            if(arr[idx] == d)
            {
                index = idx ;
            }
        }

        return index ;
    }

    public static int spanofarray(int arr[])
    {
        int max = Integer.MIN_VALUE ;
        int min = Integer.MAX_VALUE ;
        int n = arr.length ;
        for(int idx = 0 ;idx < n ;idx++ )
        {   
            if(arr[idx] > max) 
                max = arr[idx] ;
            if(arr[idx] < min)
                min = arr[idx] ;

        }
        return max - min ;
    }

    public static int singledigitmultiplication(int dig, int num , int base)
    {
        int ans = 0 ;
        int power = 1 ;
        int carry = 0 ;

        while(num > 0 || carry > 0)
        {
            int numdig = num % 10 ;
            int ansdig = (numdig * dig) + carry ;
            carry = ansdig / base ;
            numdig = numdig % base ;
            ans = ans + (ansdig * power) ; 

            power *= 10 ;
            num /= 10 ;
        }
        return ans ;
    }

    public static int anybasemultiplication(int n1, int n2 , int base)
    {
        int power = 1 ;
        int ans = 0 ;
        while( n2 > 0)
        {
            int dig = n2 % 10 ;
            int value = singledigitmultiplication(dig, n1 , base) ;
            ans = ans + (value*power) ;

            power *= 10 ;
            n2 /= 10 ;
        }
        return ans ;
    }

    public static int anybasesubtraction(int n1, int n2 , int base)
    {
        int borrow = 0 ;
        int power = 1 ;
        int ans = 0 ;

        while(n2 > 0 || n1 > 0)
        {
            int dig2 = n2 % 10 ;
            int dig1 = n1 % 10 ;
            int dig3 = dig2 - dig1 - borrow ;
            if(dig3 < 0)
            {
                borrow = 1 ;
                dig3 = dig3 + base ;
            }
            else
            {
                borrow = 0 ;
            }
            ans = ans + (dig3*power) ;

            power *= 10 ;
            n1 /= 10 ;
            n2 /= 10 ;

        }

        return ans ;
    }

    public static int anybaseaddition(int n1 , int n2 , int base)
    {
        int carry = 0 ;
        int ans = 0 ;
        int power = 1 ;
        while(n1 > 0 )
        {
            int dig1 = n1 % 10 ;
            int dig2 = n2 % 10 ;
            int dig3 = dig1 + dig2 + carry ;
            carry = dig3 / base ;
            dig3 = dig3 % base ;
            ans = ans + (dig3 * power) ;
            // System.out.println(dig1 + " " + dig2 + " " + dig3 + " " + carry + " " + ans) ;
            n1 /= 10 ;
            n2 /= 10 ;
            power *= 10 ;
        }
        if(carry > 0)
        {
            ans = ans + carry * power ;
        }
        return ans ;
    }

    public static int decimaltoanybase(int num, int base)
    {
        int ans = 0 ;
        int power = 1 ;
        while(num >= 1)
        {
            int remainder = num % base ;
            ans +=  (remainder*power) ;
            num /= base ;
            power *= 10 ;
        }
        return ans ;
    }

    public static int anybasetodecimal(int num,int base)
    {
        int ans = 0 ;
        int power = 1 ;
        while(num > 0)
        {
            int dig = num % 10 ;
            ans = ans + (dig*power) ;
            power = power * base ;
            num = num / 10 ;
        }

        return ans ;
    }
    
}

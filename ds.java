import java.util.Scanner ;
import java.io.BufferedReader ;
import java.io.InputStreamReader ;
import java.lang.Exception ;
import java.lang.Math ;

public class ds {

    public static void main(String... args) throws Exception
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

        // int arr1[] = {3 , 1, 0 , 7 , 5} ;
        // int arr2[] = {1 ,1 ,1 ,1 ,1 ,1} ;
        // sumoftwoarrays(arr1 , arr2 ) ;

        int arr1[] = {1, 2, 3 , 4, 5} ;
        // int arr2[] = {1, 0, 0, 0} ;
        // diffoftwoarrays(arr1,arr2) ;

        // reverseArr(arr1 , 2) ;
        // displayArr(arr1) ;

        // printsubarrays(arr1) ;
        // printsubsets(arr1) ;

        // int ele = 9 ;
        // int index = binarysearch(arr1, ele) ;
        // if(index == -1)
        //     System.out.println("element not found") ;
        // else
        //     System.out.println(index) ;

        // int arr[] = {1, 3, 5, 7, 9 , 13, 18, 25, 29 , 105} ;
        // int ele = 18 ;
        // printceilfloor(arr , ele) ;

        // int arr[] = {0 ,1, 2, 3 , 12, 12, 12,15 } ;
        // int ele = 12 ;
        // firstidxlastidx(arr, ele) ;

        int matrix1[][] = {{1,2}, {1,2} , {1,2}} ;
        int matrix2[][] = {{1,1,1} ,{1,1,1}} ;
        matrixMultiplication(matrix1, matrix2) ;
    }

    // ****************************************************************************
    // matrix

    public static void matrixMultiplication(int matrix1[][] , int matrix2[][])
    {
        int n1 = matrix1.length ;
        int m1 = matrix1[0].length ;
        int n2 = matrix2.length ;
        int m2 = matrix2[0].length ;

        if(m1 != n2)
        {
            System.out.println("Invalid Input") ;
            return ;
        }

        int ans[][] = new int[n1][m2] ;

        for(int row = 0 ;row < n1 ;row++ )
        {
            for(int col = 0;col < m2 ; col++)
            {
                for(int idx = 0 ;idx < n2; idx++ )
                {
                    ans[row][col] += matrix1[row][idx] * matrix2[idx][col] ;
                }
            }
        }

        displayMatrix(ans) ;
    }

    public static void displayMatrix(int matrix[][])
    {
        int n = matrix.length ;
        int m = matrix[0].length ;

        for(int row = 0 ;row < n ;row++ )
        {
            for(int col = 0 ;col < m ; col++ )
            {
                System.out.print(matrix[row][col] + " ") ;
            }
            System.out.println() ;
        }
    }

    // ****************************************************************************
    // functions and arrays

    public static void firstidxlastidx(int arr[] , int ele)
    {
        int n = arr.length ;
        int l = 0; 
        int h = n - 1; 
        int li = -1 ;
        int fi = -1 ;

        while(l <= h)
        {
            int mid = (l + h) / 2 ;

            if(arr[mid] < ele)
            {
                l = mid + 1 ;
            }
            else if(arr[mid] > ele)
            {
                h = mid - 1 ;
            }
            else
            {
                fi = mid ;
                h = mid - 1 ;
            }
        }

        l = 0 ;
        h = n - 1 ;
        
        while(l <= h)
        {
            int mid = (l + h) / 2 ;

            if(arr[mid] < ele)
            {
                l = mid + 1 ;
            }
            else if(arr[mid] > ele)
            {
                h = mid - 1 ;
            }
            else
            {
                li = mid ;
                l = mid + 1 ;
            }
        }

        System.out.println(fi + "\t" + li) ;
    }

    public static void printceilfloor(int arr[] , int ele)
    {
        int ceil = Integer.MIN_VALUE ;
        int floor = Integer.MAX_VALUE ;

        int l = 0  ;
        int h = arr.length - 1 ;

        while(l <= h)
        {
            int mid = (l + h) / 2 ;
            if(arr[mid] < ele)
            {
                l = mid + 1 ;
                floor = arr[mid] ;
            }
            else if(arr[mid] > ele)
            {
                h = mid - 1 ;
                ceil = arr[mid] ;
            }
            else
            {
                ceil = floor = arr[mid] ;
                break ;
            }
        }

        System.out.println(ceil + "\n" + floor) ;
    }

    public static int binarysearch(int arr[] , int ele)
    {
        int l = 0 ;
        int h = arr.length -  1 ;

        while( l <= h)
        {
            int mid = (l + h) / 2 ;
            if(arr[mid] == ele)
                return mid ;
            else if(arr[mid] < ele)
                l = mid + 1 ;
            else
                h = mid - 1 ;
        }

        return -1 ;
    }

    public static void printsubsets(int arr[])
    {
        int n = arr.length ; 
        int noofsubsets = (int)Math.pow(2, n) ;

        for(int subset = 0 ;subset < noofsubsets ; subset++ )
        {
            int temp = subset ; 
            String str = "" ;
            for(int idx = n - 1 ;idx >= 0 ; idx--)
            {
                if(temp % 2 == 0)
                {
                    str = "-\t" + str ;
                }
                else
                {
                    str = arr[idx] + "\t" + str ;
                }
                temp /= 2 ;
            }
            System.out.println(str )  ;
        }

    }

    public static void printsubarrays(int arr[])
    {
        int n = arr.length ;

        for(int start = 0 ;start < n ;start++)
        {
            for(int end = start ;end < n ;end++ )
            {
                for(int ele = start ;ele <= end ;ele++ )
                {
                    System.out.print(arr[ele] + " ") ;
                }
                System.out.println() ;
            }
        }
    }

    public static void reverseArr(int arr[] , int k)
    {
        int n = arr.length ;
        k = k % n ;
        if( k < 0)
            k = k + n ;

        // reverse right half 
            reverse(n - k , n - 1, arr) ;

        // reverse left half
            reverse(0, n - k - 1 ,arr ) ;

        // reverse whole array
            reverse(0 , n - 1 , arr) ;
    }

    public static void reverse (int i, int j , int arr[])
    {
        while(i < j)
        {
            int temp = arr[i] ;
            arr[i] = arr[j] ;
            arr[j] = temp ;

            i++ ;
            j-- ;
        }
    }
    public static void displayArr(int arr[])
    {
        StringBuilder  sb = new StringBuilder() ;
        for(int val : arr)
        {
            sb.append(val + " ") ;
        }
        System.out.println(sb) ;
    }
   

    // public static void reverseArr(int arr[])
    // {
    //     int n = arr.length - 1 ;

    //     int idx = 0 ;
    //     while(2 * idx < n )
    //     {
    //         int temp = arr[idx] ;
    //         arr[idx] = arr[n - idx] ;
    //         arr[n - idx] = temp ;

    //         idx++ ;
    //     }
    // }

    public static void diffoftwoarrays(int arr1[], int arr2[])
    {
        int n1 = arr1.length ;
        int n2 = arr2.length ;
        int sub[] = new int[n2] ;

        int i = n1 - 1 ;
        int j = n2 - 1 ;
        int k = j ;
        int borrow = 0 ;
        while( k >= 0)
        {
            int dig = arr2[j] - borrow ;

            if( i >= 0)
                dig = dig - arr1[i] ;

            if(dig < 0)
            {
                borrow = 1 ;
                dig = dig + 10 ;
            }
            else
                borrow = 0 ;
            
            sub[k] = dig ; 

            k-- ;
            i-- ;
            j-- ;
        }


        while(sub[++k] == 0) ;

        while(k < n2)
        {
            System.out.println(sub[k++]) ;
        }
    }

    public static void sumoftwoarrays(int arr1[] , int arr2[])
    {
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = i > j ? i : j ;

        int ans[] = new int[k + 1] ;

        int carry = 0 ;
        while(k >= 0)
        {
            int digit = carry ;

            if( i >= 0)
            {
                digit += arr1[i--] ;
            }
            if( j >= 0)
            {
                digit += arr2[j--] ;
            }
            
            carry = digit / 10 ;
            digit = digit % 10 ;

            ans[k--] = digit ;
        }

        if(carry > 0)
            System.out.println(carry) ;
            
            for(int values : ans)
            {
                System.out.println(values) ;
            }

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
        int max = arr[0] ;
        int min = arr[0] ;
        int n = arr.length ;
        for(int idx = 1 ;idx < n ;idx++ )
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

// *****************************************************************


public static int[] takeinput() throws Exception
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
    String line ;
    while( (line = br.readLine() ) != null)
    {
        System.out.println( line ) ;
    }
    int arr[] = new int[5] ;
    return arr ;
}

} // end of class
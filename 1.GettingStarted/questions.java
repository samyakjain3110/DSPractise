import java.lang.Math;
import java.util.Scanner;

public class questions {

    public static boolean is_prime(int n)
    {
        for (int i = 2; i * 2 <= n;i++)
        {
            if (n%i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void print_all_primes(int n)
    {
        int numbers[] = new int[n+1];
        for (int idx = 0; idx <= n ;idx++)
        {
            numbers[idx] = 1;
        }
        for(int current_idx=2; current_idx<=n;current_idx++)
        {
            if (numbers[current_idx] == 1)
            System.out.println(current_idx);
            for(int idx = 2; ;idx++)
            {
                if (current_idx*idx > n)
                break;
                numbers[current_idx*idx] = 0;
            }
        }

    }

    public static void reverse_of_a_number(int n)
    {
        int val = n;
        while (val > 0)
        {
            int divisor = val%10;
            val = val/10;
            System.out.println(divisor);
        }
    }

    public static void digits_of_a_number(int n)
    {
        int len = 0;
        int val = n;
        while(val >0)
        {
            len++;
            val = val /10;
        }
        int remainder = n;
        int divisor = (int) Math.pow(10,len - 1);
        while(len > 0)
        {
            System.out.println(remainder/divisor);
            remainder = remainder % divisor;
            len--;
            divisor = divisor/10;
        }
    }

    public static int inverse_of_a_number(int n)
    {
        int number = n;
        int multiplier = 10;
        int inverted_number = 0;
        int idx = 1;

        while(number > 0)
        {
            // traverse number from end i.e index 1
            // multiplier = power(10,1 - 1)
            // inverted_number = inverted_number + (digit*multiplier)
            // number = number / 10
            int digit = number % 10;
            multiplier = (int) Math.pow(10,digit - 1);
            inverted_number = inverted_number + (idx*multiplier);
            number = number / 10;
            idx++;

        }

        return inverted_number;
    }
    
    public static int get_num_length(int num)
    {
        int number = num;
        int len = 0;
        while(number>0)
        {
            len++;
            number = number/10;
        }
        return len;
    }

    public static int rotate_a_number(int num,int k)
    {   
        int number = num;
        int number_len = get_num_length(number);
        if(k<0)
        {
            k = number_len + k;
        }
        int multiplier = (int) Math.pow(10,number_len - k);
        int divider = (int) Math.pow(10,k);
        // 12345 -> 2 -> 45123
        // 12345 -> -2 -> 34512
        // 1. get multiplier and divider
        // 2. get right_digits*multiplier + left_digits/divider 
        int left_dig = number/divider;
        int right_dig = (number % divider)*multiplier;
        int rotated_num = right_dig + left_dig;
        return rotated_num;
    }

    public static int greatestCommonDiviser(int n1,int n2)
    {
        int gcd = 1;

        // 14 , 32, 34,42
        int divident = n1 ;
        int divisor = n2;
        int remainder = divident % divisor;
        while(remainder>0)
        {
            divident = divisor;
            divisor = remainder;
            remainder = divident % divisor;
        }
        gcd = divisor;
        return gcd;
    }


    public static void temp(int n)
    {
        n = n + 1;
    }


    public static void main(String args[])
    {
        // int n = 11;
        // System.out.println(is_prime(n));

        // print_all_primes(30);

        // digits_of_a_number(123456);
        // reverse_of_a_number(123456);
        // System.out.println(inverse_of_a_number(34152));
        // int n = 5;
        // temp(n);
        // Scanner scn = new Scanner(System.in);
        // int k = scn.nextInt();
        // System.out.println(rotate_a_number(12345,-2));
        // System.out.println(greatestCommonDiviser(14,37));
        // primeFactorization(14);
        
    }
}


// 7. Is a Prime Number
// 8. Print All Primes till Number

// 9. Digits of a Number
// 10. Reverse of a Number
// 11. Inverse a Number
// 12. Rotate a Number

// 13. GCD and LCM 
// 14. Prime Factorization of a Number

// 15. Pythagorean Factorization of a Number
// 16. The Curious Case of Benjamin Bulbs
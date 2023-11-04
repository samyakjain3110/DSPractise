


def is_prime(num):
    i = 2
    while(i*i < num):
        i += 1
        if (num % i == 0):
            print("false")
            return
    print("true")

def print_all_primes_till_number(num):
    # get a list of all 1s
    # traverse the list from 2
    # if list[idx] is 1 print and mark its multiples as 0 in list
    list1 = [1]*(num + 1)
    list1[0] = list1[1] = 0
    for idx in range(2,num + 1):
        idx2 = idx
        if (list1[idx] == 1):
            print(idx)
            while (idx2 <= num):
                list1[idx2] = 0
                idx2 += idx
            
def get_num_len(number):
    len = 0
    while(number > 0):
        len += 1
        number = number//10
    return len


def digits_of_number(number):
    num_length = get_num_len(number)
    divisor = pow(10,num_length - 1)
    while(divisor > 0):
        digit = number//divisor
        number = number - (digit*divisor)
        print(digit)
        divisor = divisor//10

def reverse_of_number(number):
    while(number > 0):
        digit = number % 10
        print(digit)
        number //= 10

def inverse_of_number(number):
    inversed_number = 0
    idx = 1
    while(number > 0):
        digit = number % 10
        multiplier = pow(10,digit - 1)
        inversed_number = inversed_number + (idx*multiplier)
        number //= 10
        idx += 1
    print(inversed_number)


def rotate_number(number,k):
    number_length = get_num_len(number)
    k = (number_length + k)  % number_length
    # 5 -2  = 3 % 5 = 3
    # 5 + 2 = 7 % 5 = 2
    #  split number -> left + (right*multiplier)
    divisor = pow(10,k)
    multiplier = pow(10,number_length - k)
    right = number % divisor
    left = number // divisor
    rotated_number = left + (right*multiplier)
    print(rotated_number)

def gcd(number1,number2):
    divisor = number1
    divident = number2
    remainder = divisor
    while (remainder > 0):
        divisor = remainder
        remainder = divident % divisor
        divident = divisor
        print(divident , "/" , divisor , "=" , remainder)
    return divisor

def lcm(num1,num2):
    num_gcd = gcd(num1,num2)
    print(num1*num2/num_gcd)

def printj():
    j = 2
    interval = 2
    for j in range(1,15,2):
        print("idx : " ,j)

num = 72
# is_prime(num)
# print_all_primes_till_number(num)
# printj()
# digits_of_number(2345)
# reverse_of_number(2356)
# inverse_of_number(15243)
# rotate_number(12345,2)
# print(gcd(12,17))
# lcm(12,24)



# 7. Is a Prime Number
# 8. Print All Primes till Number
# 9. Digits of a Number
# 10. Reverse of a Number
# 11. Inverse a Number
# 12. Rotate a Number
# 13. GCD and LCM 
# 14. Prime Factorization of a Number
# 15. Pythagorean Factorization of a Number
# 16. The Curious Case of Benjamin Bulbs
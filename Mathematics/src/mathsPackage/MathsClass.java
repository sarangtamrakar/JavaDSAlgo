package mathsPackage;

import static mathsPackage.NumberOfDigitsInNumber.*;
//import static sun.security.util.Debug.args;

public class MathsClass {
    public static void main(String[] args) {

        // NumberOfDigitsInNumber
//        System.out.println(NumberOfDigitsInNumber.fun1(123));
//        fun2(123);
//        System.out.println(fun3(123));


//        // PalindromeNumber
//        System.out.println(PalindromeNumber.fun2(8668));
//        int digits = 121;
//        int rev = PalindromeNumber.fun1(digits,0);
//        if (rev == digits){
//           System.out.println(true);
//        } else{
//            System.out.println(false);
//        }


//        FactorialOfNumber
//        // recursive
//        System.out.println(FactorialOfNumber.fun1(15l));
////        // loop
//        System.out.println(FactorialOfNumber.fun2(20l));



        // Trailing Zeroes
        // Basic Method
//        System.out.println(TrailingZeroesInFactorial.fun1(10));
//        System.out.println(TrailingZeroesInFactorial.fun2(20));
//        // prime factor method
//        System.out.println(TrailingZeroesInFactorial.TrailingZeroes5(10,5,0)); // recursive method
//        System.out.println(TrailingZeroesInFactorial.TrailingZeroes(10)); // loop method


//        // HCF Of Two Number
//        System.out.println(HCFOfTwoNumber.fun1(100,200)); // loop
//        System.out.println(HCFOfTwoNumber.hcf(100,200)); // recursive

//        // LCM of two number
//        System.out.println(LCMOfTwoNumbers.lcm(10,14));

        // check for prime Number;
//        System.out.println(checkPrimeNumber.fun3(25));


//        PrintAllDivisors.fun1(12);
//        PrintAllDivisors.fun2(12);
//        PrintAllPrimeNumbersLessThanN.fun3(10);
        System.out.println(PowOfXToN.fun3(3,-2));
    }
}



class NumberOfDigitsInNumber{

    // for loop solution
    static int fun1(int digit){
        int res = 0;

        for (int i= 0 ; digit>0 ; i++){
            System.out.println(digit);
            digit = digit / 10;
            res++;
        }
        return  res;
    }

    // while loop solution
    static void fun2(int digit){
        int sum = 0;
        while (digit>0){
            digit = digit/10;
            sum++;
        }
        System.out.println(sum);

    }

    // recursive solution
    static int fun3(int digit){
        if (digit == 0){
            return 0;
        }
        return 1+fun3(digit/10);
    }
}

class PalindromeNumber{

    // recursive solution
    static int fun1(int digits,int Temprev){
        if (digits == 0){
            return Temprev;
        }
        Temprev = (digits%10) + (Temprev * 10);
        return fun1(digits/10,Temprev);
    }


    // loop solution
    static boolean fun2(int digits){
        int initialDigit = digits;
        int rev = 0;
        while (digits>0){
            rev = (digits %10) + (rev*10);
            digits = digits/10;
        }
        if (initialDigit == rev){
            return true;
        } else {
            return false;
        }
    }
}

class FactorialOfNumber{

    // by recursion
    static long fun1(long n){
        if (n == 0){
            return 1;
        }
        return n * fun1(n-1);
    }

    // by loop
    static long fun2(long n){
        long mul = 1;
        while (n > 0){
            mul = mul * n;
            n = n-1;
        }
        return mul;
    }
}


class TrailingZeroesInFactorial {
    static int fun1(int n) {
        if (n == 0) {
            return 0;
        }
        long factorial = 1;
        while (n > 0) {
            factorial = factorial * n;
            n--;
        }
        int NumberZeroes = 0;
        while ((factorial % 10) == 0) {
            NumberZeroes++;
            factorial = factorial / 10;
        }
        return NumberZeroes;
    }

    // recursive solution
    static long fun2(long n) {
        if (n == 0) {
            return 0;
        }
        long factorial = 1;
        while (n > 0) {
            factorial = factorial * n;
            n--;
        }
        return fun3(factorial);
    }
    static long fun3(long factorial) {
        if ((factorial % 10) !=0){
            return 0;
        }
        return 1+ fun3(factorial/10);
    }


    // prime factor method
    // Best Solution

    static int TrailingZeroes(int n){
        if (n<5){
            return 0;
        }
        int NumZeroes = 0;

        for (int i=5;i<=n;i=i*5){
            NumZeroes = NumZeroes + n/i;
        }
        return NumZeroes;
    }

    static int TrailingZeroes5(int n,int power , int NumZeroes){
        if (n < 5){
            return 0;
        }
        if (n < power){
            return NumZeroes;
        }
        return TrailingZeroes5(n,power*5,NumZeroes+n/power);
    }
}


class HCFOfTwoNumber{
    static int fun1(int num1,int num2){
        if (num1>num2){
            int remainder = num1 % num2;
            if (remainder != 0){
                num1 = remainder;
            } else{
                return num2;
            }
        } else{
            int remainder = num2 % num1;
            if (remainder != 0){
                num2 = remainder;
            } else{
                return num1;
            }
        }
        return fun1(num1,num2);

    }

    // recursive solution
    static int hcf(int num1, int num2){
        if (num2 ==0){
            return num1;
        }
        return hcf(num2,num1%num2);
    }
}


class LCMOfTwoNumbers{
    static int hcf(int num1,int num2){
        if (num2==0){
            return num1;
        }
        return hcf(num2,num1%num2);
    }
    static int lcm(int num1,int num2){
        // a*b = hcf(a,b) * lcm(ab)
        return (num1*num2)/hcf(num1,num2);
    }
}

class checkPrimeNumber{

    static boolean fun1(int n){
        if (n ==1){
            return false;
        }
        for(int i =2;i<n;i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
    static boolean fun2(int n){
        // if n = [(a*b) or (b*a)] ,,,  min(a,b) ==>a
        // so a**2<=n
        if (n==1){
            return false;
        }
        for (int i = 2;i*i<n;i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }



    static boolean fun3(int n){
        if (n==1){
            return false;
        }
        if (n==2 || n ==3){
            return true;
        }
        if ((n%2 ==0)|| (n%3 ==0)){
            return false;
        }
        for (int i = 5 ; i*i<=n ; i=i+6){
            if ((n%i==0) || (n%(i+2)==0)){
                return false;
            }
        }
        return true;
    }
}


class PrintPrimeFactors{
    static boolean fun1(int n){
        if (n==1){
            return false;
        }
        if(n==2 || n==3){
            return true;
        }
        if (n%2==0 || n%3==0){
            return false;
        }

        for (int i=5;i*i<n;i=i+6){
            if (n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }

    static void fun2(int n){
        if (n==2 || n==3){
            System.out.println(n);
        }
        while(n%2==0){
            System.out.println(2);
            n = n/2;
        }
        while(n%3==0){
            System.out.println(3);
            n = n/3;
        }
        for(int i =5;i*i<=n;i=i+6){
            if (fun1(i)){
                while (n % i == 0){
                    System.out.println(i);
                    n = n / i;
                }
                while(n%(i+2)==0){
                    System.out.println(i+2);
                    n = n/(i+2);
                }
            }
        }
        if(n>1){
            System.out.println(n);
        }

    }
}


class PrintAllDivisors{
    static void fun1(int n){
        for (int i =1;i<=n;i++){
            if (n%i==0){
                System.out.println(i);
            }
        }
    }



    static void fun2(int n){
        int i;
        for (i =1;i*i<=n;i++){
            if(n%i ==0){
                System.out.println(i);
            }
        }
        i = i-1;
        for (;i>=1;i--){
            if (n%i==0){
                System.out.println(n/i);
            }
        }

    }
}


class PrintAllPrimeNumbersLessThanN{
    static void fun1(int n){
        for(int i =2;i<=n;i++){
            if (fun2(i)){
                System.out.println(i);
            }
        }
    }
    static boolean fun2(int n){
        if (n==1){
            return false;
        }
        if (n==2 || n==3){
            return true;
        }
        if (n%2==0 || n%3==0){
            return false;
        }
        for (int i=5;i*i<=n;i=i+6){
            if (n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }
    static void fun3(int n){
        if (n>=2){
            System.out.println(2);
        }
        if (n>=3){
            System.out.println(3);
        }

        for (int i = 5 ; i<=n;i=i+6){
            if(fun2(i)){
                System.out.println(i);
            }
            if (fun2(i+2)){
                System.out.println(i+2);
            }
        }
    }
}


class computePowerOfX{
    static int fun1(int n,int x){
        if (x==0){
            return 1;
        }
        int mul = n;
        for(int i=1;i<x;i++){
            mul = mul*n;
        }
        return mul;
    }
}

class PowOfXToN{

    // recursive solution
    static int fun1(int x,int n){
        if (n==0) {
            return 1;
        }
        if (n==1){
            return x;
        }
        if (n%2==0){
            return fun1(x,n/2)*fun1(x,n/2);
        }else{
            return fun1(x,n-1)*x;
        }
    }

    // iterative solution
    static long fun3(long x,long n){
        long res = 1;
        while (n>0){
             if (n%2!=0){
                res = res*x;
            }
            x = x*x;
             n = n/2;
        }
        return res;
    }
}
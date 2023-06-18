package recursionPackage;


public class basicOfRecursion {
    public static void main(String[] args){
//        printing2.fun2(3);
//        System.out.println(FactorialByTailMethod.fun1(1,1));
//        decimalToBinary.fun1(19);
//        System.out.print(SumOfNnaturalNumbers.fun1(5));
//        System.out.println(PalindromCheckUsingRecursion.fun1(121));
//        System.out.println(SumOfDigitsByRecursion.fun1(10));

//        System.out.println(NthFabonacciNumber.fun1(6));
//        System.out.println(largerCutOnRope.fun1(7,3,5,5,0));
//        System.out.println(minimumCutOnRope.fun2(7,3,5,5));


        TowerOfHanoi.fun1(3,"A","B","C");
    }
}

class printing{
    static void fun1(int n){
        if (n==0){
            return;
        }
//        System.out.println(n);
        fun1(n-1);
        System.out.println(n);
    }
}

class printing2{
    static void fun2(int n){
        if (n==0){
            return;
        }
        fun2(n-1);
        System.out.println(n);
        fun2(n-1);
    }
}

class FactorialByTailMethod{
    static int fun1(int n,int k){
        if (n==0 || n==1){
            return k;
        }
        return fun1(n-1,k*(n-1));
    }
}

class decimalToBinary{
    static void fun1(int n){
        if (n==0){
            return;
        }
        fun1(n/2);
        System.out.println(n%2);

    }
}

class SumOfNnaturalNumbers{
    static int fun1(int n){
        if (n==0){
            return 0;
        }
        return n + fun1(n-1);
    }
}

class PalindromCheckUsingRecursion{
    static boolean fun1(int digits){
        int revDigits = getReversedDigits(digits,0); // put temp = 0 initially
        if (digits == revDigits){
            return true;
        } else {
            return false;
        }


    }

    static int getReversedDigits(int digits,int temp){
        if (digits==0){
            return temp;
        }
        temp = (digits%10) + (temp*10);
        return getReversedDigits(digits/10,temp);

    }
}

class SumOfDigitsByRecursion{
    static int fun1(int n){
        if (n==0){
            return 0;
        }

        return (n%10) + fun1(n/10);
    }
}

class NthFabonacciNumber{
    static int fun1(int n){
        if (n==1){
            return 0;
        } else if (n==2){
            return 1;
        }

        return fun1(n-1)+fun1(n-2);
    }
}

class largerCutOnRope{
    static int fun1(int n,int a, int b, int c,int count){

        // further optimization
        if (a ==0 || b==0 || c==0){
            return n;
        }

        // base case
        if (n<0){
            return -1;
        } else if (n==0){
            return count;
        }

        int A = fun1(n-a,a,b,c,count+1);
        int B =fun1(n-b,a,b,c,count+1);
        int C = fun1(n-c,a,b,c,count+1);

        if (A==-1 && B==-1 && C==-1){
            return -1;
        } else if(A>B && A>C){
            return A;
        } else if(B>A && B>C){
            return B;
        } else{
            return C;
        }

    }
}


class minimumCutOnRope{

    static int fun2(int n,int a,int b, int c){
        int minCount = fun1(n,a,b,c,0,n+1);
        if (minCount == n+1){
            return -1;
        } else{
            return minCount;
        }
    }

    static int fun1(int n, int a, int b, int c, int count , int k){

        if (n<0){
            return k;
        } else if(n==0){
            return count;
        }
        int A = fun1(n-a,a,b,c,count+1,k);
        int B = fun1(n-b,a,b,c,count+1,k);
        int C = fun1(n-c,a,b,c,count+1,k);

        if(A==k && B==k && c==k){
            return k;
        } else if(A<B && A<C){
            return A;
        } else if(B<A && B<C){
            return B;
        } else{
            return C;
        }
    }
}

class TowerOfHanoi {
    static void fun1(int n, String A, String B, String C) {
        if (n == 0) {
            return;
        }

        fun1(n - 1, A, C, B);
        System.out.println("Move Disc " + String.valueOf(n) + " from tower " + A + " to " + C);
        fun1(n-1,B,A,C);
    }
}





















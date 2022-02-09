package mathsPackage;

import java.util.ArrayList;

public class rough{
    public static void main(String[] args){
//        printPrimeFactors(19);
        Solution s1 = new Solution();
        System.out.println(s1.quadraticRoots(1,2,3));
    }

    static void printPrimeFactors(int n){
        for(int i =2;i<=n;i++){
            if (isPrimeFactor(i)){
                while(n%i==0){
                    System.out.println(i);
                    n = n/i;
                }
            }
        }
    }

    static boolean isPrimeFactor(int n){
        if (n==1){
            return false;
        }
        if (n==2 || n==3){
            return true;
        }
        if (n%2==0 || n%3==0){
            return false;
        }

        for(int i=5;i*i<=n;i=i+6){
            if (n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }
}



class Solution {
    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        // code here
        double D = Math.pow(b,2)-(4*a*c);
        int r1 = (int)(-b+Math.sqrt(D))/2*a;
        int r2 = (int)(-b-Math.sqrt(D))/2*a;
        ArrayList arr = new ArrayList();
        if(r1>r2){
            arr.set(0, r1);
            arr.set(1, r2);
        }else{
            arr.set(0, r2);
            arr.set(1, r1);
        }
        return arr;
    }
}
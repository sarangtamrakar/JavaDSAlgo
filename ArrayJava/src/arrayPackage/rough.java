package arrayPackage;

import java.util.Arrays;

public class rough {
    static public void main(String[] args) {
        int[] arr = {-2,2,4};

        boolean res = FindEquilibriumPoint1.fun1(arr);
        System.out.println(res);
    }
}




class FindEquilibriumPoint1{
    static boolean fun1(int[] arr){
        // find total sum
        int tsum = 0;
        for(int e:arr){
            tsum += e;
        }

        int curr = 0;
        for(int i = 0 ; i<arr.length;i++){
            curr+=arr[i];
            int lsum = curr -arr[i];
            int rsum = tsum - curr;
            if(lsum==rsum){
                return true;
            }
        }
        return false;
    }
}




class PrintNbonacciNumber{
    static void fun1(int n , int m){
        // creatin blank arr
        int[] arr = new int[m];
        // n-1 index always 1;
        arr[n-1] = 1;

        for(int i=n;i<m;i++){
            int cursum = 0;
            for(int j = i-n;j<i;j++){
                cursum+=arr[j];
            }
            arr[i] = cursum;
        }

        for(int e : arr){
            System.out.print(e);
            System.out.print(" ");
        }
    }


    static void OptimisedSolution(int n, int m){
        int[] arr = new int[m];
        arr[n-1] = 1;
        int curr = 1;

        for(int i = n; i<m;i++){
            arr[i] = curr;
            curr = curr +arr[i] - arr[i-n];
        }

        for(int e : arr) {
            System.out.println(e);
        }
    }
}
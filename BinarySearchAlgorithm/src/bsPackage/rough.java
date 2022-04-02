package bsPackage;


import java.util.Arrays;

public class rough {
    public static void main(String[] args) {
        // find the square root
        int[] arr1 = {1,3,5,6,7,8,9};
        boolean res = ProblemClass.find4sumOptimised(arr1,34);
        System.out.println(res);
    }


}



class ProblemClass{
    static boolean fun3(int[] arr, int givenSum){

        // find pair with given sum
        for(int i = 0; i<arr.length;i++){
            for(int j = i+1; j<arr.length;j++){
                if(arr[i]+arr[j]==givenSum){
                    return true;
                }
            }
        }
        return false;
    }


    static boolean findPairOptimised(int[] arr, int givenSum,int l,int h){
        int n = arr.length;
        while(l<h){
            int mid = (l+h)/2;
            if(arr[l]+arr[h]==givenSum){
                return true;
            }else if(arr[l]+arr[h]>givenSum){
                h--;
            }else{
                l++;
            }
        }
        return false;
    }


    static boolean findTripletOptimised(int[] arr, int givenSum,int l,int h){
        // O(N^2) solution
        int n = arr.length;
        for(int i =0 ; i<arr.length;i++){
            if(findPairOptimised(arr,givenSum-arr[i],i+1,n-1)){
                return true;
            }
        }
        return false;
    }

    static boolean find4sumOptimised(int[] arr, int givenSum){
        int l = 0; int h = arr.length-1;

        for(int i = 0 ; i<arr.length; i++){
            if(findTripletOptimised(arr,givenSum-arr[i],i+1,h)){
                return true;
            }
        }
        return false;
    }

}







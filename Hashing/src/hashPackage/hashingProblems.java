package hashPackage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;




class CountDistinctElements{

    static int NaiveMethod(int[] arr){
        Arrays.sort(arr);

        int count = 1;
        for(int i = 1; i<arr.length;i++){
            if(arr[i-1]!=arr[i]){
                count++;
            }
        }
        return count;
    }

    static int OptimisedMethod(int[] arr){
        HashSet<Integer> hset  = new HashSet<Integer>();
        for(int i = 0; i<arr.length;i++){
            boolean ret = hset.add(arr[i]);
            System.out.println(ret);
        }
        return hset.size();
    }
}



class FrequencyOfArrayElements{

    static void NaiveMethod(int[] arr){

        for(int i = 0; i<arr.length;i++){

            boolean isPresent = false;

            for(int j=0;j<i;j++){
                if(arr[i]==arr[j]){
                    isPresent = true;
                    break;
                }
            }

            if(isPresent){
                continue;
            }


            int count = 0;
            for(int k = i;k<arr.length;k++){
                if(arr[i]==arr[k]){
                    count++;
                }
            }
            System.out.println(arr[i] +" "+count);

        }

    }



    static void OptimisedMethod(int[] arr){
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();

        for(int i = 0; i<arr.length;i++){
            if(hmap.containsKey(arr[i])){
                hmap.put(arr[i],hmap.get(arr[i])+1);
            }else{
                hmap.put(arr[i],1);
            }
        }

        for(Integer key:hmap.keySet()){
            System.out.println(key+" "+hmap.get(key));
        }
    }
}




class IntersectionOfTwoUnsortedArrays{
    static int NaiveMethod(int[] arr1, int[] arr2){
        int res = 0;

        for(int i = 0; i<arr1.length; i++){
            // check before already present or not
            boolean isPresent = false;
            for(int j = 0; j<i;j++){
                if(arr1[i]==arr1[j]){
                    isPresent = true;
                    break;
                }
            }
            // if present so ignore ith index element
            if(isPresent){
                continue;
            }

            // otherwise search in arr2
            for(int k = 0;k<arr2.length;k++){
                if(arr2[k]==arr1[i]){
                    res++;
                    break;          // breaking imp to avoid repeating element
                }
            }
        }
        return res;
    }


    static int optimisedMethod1(int[] arr1, int[] arr2){
        // insert all the arr1 & arr2 in two different hset
        HashSet<Integer> hset1 = new HashSet<Integer>();
        HashSet<Integer> hset2 = new HashSet<Integer>();

        for(int e1:arr1){
            hset1.add(e1);
        }

        for(int e2:arr2){
            hset2.add(e2);
        }

        int res = 0;
        for(int e3:hset1){
            if(hset2.contains(e3)){
                res++;
            }
        }
        return res;
    }

    static int OptimisedMethod2(int[] arr1, int[] arr2){
        // move arr1 element into the hset1 & iterate arr2 & find element in hset1 do res++ & remove that match element from hset1
        HashSet<Integer> h1 = new HashSet<Integer>();
        for(int e:arr1){
            h1.add(e);
        }

        // now iterate through the arr2 & find a match in h1;
        int res = 0;
        for(int i =0 ; i<arr2.length;i++){
            if(h1.contains(arr2[i])){
                res++;
                h1.remove(arr2[i]);
            }
        }
        return res;
    }
}



class UnionOfTwoUnsortedArrays{
    static void fun1(int[] arr1, int[] arr2){
        ArrayList<Integer> temparr = new ArrayList<Integer>();

        // Iterate through the arr1 & check whether this element present in temparr or not , if not present , add that element
        for(int e1 : arr1){
            boolean isPresent = false;
            for(Integer e2:temparr){
                if(e1==e2){
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent){
                temparr.add(e1);
            }
        }


        // now iterate the arr2 , & check whether this element present in the temparr or not , if not present so , add it
        for(int e3:arr2){
            boolean present = false;
            for(Integer e4: temparr){
                if(e3==e4){
                    present = true;
                    break;
                }
            }

            if(!present){
                temparr.add(e3);
            }
        }

        for(Integer e5 :temparr){
            System.out.println(e5);
        }
    }


    static void optimisedMethod(int[] arr1, int[] arr2){
        HashSet<Integer> hset = new HashSet<Integer>();

        for(int i = 0;i<arr1.length;i++){
            hset.add(arr1[i]);
        }

        for(int j = 0; j <arr2.length;j++){
            hset.add(arr2[j]);
        }

        for(Integer e1: hset){
            System.out.println(e1);
        }
    }
}



class FindSubArrayWithSumzero{
    static boolean NaiveMethod(int[] arr){

        for(int i = 0; i<arr.length;i++){
            int curr = 0;
            for(int j = i; j<arr.length;j++){
                curr+=arr[j];
                if(curr==0){
                    return true;
                }
            }
        }
        return false;
    }


    static boolean Optimised(int[] arr){
        HashSet<Integer> hset = new HashSet<Integer>();
        int curr = 0;
        for(int e: arr){
            curr+=e;

            // *************edge cases
            if(curr==0){
                return true;
            }

            if(hset.contains((curr))){
                return true;
            }else{
                hset.add(curr);
            }
        }
        return false;
    }
}


class FindSubArrayWithGivenSum{
    static int optimised(int[] arr, int givensum){
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        int curr = 0;

        for(int i = 0 ; i<arr.length;i++){
            curr+= arr[i];

            // ***************edge case
            if(curr == givensum){
                return i+1;
            }

            if(hmap.containsKey(curr-givensum)){
                return i -hmap.get(curr-givensum);
            }
            else{
                hmap.put(curr,i);
            }
        }
        return 0;
    }
}


class LongestSubarrayWithGivenSum{
    static int NaiveMethod(int[] arr,int givenSum){
        int res = Integer.MIN_VALUE;

        for(int i = 0 ;i<arr.length;i++){
            int curr = 0;
            for(int j = i;j<arr.length;j++){
                curr+=arr[j];
                if(curr==givenSum){
                    int diff = j-i+1;
                    res = Math.max(res,diff);
                }
            }
        }
        return res;
    }

    static int OptimisedMethod(int[] arr, int givenSum){

        int res = 0;
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();

        int prefixSum = 0;
        for(int i = 0 ; i<arr.length;i++){
            prefixSum+=arr[i];


            //******* This Line very IMP
            if(prefixSum==givenSum){
                res = i+1;
            }

            if(!hmap.containsKey(prefixSum)) {  // this is very imp condition to don't put same key again with different value...
                hmap.put(prefixSum, i);
            }

            if(hmap.containsKey(prefixSum-givenSum)){
                int value = i-hmap.get(prefixSum-givenSum);
                res = Math.max(res,value);
            }
        }
        return res;
    }
}


class LongestSubarrayWithEqualNumbersOfZeroesOnes{
    static int NaiveMethod(int[] arr){

        int res = 0;
        for(int i = 0 ; i<arr.length;i++){
            int oneCounter = 0;
            int ZeroCounter = 0;
            for(int j = i; j<arr.length;j++){
                if(arr[j]==1) oneCounter++;
                else ZeroCounter++;

                if(oneCounter==ZeroCounter){
                    res = Math.max(res,j-i+1);
                }
            }
        }
        return res;
    }


    // Optimised
    static int OptimisedSolution(int[] arr){
        // first convert all 0 into the -1
        for(int i = 0; i<arr.length;i++){
            if(arr[i]==0){
                arr[i] = -1;
            }
        }

        // then find longest sub arr with 0 sum....
        // wherever the number of zeroes == number of ones   will become sum as 0
        return LongestSubarrayWithGivenSum.OptimisedMethod(arr,0);
    }
}



class LongestSpanInTwoBinaryArrayWithSameSum{
    // here both array having same size
    static int NaiveMethod(int[] arr1, int[] arr2){
        int n = arr1.length;
        int res = 0;
        for(int i = 0; i<n;i++){
            int curr1 = 0;
            int curr2 = 0;
            for(int j = i;j<n;j++){
                curr1+=arr1[j];
                curr2+=arr2[j];
                // if both sum equal
                if(curr1==curr2){
                    res = Math.max(res,j-i+1);
                }
            }
        }
        return res;
    }
}


class LongestConsequetivesSubsequence{

    static int NaiveMethod(int[] arr){
        // first we will sort the arr
        Arrays.sort(arr);

        // then we will iterate through the arr & maintaining variable count that next element is 1+ curr or not.
        int res = 1;
        int count = 1;
        for(int i = 0; i<arr.length-1;i++){
            if(arr[i+1]==arr[i]+1){
                count++;
                res = Math.max(res,count);
            }else{
                count = 1;
            }
        }
        return res;
    }

    static int OptmisedSolution(int[] arr){
        int n = arr.length;
        int res = 1;

        // copy the elements in the hashset
        HashSet<Integer> hset = new HashSet<Integer>();
        for(int e:arr){
            hset.add(e);
        }

        // now iterate through hset
        for(int e : hset){
            //
            boolean isPresent = hset.contains(e-1);

            // if not present then only process
            if(!isPresent){
                int count = 1;
                int element = e+1;
                for(int i = 0;i<hset.size();i++){
                    boolean ret = hset.contains(element);
                    if(ret){
                        count++;
                        element++;
                    }else{
                        res = Math.max(res,count);
                        break;
                    }
                }
            }
        }
        return res;
    }
}



class CountDistinctElementsInKSizeWindow{
    static int NaiveMethod(int[] arr ,int k){
        // Iterate through the each window & pass these elements into the hset & update the size of hset into res...
        // O[(N-K)*k]  time complexity  && O(N) space complexity

        int n = arr.length;
        int res = 0;

        for(int i = 0; i<n-(k-1);i++){

            HashSet<Integer> hset = new HashSet<Integer>();

            for(int j = i;j<i+k;j++){
                hset.add(arr[j]);
            }
            res = Math.max(res,hset.size());
        }
        return res;
    }

    static void OptimisedMethod(int[] arr, int k){
        // O(N) solution  && o(K) space 


        int res = 0;
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();

        for(int i = 0 ; i<k;i++){
            if(hmap.containsKey(arr[i])){
                hmap.put(arr[i],hmap.get(arr[i])+1);
            }else{
                hmap.put(arr[i],1);
            }
        }

        System.out.println(hmap.size());

        for(int j = k; j<arr.length;j++){
            if(hmap.containsKey(arr[j])){
                hmap.put(arr[j],hmap.get(arr[j])+1);
            }else{
                hmap.put(arr[j],1);
            }

            if(hmap.containsKey(arr[j-k])) {
                hmap.put(arr[j - k], hmap.get(arr[j - k])-1);

                if(hmap.get(arr[j-k])==0){
                    hmap.remove(arr[j-k]);
                }
            }
            System.out.println(hmap.size());
        }
    }

}



public class hashingProblems{
    public static void main(String[] args){
//        int[] arr1 = {10,20,10,10,30,40};
        int[] arr2 = {1,0,1,0,0,0};
        System.out.println(LongestSubarrayWithEqualNumbersOfZeroesOnes.OptimisedSolution(arr2));
//        System.out.println(res);

    }
}





















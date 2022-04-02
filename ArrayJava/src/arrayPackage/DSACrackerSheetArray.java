package arrayPackage;


import java.util.ArrayList;
import java.util.Arrays;

// 1. Reverse the array
class ReverseArray{
    static int[] fun1(int[] arr){
        int i = 0;int j = arr.length - 1;
        while(i<j){
            int val1 = arr[i];
            int val2 = arr[j];
            arr[i] = val2;
            arr[j] = val1;
            i++;
            j--;
        }
        return arr;
    }
}



// 2. Find min & max element in array
class MaxMinElementsInArray{
    // ********* naive approach *******
    // o(N2) solution

    static int findMin(int[] arr){
        for(int i = 0 ; i<arr.length;i++){
            boolean isLow = true;
            for(int j = 0;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    isLow = false;
                }
            }
            if(isLow){
                System.out.println(arr[i]);
                return arr[i];
            }
        }
        return -1;
    }


    static int findMax(int[] arr){
        for(int i = 0;i<arr.length;i++){
            boolean isBiggest = true;
            for(int j =0;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    isBiggest = false;
                    break;
                }
            }
            if(isBiggest){
                System.out.println(arr[i]);
                return arr[i];
            }
        }
        return -1;
    }


    // optimised approach.....
    // o(N) solution
    static int[] fun3(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for(int i = 1;i<arr.length;i++){
            int val = arr[i];
            max = Math.max(max,val);
            min = Math.min(min,val);
        }
        int[] res = {min,max};
        return res;
    }

}


// 3. Find Kth largest element
class FindKthLargestElement{

    // *******NlogN solution******
    static int NaiveApproach(int[] arr , int k){
        // first sort the array & return n-k th index
        int n = arr.length;
        Arrays.sort(arr);
        return arr[n-k];
    }

}


// 4. sort the array having 0,1,2 only without using any sorting function
class SortTheArrayHavingOnly012{

    // ***** O(N) solution 2 traversal *****
    static int[] fun1(int[] nums){
        int n = nums.length;
        int i = 0;int j = 0;

        // traversal for 0
        for(j=0;j<n;j++){
            if(nums[j]==0){
                int val1 = nums[i];
                nums[i] = 0;
                nums[j] = val1;
                i++;
            }
        }

        // Traversal for 1
        for(j = 0;j<n;j++){
            if(nums[j]==1){
                int val2 = nums[i];
                nums[i] = 1;
                nums[j] = val2;
                i++;
            }
        }
        return nums;
    }

    // O(N) solution only 1 traversal required
    // dutch partitioning problem

    static void fun2(int[] nums){
        int zeroes = 0; int ones = 0; int twos = nums.length-1;

        while(ones<=twos){
            if(nums[ones]==0){
                int val1 = nums[ones];
                int val2 = nums[zeroes];
                nums[ones] = val2;
                nums[zeroes] = val1;
                ones++;
                zeroes++;
            }else if(nums[ones]==1){
                ones++;
            }else{
                int val3 = nums[ones];
                int val4 = nums[twos];
                nums[twos] = val3;
                nums[ones] = val4;
                twos--;
            }
        }
    }
}



// 5. MoveNegativesToOneSide
class MoveNegativesToOneSide{
    //******* Move all negative numbers to beginning and positive to end with constant extra space****
    static void fun1(int[] nums){
        int i = 0;
        for(int j = 0; j<nums.length;j++){
            if(nums[j]<0){
                int val1 = nums[i];
                int val2 = nums[j];
                nums[i] = val2;
                nums[j] = val1;
                i++;
            }
        }
    }
}


// 6.
// *********** Find The Union of two unsorted array *******
class FindTheUnionOfTwoUnsortedArray{

    // https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/

    // for unsorted

    // 1. Naive approach
    // copy elements of arr1 into aux array & then traverse through the element of arr2 & check
    // whether this element present in arr1 or not if present not copy to in aux but if not present then copy to
    // aux array

    // 2. Sort the both arrays & then apply merge function of merge sort, there will be three case
    //  a. a1[i] == a2[j]  {copy only a1[i] i++, j++}
    //  b.  a1[i] < a2[j]  {copy a1[i] i++}
    //  c. a1[i] > a2[j]  {copy a[j] j++}


    // 3. using  HashSet

    // 4. using HashMap


    static int[] forUnsortedArays(int[] arr1, int[] arr2){
        // using sorting here.....
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // then merge
        int i = 0; int j = 0;
        int[] res = new int[arr1.length+arr2.length];
        int idx = 0;

        while(i<arr1.length && j< arr2.length){
            if(arr1[i]==arr2[j]){
                res[idx] = arr1[i];
                i++;
                j++;
                idx++;
            }else if(arr1[i]<arr2[j]){
                res[idx] = arr1[i];
                i++;
                idx++;
            }else{
                res[idx] = arr2[j];
                j++;
                idx++;
            }
        }

        while(i<arr1.length){
            res[idx] = arr1[i];
            idx++;
            i++;
        }

        while(j<arr2.length){
            res[idx] = arr2[idx];
            idx++;
            j++;
        }
        return res;
    }
}


// 7. find the intersection of two arrays
class intersectionOfTwoUnsortedArrays{

    // (M+N)Log(M+N) solution
    static void fun1(int[] arr1 , int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0 ; int j = 0; int idx = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(i<arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                res.add(arr1[i]);
                i++;
                j++;
            }else if(arr1[i]<arr2[j]){
                i++;
            }else{
                j++;
            }
        }

        System.out.println(res);
    }
}


// 8.
class LeftRotateArray{
    static void fun1(int[] arr1,int k){
        reverse(arr1,0,k-1);
        reverse(arr1,k,arr1.length-1);
        reverse(arr1,0,arr1.length-1);
        System.out.println(Arrays.toString(arr1));
    }

    static void reverse(int[] arr,int l , int r){
        int i = l;
        int j = r;
        while(i<j){
            int val1 = arr[i];
            int val2 = arr[j];
            arr[i]  = val2;
            arr[j] = val1;
            i++;
            j--;
        }
    }
}



// 9. Kadane's algorithm
class MaximumSumOfSubarray{

    // 1. Naive approach
    static int fun1(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length;i++){
            int curr = 0;
            for(int j = i;j<arr.length;j++){
                curr += arr[j];
                max = Math.max(curr,max);
            }
        }
        return max;
    }

    // 2. Optimised approach
    static int fun2(int[] arr){

        int max = Integer.MIN_VALUE;
        int currSum = arr[0];
        for(int i = 1;i<arr.length;i++){
            int val = currSum + arr[i];
            currSum = Math.max(val,arr[i]);
            max = Math.max(max,currSum);
        }
        return max;
    }
}



// 10
class MaximumLengthOfEvenOddSubArr{

    // naive approach O(N2) solution
    static int fun1(int[] arr){
        int maxCount = 1;
        for(int i = 0; i<arr.length-1;i++){
            int count = 1;
            for(int j=i;j<arr.length-1;j++){
                if((arr[j]%2==0  && arr[j+1]%2!=0)  || (arr[j]%2!=0 && arr[j+1]%2==0)){
                    count++;
                    maxCount = Math.max(maxCount,count);
                }else{
                    break;
                }
            }
        }
        return maxCount;
    }
}


// 11.
// Maximum sum of Circular subarr sum
class MaxCircularSubArSum{
    // Naive approach
    static int fun1(int[] arr){
        int n = arr.length;
        int max = 0;
        for(int i = 0;i<n;i++){
            int curr = 0;
            for(int j = i;j<i+n;j++){
                int idx = j%n;
                curr = curr + arr[idx];
                max = Math.max(max,curr);
            }
        }
        return max;
    }


    // optimised approach
    // 1. find max sum of normal subarr
    // 2. find the min sum & Total sum of normal sub arr
    // 3. max of circular sum = Math.max((Total - minSum),minSum)  / if all elements are negative to handle this condition
    // 4. ans = Math.max(step 1,step 3)
    static int fun2(int[] arr){
        // step 1:- find max of normal subarr
        int ans1 = MaximumSumOfSubarray.fun2(arr);
        System.out.println(ans1);
        // step 2:- find min sum & total sum
        int[] res = MinimumSumOfSubarray(arr);
        int TotalSum = res[0]; int minSum = res[1];
        // step 3: find circular sum
        int circularSum = TotalSum-minSum;

        // edge case :- if all elements negative so TotalSum == minSum & maxSum < 0
        if(ans1<0){
            return ans1;
        }else{
            return Math.max(circularSum,ans1);
        }
    }

    static int[] MinimumSumOfSubarray(int[] arr){

        int min = arr[0];
        int currMin = arr[0];
        int TotalSum = arr[0];
        for(int i=1;i<arr.length;i++){
            currMin = Math.min(currMin+arr[i],arr[i]);
            min = Math.min(min,currMin);
            TotalSum+=arr[i];
        }
        int[] res = {TotalSum,min};
        return res;
    }
}


// 12.
class MinimumFlipsToMakeArraySame{
    static int[] countGroupsFrequency(int[] arr){
        int c0 = 0;int c1 = 0;
        int g0 = 0; int g1 = 0;
        int n = arr.length;

        for(int i = 0;i<arr.length;i++){
            if(arr[i]==1){
                c1++;
                if(c0>0){
                    g0++;
                    c0 = 0;
                }
            }else{
                c0++;
                if(c1>0){
                    g1++;
                    c1 = 0;
                }
            }
        }

        // this is very imp to maintain group Count in last idx;
        if(arr[n-1]==0){
            g0++;
        }else{
            g1++;
        }
        int[] res = {g0,g1};
        return res;

    }
}



// 13.
class MaximumSumOfKConsequtiveElementsInArray{

    // naive approach
    static int fun1(int[] arr,int k){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n-(k-1);i++){
            int currsum = 0;
            for(int j = i;j<i+k;j++){
                currsum = currsum + arr[j];
            }
            max = Math.max(max,currsum);
        }
        return max;
    }

    // Efficient Approach
    static int fun2(int[] arr,int k){
        // first find first window sum
        int n = arr.length;
        int maxsum = Integer.MIN_VALUE;
        int currsum = 0;
        for(int i = 0; i<k;i++){
            currsum+= arr[i];
        }
        maxsum = Math.max(maxsum,currsum);
        for(int j = k;j<n;j++){
            currsum = currsum + arr[j] - arr[j-k];
            maxsum =Math.max(currsum,maxsum);
        }
        return maxsum;
    }
}



// 14.
class FindSubArrayWithGivenSumOfKConsequetives{
    static boolean fun2(int[] arr,int k,int givenSum){
        int n = arr.length;
        int currsum = 0;
        for(int i = 0 ; i<k;i++){
            currsum = currsum + arr[i];
        }

        if(currsum == givenSum){
            return true;
        }

        for(int j = k;j<n;j++){
            currsum = currsum + arr[j] - arr[j-k];
            if(currsum == givenSum){
                return true;
            }
        }
        return false;
    }
}


// 15.
class FindSubArrayWithGivenSumOfAllPositiveIntergers{
    // this approach will not work with negative elements
    // this will work with only positives numbers;
    static boolean fun1(int[] arr, int givenSum){
        int currsum = 0;
        for(int i = 0;i<arr.length;i++){
            currsum +=arr[i];
            if(currsum==givenSum){
                return true;
            }else if(currsum>givenSum){

                for(int j = 0; j<i;j++){
                    currsum = currsum - arr[j];
                    if(currsum==givenSum){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}



// 16.
class NbonacciNumbers{
    // ***** Very Good Question ********

    static int[] fun1(int N , int M){
        // print(NBonacci Elements);
        int[] res = new int[M];

        res[N-1] = 1;;
        int sum = 1;

        for(int j =N;j<M;j++){
            res[j] = sum;
            sum = sum + res[j] - res[j-N];
        }
        return res;
    }
}


// 17.
class FindEquilibriumPoint{
    // find the index which has left sum & right sum is equal


    // naive approach
    static int fun1(int[] arr){
        for(int i = 0; i<arr.length;i++){
            int lsum = 0;
            for(int j = 0; j<i;j++){
                lsum += arr[j];
            }

            int rsum = 0;
            for(int k = i+1;k<arr.length;k++){
                rsum+=arr[k];
            }

            if(lsum == rsum){
                return i;
            }
        }
        return -1;
    }


    static int fun2(int[] arr){
        // efficient approach
        int[] prefixSumArr = new int[arr.length];
        int sum = arr[0];
        prefixSumArr[0] = arr[0];
        for(int i= 1;i<arr.length;i++){
            prefixSumArr[i] = prefixSumArr[i-1] + arr[i];
        }

        int lsum; int rsum;
        for(int j = 0; j<prefixSumArr.length;j++){

            // base case 1:-
            if(j==0) {
                lsum = 0;
                rsum = prefixSumArr[prefixSumArr.length - 1] - prefixSumArr[j];
            }else if(j==prefixSumArr.length-1){
                rsum = 0;
                lsum = prefixSumArr[j-1];
            }else {
                lsum = prefixSumArr[j - 1];
                rsum = prefixSumArr[prefixSumArr.length - 1] - prefixSumArr[j];
            }

            if(lsum==rsum){
                return j;
            }
        }
        return -1;
    }
}

// 18. Count Inversion Problem
class CountInversionProblem{
    // Naive approach
    static int fun1(int[] arr){
        int count = 0;
        for (int i = 0; i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
               if(arr[i]<arr[j]){
                   count++;
               }
            }
        }
        return count;
    }


    static int fun2(int[] arr, int l , int r){
        int res = 0;
        if(r>l){
            int mid = (l+r)/2;
            // calling recursion fun to sort array of l to mid
            fun2(arr,l,mid);
            // calling recursion fun to sort array of mid+1 to h;
            fun2(arr,mid+1,r);
            // then merge & also count the inverse count
            res = countMerge(arr,l,mid,r);
        }
        return res;
    }


    // Merge sort approach
    // while merging we will think if a[i]>ar[j] => count = count + n1-i

    static int countMerge(int[] arr, int l, int m, int h){
        int n1 = m-l+1;
        int n2 = h-m;
        // copy these elements into the aux arr;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        // copying
        for(int i = 0;i<n1;i++){
            arr1[i] = arr[l+i];
        }
        for(int j = 0;j<n2;j++){
            arr2[j] = arr[m+1+j];
        }

        // then merge these array
        int count = 0;
        int start1 = 0; int start2 = 0; int idx = l;
        while(start1<n1 && start2<n2){
            if(arr1[start1]<=arr2[start2]){
                arr[idx] = arr1[start1];
                start1++;
            }else{
                arr[idx] = arr2[start2];
                count = count + n1-start1;
                start2++;
            }
            idx++;
        }

        while(start1<n1){
            arr[idx] = arr1[start1];
            idx++;
            start1++;
        }

        while(start2<n2){
            arr[idx] = arr2[start2];
            idx++;
            start2++;
        }
        return count;
    }
}


// 19.  Best Time to buy & sell stocks
// only 1 time we can buy & 1 time we can sell

class BestTimeToBuySellStocksFirst{
    // trick:- buy on minimum & sell on maximum
    static int fun2(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = arr[0];
        for(int i = 1; i<arr.length;i++){
            if(arr[i]>min){
                int profit = arr[i]-min;
                max = Math.max(profit,max);
            }else{
                min = arr[i];
            }
        }
        return max;
    }
}

// 20 Best Time to buy & sell stocks
// many time we can buy & many time we can sell stocks

class BestTimeToBuySellStocksSecond{
    static int fun1(int[] arr){
        int n = arr.length;
        int maxProfit = 0;
        for(int i = 1;i<n;i++){
            if(arr[i]>arr[i-1]){
                int profit = arr[i]-arr[i-1];
                maxProfit = maxProfit + profit;
            }
        }
        return maxProfit;
    }
}


class MinimumNumbersOfJumpsToReachEndOfAnArray {
    public static boolean canJump(int[] nums) {

        // handle base case care fully
        if(nums.length==1){
            return true;
        }else if(nums[0]==0){
            return false;
        }else if(nums.length==0){
            return false;
        }

        int steps = nums[0];
        int MaxR = nums[0];

        for(int idx=1;idx<nums.length;idx++){
            // step 1 : check wether we reach end of not
            if(idx==nums.length-1){
                return true;
            }

            // step 2 update MaxR
            MaxR = Math.max(MaxR,nums[idx]+idx);

            // step 3: decrease the steps
            steps--;

            if(steps==0){

                // check idx>= MaxR
                if(idx>=MaxR){
                    return false;
                }
                steps = MaxR-idx;
            }
        }
        return false;
    }
}




class IntersectionOfThreeSortedArrayWithRepeatElement {
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3)
    {
        // code here

        ArrayList<Integer> res = new ArrayList<Integer>();

        int i = 0;
        int j = 0;
        int k = 0;


        int prev1 = Integer.MIN_VALUE;
        int prev2 = Integer.MIN_VALUE;
        int prev3 = Integer.MIN_VALUE;

        while(i<n1 && A[i]==prev1){
            i++;
        }


        while(j<n2 && B[j]==prev2){
            j++;
        }


        while(k<n3 && C[k]==prev3){
            k++;
        }

        while(i<n1 && j < n2 && k<n3){
            if(A[i]==B[j] && B[j]==C[k]){
                res.add(A[i]);
                prev1 = A[i];
                prev2 = B[j];
                prev3 = C[k];
                i++;
                j++;
                k++;
            }

            if(A[i]<B[j]){
                prev1 = A[i];
                i++;
            }else if(B[j]<C[k]){
                prev2 = B[j];
                j++;
            }else{
                prev3 = C[k];
                k++;
            }
        }

        return res;

    }
}




public class DSACrackerSheetArray {
    public static void main(String[] args){
        int[] arr1 = {1, 3, 5, 9, 6, 2, 6, 7, 6, 8, 9};
        boolean res = MinimumNumbersOfJumpsToReachEndOfAnArray.canJump(arr1);
        System.out.println(res);
    }
}




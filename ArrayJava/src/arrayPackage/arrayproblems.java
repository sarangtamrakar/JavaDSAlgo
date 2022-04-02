package arrayPackage;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


class SearchingInArray{
    static int fun1(ArrayList<Integer> array, int x){
        int n = array.size();
        for(int idx=0;idx<n;idx++){
            if(x==array.get(idx)){
                return idx;
            }
        }
        return -1;

    }
}


class insertInFixedSizeArray{
    static int fun1(int[] InsertArr,int idx, int x, int capacity, int CurrentCapacity){
        if(CurrentCapacity == capacity){
            return idx;
        }
        if(CurrentCapacity<capacity){
            int n = CurrentCapacity-1;
            for(int i = n;i>=idx;i--){
                InsertArr[i+1] = InsertArr[i];
            }
            InsertArr[idx] = x;
        }
        for (int e : InsertArr){
            System.out.println(e);
        }
        return idx;

    }
}

class deletionInFixedSizeArray{

    static int[] fun2(int arr[],int x,int n){
        int idx = findelement(arr,x,n);
        if(idx>=0){
            for(int i=idx;i<n-1;i++){
                arr[i] = arr[i+1];
            }
            arr[n-1] = -1;
            return arr;
        }
        return arr;
    }

    static int findelement(int[] arr, int x, int n){
        for(int idx=0;idx<n;idx++){
            if (arr[idx]==x){
                return idx;
            }
        }
        return -1;

    }
}



class LargestElementInArray{
    static int fun1(int[] arr){
        int n = arr.length;
        int largest = arr[0];
        int largestIndex = 0;
        for(int i=1;i<n;i++){
            int val = arr[i];
            if (val>largest){
                largest = val;
                largestIndex = i;
            }
        }
        return largestIndex;
    }
}


class SecondLargestELement{
    static int fun1(int[] arr){
        int sl = -1;
        int largest = arr[0];
        for(int idx=1;idx<arr.length;idx++){
            int val = arr[idx];
            if(val>largest){
                sl = largest;
                largest = val;
            } else if(val<largest){ // maintaining second largest corner case
                if(sl == -1){
                    sl = val;
                } else if(sl<val){
                    sl = val;
                }
            }
        }
        return sl;

    }
}

class CheckArraySorted{
    static boolean fun1(int[] arr){
        int n = arr.length;
        int previous = arr[0];
        for(int i=1;i<n;i++){
            int val = arr[i];
            if(val<previous){
                return false;
            }
            previous = val;
        }
        return true;
    }
}


class ReverseTheArray{
    static int[] fun1(int[] arr){
        int n = arr.length;
        int i = 0;
        int j = n-1;
        while(i<j){
            int back = arr[j];
            int forward = arr[i];
            arr[j] = forward;
            arr[i] = back;
            i++;
            j--;
        }
        return arr;
    }
}

class removeDuplicatesFromSortedArray{
    static int fun1(int[] arr){
        int n = arr.length;
        int idx = 1;
        int previous = arr[0];
        for(int i=1;i<n;i++){
            int val = arr[i];
            if(val != previous){
                arr[idx] = val;
                idx = idx+1;
            }
            previous = val;
        }
        return idx;
    }
}

class MoveZeroesToEnd{
    static ArrayList<Integer> fun1(ArrayList<Integer> arr,int n){
        for(int i =0;i<n;i++){
            int val = arr.get(i);
            if(val==0){
                arr.remove(i); // index valur required for that
                arr.add(val); // actual value required for that
            }
        }
        return arr;
    }

    static int[] fun2(int[] arr){         // Naive approach with O(n2) time complexity...
        int n = arr.length;
        for(int i=0;i<n;i++){
            int val = arr[i];
            if(val==0){
                for(int j =i+1;j<n;j++){
                    int nonZeroElement = arr[j];
                    if(nonZeroElement != 0){
                        arr[i] = nonZeroElement;
                        arr[j] = val;
                        break;
                    }
                }
            }
        }
        return arr;
    }

    static int[] fun3(int[] arr){
        int n = arr.length;
        int counter = 0;
        for(int idx = 0; idx<n;idx++){
            int val = arr[idx];
            if(val!=0){
                arr[idx] = 0;
                arr[counter] = val;
                counter++;
            }
        }
        return arr;
    }
}


class LeftRotateArrayByD{
    static int[] fun1(int[] arr,int d){  // O(n*d)   O(1) auxspace

        // this method works for d<n or d>n both cases
        int n = arr.length;
        for(int i=0;i<d;i++){
            int val = arr[0];
            for(int j=1; j<n;j++){
                arr[j-1] = arr[j];
            }
            arr[n-1] =val;
        }
        return arr;
    }


    static int[] fun2(int[] arr,int d){
        // this method works only for d<n

        int n = arr.length;
        // store d element into saperate space
        int[] temp = new int[d];
        for (int i=0;i<d;i++){
            temp[i] = arr[i];
        }

        // move other element d step back
        for(int idx = d;idx<n;idx++){
            arr[idx-d] = arr[idx];
        }

        // copy the element from temp to arr
        for(int j=0;j<d;j++){
            int val = temp[j];
            arr[n-d+j] = val;
        }
        return arr;
    }

    static int[] fun3(int[] arr,int d){
        int n = arr.length;
        d = d%n;  // it will take care that d<n; correction from leetcode
        ReverseTheArrayByIndex(arr,0,d-1);
        ReverseTheArrayByIndex(arr,d,n-1);
        ReverseTheArrayByIndex(arr,0,n-1);
        return arr;
    }
    static void ReverseTheArrayByIndex(int[] arr,int min,int max){
        while(min<max){
            int i = arr[min];
            int j = arr[max];
            arr[min] = j;
            arr[max] = i;
            min++;
            max--;
        }
    }





}

class LeadersInArray{
    // that element is called leader , which has no greater element on right side
    static void fun1(int[] arr){
        int n = arr.length;
        int leader = arr[n-1];
        System.out.println(leader);
        for(int i = n-2;i>=0;i--){
            int val = arr[i];
            if(val>leader){
                leader = val;
                System.out.println(leader);
            }
        }
    }
}

class MaximumDifference{
    // Find maximum difference between arr[j]-arr[i] such that
    // Here (j>i) always

    static int fun1(int[] arr){
        int n = arr.length;
        int max = arr[1]-arr[0];
        for(int i=0;i<n;i++){
            int val = arr[i];
            for(int j =i+1;j<n;j++){
                int val2 = arr[j];
                int diff = val2-val;
                if(diff>max){
                    max = diff;
                }
            }
        }
        return max;
    }

    static int fun2(int[] arr){
        // trick:- we will find minimum from left side then minus the right values from min only
        // if we find difference more than maxDiff we will update it , & when we will also find that if right value
        // is less than min value , we will update the result.
        int n = arr.length;
        int min = arr[0];
        int maxDiff = arr[1]-arr[0];
        for(int i=1;i<n;i++){      // index will start from 1(j>i)
            int val = arr[i];

            int diff = val-min;
            if(diff>maxDiff){
                maxDiff = diff;
            }
            if(val<min) {
                min = val;
            }
        }
        return maxDiff;
    }
}

class FrequencyInSortedArray{
    static  void fun1(int[] arr){
        int n = arr.length;
        int val1 = arr[0];
        int freq = 1;
        for(int i=1;i<n;i++){
            int val2 = arr[i];
            if(val1 == val2){
                freq++;
            } else{
                System.out.println(val1+" Frequency : "+freq);
                val1 = val2;
                freq = 1;
            }
        }
        System.out.println(val1+" Frequency : "+freq);

    }
}

class StockBuyandSelltype1Profitcase{
    // max profit
    // here we have to purchase the stock at i & sell at j
    // conditions:-
    // 1. only one time we can purchase & only one time we can sell
    // 2. i<j(always)
    static int fun1(int[] arr){
        int n = arr.length;
        int min = arr[0];
        int maxProfit = 0;
        for(int idx =1;idx<n;idx++){
            int val = arr[idx];
            if (val>min){
                int diff = val-min;
                if(diff>maxProfit){
                    maxProfit = diff;
                }
            } else if(val<min){
                min = val;
            }
        }
        return maxProfit;
    }
}


class StockBuyandSelltype1LossCase{
    // max Loss
    // here we have to purchase the stock at i & sell at j
    // conditions:-
    // 1. only one time we can purchase & only one time we can sell
    // 2. i<j(always)
    static int fun1(int[] arr){
        int n = arr.length;
        int maxLoss = 0;
        int maxVal = arr[0];
        for(int idx=1;idx<n;idx++){
            int val = arr[idx];
            if(val<maxVal){
                int diff = val-maxVal;
                if(diff<maxLoss){
                    maxLoss = diff;
                }
            } else if(val>maxVal){
                maxVal = val;
            }
        }
        return maxLoss;
    }

}

class StockBuyandSelltype2ProfitCase{
    // max profit
    // this stock buy & sell type 2;
    // Condition:-
    // 1. you can buy & sell multiple times
    // 2. after buy u can only do sell , u cant buy after buy.

    static int fun1(int[] arr){
        int maxProfit = 0;
        int previous = arr[0];
        int n = arr.length;
        for(int idx = 1;idx<n;idx++){
            int val = arr[idx];
            if (val>previous){
                maxProfit = maxProfit + (val-previous);
                previous = val;
            }else{
                previous = val;
            }
        }
        return maxProfit;
    }
}



class StockBuyandSelltype2LossCase{
    // max Loss
    // this stock buy & sell type 2 Loss Case;
    // Condition:-
    // 1. you can buy & sell multiple times
    // 2. after buy u can only do sell , u can't buy after buy.

    static int fun1(int[] arr){
        int n = arr.length;
        int maxLoss = 0;
        int previous = arr[0];
        for(int idx=1;idx<n;idx++){
            int val = arr[idx];
            if(val<previous){
                maxLoss = maxLoss+(val-previous);
            } else{
                previous = val;
            }
        }
        return maxLoss;
    }
}


class TrappingRainWater{

    // naive approach o(n2)
    static int fun1(int[] arr){
        int reservoirWater = 0;
        int n = arr.length;
        for(int idx=1;idx<n-1;idx++){
            int val = arr[idx];

            // find left max from idx
            int Lmax = arr[0];
            for(int i=1;i<=idx;i++){
                if(arr[i]>Lmax){
                    Lmax = arr[i];
                }
            }

            // find Rmax from idx
            int Rmax = arr[n-1];
            for(int j=n-2;j>=idx;j--){
                if(arr[j]>Rmax){
                    Rmax = arr[j];
                }
            }

            // find min of both of them
            int min = Math.min(Lmax,Rmax);
            reservoirWater = reservoirWater +(min-val);
        }
        return reservoirWater;
    }


    static int fun2(int[] arr){
        // here we will take O(N) auxilary space then solve the problem
        int n = arr.length;

        // first find the Lmax for all idx
        int[] LmaxArr = new int[n];
        int Lmax = arr[0];
        LmaxArr[0] = Lmax;
        for(int i=1;i<n;i++){
            int val = arr[i];
            Lmax = Math.max(val,Lmax);
            LmaxArr[i] = Lmax;
        }

        // find Rmax for all index
        int[] rmaxArr = new int[n];
        int Rmax = arr[n-1];
        for(int j=n-2;j>=0;j--){
            int val = arr[j];
            Rmax = Math.max(val,Rmax);
            rmaxArr[j] = Rmax;
        }

        // now go ahead with trapping water
        int reservoirWater = 0;
        for(int idx = 1;idx<n-1;idx++){
            int val = arr[idx];
            int lmax = LmaxArr[idx];
            int rmax = rmaxArr[idx];
            int min = Math.min(rmax,lmax);
            reservoirWater = reservoirWater + (min-val);
        }
        return reservoirWater;
    }
}


class MaximumConsecutiveOnes{
    static int fun1(int[] arr){
        int n = arr.length;
        int finalFreq = 0;
        int currentFreq = 0;
        for(int idx=0;idx<n;idx++){
            int val = arr[idx];
            if(val==1){
                currentFreq++;
            }else{
                if(currentFreq>finalFreq){
                    finalFreq = currentFreq;
                    currentFreq = 0;
                }
            }
        }
        if(currentFreq>finalFreq){
            finalFreq = currentFreq;
        }
        return finalFreq;
    }
}


class MaximumSumOfSubArray{
    // Kadane Alogorithms will be used here

    static int fun1(int[] arr){
        // naive approach O(n2) solution
        int n = arr.length;
        int finalSum = 0;
        for(int i=0;i<n;i++){
            int currentSum=0;
            for(int j=i;j<n;j++){
                currentSum = currentSum + arr[j];
                finalSum = Math.max(currentSum,finalSum);
            }
        }
        return finalSum;
    }

    static int fun2(int[] arr){
        int n = arr.length;
        int arrMax = arr[0];
        int currentMax = arr[0];
        for (int idx = 1; idx < n; idx++) {

            currentMax = Math.max(currentMax + arr[idx],arr[idx]);
            arrMax = Math.max(currentMax, arrMax);
        }
        return arrMax;
    }

}

class MaximumLengthOfEvenOddSubArray{
    // [1,2,3,4]==> 4
    // find the maximum length of sub array which is having alternative
    // even-odd or odd-even combination

    static  int fun1(int[] arr){
        // naive approach O(n2)
        int n = arr.length;
        int resLength = 0;
        for(int i=0;i<n;i++){
            int currentLength =1;
            for(int j=i+1;j<n;j++){
                if((arr[j]%2==0 && arr[j-1]%2!=0) || (arr[j]%2!=0 && arr[j-1]%2==0)){
                    currentLength++;
                }else{
                    break;
                }
            }
            resLength = Math.max(currentLength,resLength);
        }
        return resLength;
    }

    static int fun2(int[] arr){
        // Kadane's Algorithms (here we are using concept of previous sub array& come up with new result in present sub array)
        int n = arr.length;
        int resLength = 0;
        int currentLength = 1;
        for(int idx=1;idx<n;idx++){
            if((arr[idx]%2==0 && arr[idx-1]%2!=0) ||(arr[idx]%2!=0 && arr[idx-1]%2==0)){
                currentLength++;
                resLength = Math.max(currentLength,resLength);
            }else{
                currentLength = 1;
            }
        }
        return resLength;
        }
}






class FinalCircularSubArrSum{



    static int CircularSubArrSum(int[] arr,int n){
        int TArrSum = arr[0];
        int arrMin = arr[0];
        int currentMin = arr[0];
        for(int j = 1;j<n;j++){
            TArrSum = TArrSum + arr[j];
            currentMin = Math.min(currentMin+arr[j],arr[j]);
            arrMin = Math.min(arrMin,currentMin);
        }
        int CircularSubArrSumVariable = (TArrSum-arrMin);
        return CircularSubArrSumVariable;
    }

    static int fun1(int[] arr){
        // Naive Approach
        //  maximum sum of Circular subarray sum;
        int allSumArrMax = arr[0];
        int n = arr.length;
        for(int i =0;i<n;i++) {
            int arrMax = MaximumSumOfSubArray.fun2(arr);
            allSumArrMax = Math.max(arrMax,allSumArrMax);
        }
        return allSumArrMax;
    }

    static int fun2(int[] arr){
        int n = arr.length;
        //  efficient approach
        // 1. find  max of normal subarr sum usin kadane's algorithm
        // 2. find circular subArr sum
        //     a. find min subArr sum in normal arr & arr sum in normal arr
        //     b. then subtract (arrsum - min SubArr sum) == max of  Circular subArr sum

        // 3. then result(Final circular subarr sum) = max(max normal subArr sum, max of circular subArr sum)

        // ******** start coding **********
        // 1.
        int maxNormalSubArrSum = MaximumSumOfSubArray.fun2(arr);

        // 2.
        int CircularSubArrSumRes  = CircularSubArrSum(arr,n);

        // 3.
        int FinalCircularSubArrSumRes = Math.max(CircularSubArrSumRes,maxNormalSubArrSum);

        return FinalCircularSubArrSumRes;

    }

}


class MajorityElement{
    // If any element that appears in arr more than count > (n/2)
    static void fun1(int[] arr){
        int n = arr.length;
        // Naive Approach
        for(int i=0;i<n;i++){
            int count = 1;
            for(int j=i+1;j<n;j++){
                if(arr[j]==arr[i]){
                    count++;
                }
            }
            if(count>(n/2)){
                System.out.println(i);
            }
         }
    }
}

class MajorityElementByMooreVotingAlgorithm{
    // Moore Voting algorithm is having 2 step
    // 1. first we will find majority occuring element idx (it is not always first idx , it can be any idx number)
    // 2. then we check whether this majority element count > (n/2) or not......

    // ******** Start coding ********
    static int findMajorty(int[] arr) {
        // 1. Find majority element idx
        int n = arr.length;
        int res = 0, count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[res] == arr[i]) {
                count++;
            } else count--;
            if(count==0){
                res = i;
                count = 1;
            }
        }
        return res;
    }

    static int checkWhetherItMoreThanNby2(int[] arr){
        int MajorityElementIdx = findMajorty(arr);
        int count = 0;
        int n = arr.length;
        for(int idx=0;idx<n;idx++){
            if(arr[MajorityElementIdx]==arr[idx]){
                count++;
            }
        }
        if(count>(n/2)){
            return MajorityElementIdx;
        }else{
            return -1;
        }
    }

}




class MinimumConsequetiveFlips {
    static int FindGroupCountOfZeroAndOne(int[] arr) {
        int n = arr.length;
        int Gone = 0;
        int Cone = 0;
        int Gzero = 0;
        int Czero = 0;
        for (int i = 0; i < n; i++) {
            int val = arr[i];

            if (val == 1) {
                Cone++;
                if (Czero > 0) {
                    Gzero++;
                    Czero = 0;
                }
            } else {
                Czero++;
                if (Cone > 0) {
                    Gone++;
                    Cone = 0;
                }
            }
        }
        if (Gzero >= Gone) {
            return 1;  // find minimum group count that's why  return 1 when Czero is more
        } else {
            return 0;
        }
    }

    static void fun1(int[] arr) {
        int n = arr.length;
        int val = FindGroupCountOfZeroAndOne(arr);

        int from = 0;
        int to = 0;
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] == val) {
                count++;
                if (count == 1) {  // only update when count==1;
                    from = j;
                }
            } else {
                if (count > 0) {             // if val count >0 then only print
                    System.out.println("From " + from + " to " + (j - 1));
                    count = 0;            // then reset count to 0 so that we can set new from variable
                }
            }
        }
        if (arr[n - 1] == val) { // if arr ending with val element
            to = n - 1;
            System.out.println("From " + from + " to " + to);
        }
    }
}

class MaxSlidingWindowSum {
    static int fun1(int[] arr, int k) {
        // two for loop O(nk) solution
        int n = arr.length;
        int MaxSum = 0;
        for (int i = 0; i < n - (k - 1); i++) {   // n = 6 ,k=3 loop should run atleast upto 6-(3-1) ==> n-(k-1)
            int currentSum = 0;
            for (int j = i; j < i + k; j++) {
                currentSum = currentSum + arr[j];
            }
            MaxSum = Math.max(currentSum, MaxSum);
        }
        return MaxSum;
    }


    // efficient solution
    static int fun2(int[] arr, int k) {
        // this solution run two loop O(k) + O(N-k+1) ==> O(N)

        int n = arr.length;
        int MaxSum = 0;
        int currentSum = 0;

        // first find the 1st sliding window sum;
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        // then update maxSum;
        MaxSum = Math.max(currentSum, MaxSum);

        // then find the other sliding window sum using first window sum;
        for (int j = 1; j < n - (k - 1); j++) {
            currentSum = currentSum + arr[j + (k - 1)] - arr[j - 1];
            MaxSum = Math.max(currentSum, MaxSum);
        }
        return MaxSum;
    }
}

class FindSubArrOfSizeKHavingSumS{
    // There is an arr of interger of size n, we have to check subarr of given Sum exist or not;
    // given ===>
    // int[] arr , int k , int sum
    static boolean fun1(int[] arr,int k,int sum){
        int n = arr.length;
        int currentSum = 0;
        for(int i=0;i<k;i++){
            currentSum+=arr[i];
        }
        // check first subArr of size K is equal to given sum or not; if not then only check for other subarr;
        if (currentSum==sum){
            return true;
        }

        for(int j = 1;j<n-(k-1);j++){
            currentSum = currentSum - arr[j-1] + arr[j+(k-1)];
            if(currentSum==sum){
                return true;
            }
        }
        return false;
    }
}


class IsAnySubArrHavingSumS{

    static boolean fun1(int[] arr,int sum){

        // this solution only for All positive integer array
        int n = arr.length;
        int currentSum = arr[0];
        int start = 0;

        for(int end =1;end<n;end++){
            while(currentSum>sum && start<end-1){
                currentSum = currentSum-arr[start];
                start++;
            }
            if(currentSum == sum){
                return true;
            }
            currentSum = currentSum + arr[end];
        }
        return (currentSum==sum);
    }
}

class printNbonacciNumbersMtimes{
    // fiboncci is 2-bonacci
    static void fun1(int n,int m){
        int[] arr = new int[m];
        int i;
        for(i=0;i<n-1;i++){
            arr[i] = 0;
            System.out.println(0);
        }
        arr[i] = 1;
        System.out.println(1);
        int currentWindowSum = 1;
        for(int j=n ;j<m;j++){
            arr[j] = currentWindowSum;
            currentWindowSum = currentWindowSum - arr[j-n] +arr[j];
            System.out.println(arr[j]);
        }
    }
}


class PerformSumQueriesInOofN {
    // Given a fixed array and multiple queries of folllowing types on the array , how to efficiently perform these queries:-
    // queries==> getSum(arr,startIdx,endIdx);

    // opimised solution based on prefix sum

    static int getSum(int[] arr,int startIdx,int endIdx) {
        if (startIdx == 0) {
            return arr[endIdx];
        } else return arr[endIdx] - arr[startIdx - 1];
    }



    static void fun1(int[] arr){
        // first of all store the presum in an array
        int n = arr.length;
        int[] presumArr = new int[arr.length];
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            presumArr[i] = sum;
        }

        // get sum of indexes in O(1);
        System.out.println(getSum(presumArr,2,2));

    }
}


class EquilibriumPoint{
    // Equilibrium point is that point having left & right sum equal

    // Naive solution
    static void fun1(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            // find left sum
            int leftSum = 0;
            int j = i-1;
            while(j>=0){
                leftSum +=arr[j];
                j--;
            }

            // find right sum
            int rightSum = 0;
            int k = i+1;
            while(k<=n-1){
                rightSum+= arr[k];
                k++;
            }
            if(leftSum == rightSum){
                System.out.println("Yes");
            } else{
                System.out.println("No");
            }
            System.out.println("Index: "+i);
        }
    }

    static void fun2(int[] arr){
        // o(n) time & o(n) space complexity
        // first create array of prefix sum
        int n = arr.length;
        int[] preFixArr = new int[n];
        int sum = 0;
        for(int i = 0; i<n;i++){
            sum+=arr[i];
            preFixArr[i] = sum;
        }
        // find is any number is euilibrium or not;
        for(int j=0;j<n;j++){

            // find left sum;
            int leftsum = 0;
            if(j>0){
                leftsum = preFixArr[j-1];
            }

            //find right sum;
            int rightSum = 0;
            if(j<n-1){
                rightSum = preFixArr[n-1]-preFixArr[j];
            }
            if(rightSum == leftsum){
                System.out.println("yes");
                System.out.println("Index: "+j);
            }
        }
    }

    // solve it in o(n) time & O(1) space complexity
    // Home Work
    static void fun3(int[] arr){
        int n = arr.length;
        // first find the total sum;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }

        int leftSum = 0;
        for(int j = 0;j<n;j++){
            int rightsum = sum - arr[j];
            sum = sum - arr[j];
            if(rightsum == leftSum){
                System.out.println("Yes : At index "+j);
            }
            leftSum+=arr[j];
        }
    }

}


class MaximumOccuringElementInRanges{
    // we have given ranges
    // L[] = {1,3,5}
    // R[] = {5,6,8}
    // so here we have to find most occuring element

    // naive way , use hashing & iterate thrught each range & increse the frequency if element found
    // then find max frequent element in hashing freuencies


    static int fun1(int[] Larr,int[] Rarr,int n){
        // optimised solution
        // If we know that L[] & R[] < 1000 or 10000, so we can use the arr then we will use prefix technique to keep track
        // count of every element

        int[] arrFreqs = new int[1000];
        for(int i =0;i<n;i++){
            arrFreqs[Larr[i]] = arrFreqs[Larr[i]] + 1;
            arrFreqs[Rarr[i]+1] = arrFreqs[Rarr[i]+1]-1;
        }
        int max = 0; int res = 0;
        int currentSum = 0;
        for(int j=0;j<1000;j++){
            currentSum = currentSum + arrFreqs[j];
            if(currentSum>max){
                max = currentSum;
                res = j;
            }
        }
        return res;
    }
}




class MeanOfArray{
    static int fun1(int[] arr){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum+=arr[i];
        }
        return sum/arr.length;
    }
}


class MedianOfArray{
    static int fun1(int[] arr){
        Arrays.sort(arr);
        if(arr.length%2==0){
            int idx1 = arr.length/2;
            int idx2 = (arr.length/2)-1;
            return (arr[idx1]+arr[idx2])/2;
        }else{
            int idx3 = arr.length/2;
            return arr[idx3];
        }
    }
}


class ReverseArrayInGroupOfSizeK{
    static void fun1(int[] arr,int k){
        int n = arr.length;
        for(int i = 0; i<arr.length;i= i+k){
            int left = i; int right = Math.min(i+k-1,n-1);

            while(left<right){
                int tempVar = arr[left];
                arr[left] = arr[right];
                arr[right] = tempVar;
                left++;
                right--;
            }
        }

        for(int e:arr){
            System.out.println(e);
        }

    }
}



class MinimumAdjacentDifferenceInACircularArray{
    static void fun1(int[] arr){
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length-1;i++){

            int diff = Math.abs((arr[i]-arr[i+1]));
            min = Math.min(min,diff);
        }

        // just find diff between last & first index...
        int dif = Math.abs(arr[n-1]-arr[0]);
        min = Math.min(min,dif);
        System.out.println(min);
    }
}



class MaximumOccuredInteger{
    static int NaiveMethod(int[] arr1, int[] arr2){
        // we will iterate through all the ranges & maitaining elements frequency in hashmap
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        int n = arr1.length;

        for(int i = 0; i<n;i++){
            for(int j = arr1[i];j<=arr2[i];j++){

                if(hmap.containsKey(j)){
                    hmap.put(j,hmap.get(j)+1);
                }else{
                    hmap.put(j,1);
                }
            }
        }
        // find max value in hash map
        int maxValues = Collections.max(hmap.values());
        for(int e: hmap.keySet()){
            if(hmap.get(e)==maxValues){
                return e;
            }
        }
        return -1;
    }

    static int OptimisedSolution(int[] arr1, int[] arr2){
        int[] temp  = new int[1000000];
        // now mark the starting & ending point of ranges int temp arr
        for(int i = 0;i<arr1.length;i++){
            temp[arr1[i]]+=1;
            temp[arr2[i]+1]-=1;
        }

        // now find prefix sum arr;
        int curr = 0;
        for(int j = 0; j<temp.length;j++){
            curr+=temp[j];
            temp[j] = curr;
        }

        int res = 0;
        int maxelement = Integer.MIN_VALUE;
        for(int k = 0; k<temp.length;k++){

            if(temp[k]>maxelement){
                maxelement = temp[k];
                res = k;
            }
        }
        System.out.println(res);
        return res;
    }
}



class ConvertToWaveArray{
    static int[] NaiveMethod(int[] arr){

        for(int i = 1; i<arr.length;i = i+2){
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
        return arr;
    }

    // also solve it for unsorted arr with Optimised approach
}



class FrequenciesOfLimitedRangeArrayElements{
    // Given an array A[] of N positive integers which can contain integers from 1 to P where elements can be repeated or
    // can be absent from the array.
    // Your task is to count the frequency of all elements from 1 to N.
    // Note: The elements greater than N in the array can be ignored for counting.


    static void NaiveMethod(int[] arr , int p , int N){

        // O(N*n) solution
        for(int i = 1;i<=N;i++){
            int count = 0;
            for(int j = 0;j<arr.length;j++){
                if(arr[j]==i && arr[j]<=N){
                    count++;
                }
            }
            System.out.println(i+" "+count);
        }
    }

    static void OptimisedSolution1(int[] arr, int N){
        // O(N) solution && O(N) space complexity

        int[] temp = new int[N];
        for(int i = 0; i<arr.length;i++){
            temp[arr[i]-1]++;
        }

        // print temp arr elements & Their frequency
        for(int j =0 ; j<temp.length;j++){
            int element = j+1;
            System.out.println(element +" "+temp[j]);
        }
    }
}




class SmallestPositiveMissingNumber{
    // Very IMP Question
    // solve it in O(N) time & O(1) space

    static int NaiveMethod(int[] arr){
        // O(1000000 * N) solution (Quadratic solution)
        int i;
        for(i = 1; i<1000000;i++){
            boolean isPresent = false;
            for(int j = 0; j<arr.length;j++){
                if(i==arr[j]){
                    isPresent = true;
                    break;
                }
            }
            if(!isPresent){
                return i;
            }
        }
        return i;
    }

    static int Optimised1(int[] arr){
        // it is O(NLogN) solution
        Arrays.sort(arr);
        int variable = 1;
        for(int idx = 0; idx<arr.length;idx++){
            if(arr[idx]>0){
                if(arr[idx]==variable){
                    variable++;
                }else{
                    return variable;
                }
            }
        }
        return variable;
    }

    static int optimised2(int[] arr){
        // O(1000000) space & o(1000000) time...
        // counter  arr method
        // we will create temp arr of size 10^6
        int[] temparr = new int[1000000];

        for(int i = 0; i<arr.length; i++){
            int val = arr[i];
            if(arr[i]>0){
                temparr[arr[i]-1]++;
            }
        }

        int j;
        for(j = 0; j<temparr.length; j++){
            if(temparr[j]==0){
                return j+1;
            }
        }
        return j;
    }
}


class RearrangeArrayAlternatively{
    static int[] NaiveSolution(int[] arr){
        int n = arr.length;
        int[] res = new int[arr.length];

        int i = n-1; int j = 0;
        while((i>=0) && (j<res.length)){
            res[j] = arr[i];
            j = j+2;
            i--;
        }

        i = 0; j = 1;
        while((i<arr.length) && (j<res.length)){
            res[j] = arr[i];
            i++;
            j = j + 2;
        }

        return res;

    }
}


public class arrayproblems {
    public static void main(String[] args) {

        int[] arr1 = {10,20,30,40,50,60,70,80,90,100,110};
        int[] res = RearrangeArrayAlternatively.NaiveSolution(arr1);
        System.out.print(Arrays.toString(res));



    }

}




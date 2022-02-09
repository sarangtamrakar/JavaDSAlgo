package bsPackage;


import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

class BinarySearchQuestion {
    static int fun1(int[] arr, int x) {

        // iterative solution+++++
        int n = arr.length;
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(x==arr[mid]){
                return mid;
            }else if(x<arr[mid]){
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        return -1;
    }


    static int fun2(int[] arr,int x,int start,int end) {
        // recursive solution
        if (start>end) {
            return -1;
        }
        int mid = (start+end)/2;
        if(x==arr[mid]){
            return mid;
        }else if(x<arr[mid]){
            return fun2(arr,x,start,mid-1);
        } else{
            return fun2(arr,x,mid+1,end);
        }
    }
}

class OccuranceOfFirstIndexInSortedArray{
    static int fun1(int[] arr,int x){
        int n = arr.length;
        int start =0;
        int end = n-1;

        while(start<=end){
            int mid = (start+end)/2;
            if(x==arr[mid]){
                if(mid==0){
                    return 0;
                }
                if(x==arr[mid-1]){
                    end = mid-1;
                }else {
                    return mid;
                }
            }else if(x<arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }


    static int fun2(int[] arr , int x,int start,int end){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if (x==arr[mid]){
            if(mid ==0){
                return 0;
            } else {
                if(x==arr[mid-1]){
                    return fun2(arr,x,start,mid-1);
                }else{
                    return mid;
                }
            }
        }else if(x<arr[mid]){
            return fun2(arr,x,start,mid-1);
        }else {
            return fun2(arr, x, mid + 1, end);
        }
    }
}

class countOccurancesInSortedArray {
    static int fun1(int[] arr, int x) {
        // it is O(logN) + O(N) solution in worst case when whole array is searched element
        int idx = OccuranceOfFirstIndexInSortedArray.fun1(arr, x);
        if (idx != -1) {
            int count = 0;
            for (int i = idx; i < arr.length; i++) {
                if (arr[i] == x) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        } else {
            return 0;
        }
    }


//    static int fun2(int[] arr,int x){}
    // O(LogN) solution in any case
    // int idx = OccuranceOfFirstIndexInSortedArray(arr,x);
//        if(idx==-1){
//            return 0;
//        }else{
//            return OccuranceOfFirstIndexInSortedArray(arr,x)-idx+1
//        }
//    }
}

class square_root{

    // naive solution
    static int fun1(int[] arr,int x){
        int i = 1;
        while(i*i<=x){
            i++;
        }
        return i-1;
    }

    // binary search efficient solution
    static int fun2(int x){
        int start = 1;
        int end = x;
        int ans = -1;
        while(start<=end){
            int mid = (start+end)/2;
            int midsq = mid * mid;
            if(midsq==x){
                return mid;
            } else if(midsq>x){
                end = mid-1;
            }else{
                start = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
}

class SearchInInfiniteSizedArray{
    static int fun1(int[] arr,int x){
        // here we can't use the n = arr.length;
        if(arr[0]==x) return 0;
        int i = 1;
        while (arr[i]<x){
            i = i*2;
        }
        if(arr[i]==x){
            return i;
        }else{
            return BinarySearchQuestion.fun2(arr,x,(i/2)+1,i-1);
        }
        }
}


class SearchInRotatedSortedArray{
    static int fun1(int[] arr,int x){
        // this will one side always be sorted
        int n = arr.length;
        int l = 0;
        int h = n-1;

        while(l<=h){
            int mid = (l+h)/2;
            if(arr[mid]==x){
                return mid;
            }
            // if left sorted // ******Equal Is very IMP*************it is test case [3,1] x = 1
            if(arr[l]<=arr[mid]){   // equal is very IMP
                if(x>=arr[l] && x<arr[mid]){ // & x in this range go in left side
                    h = mid-1;
                }else{
                    l = mid+1;  // other wise in go right
                }
            }else{
                // if left side is not sorted so rigt side always be sorted
                if(x>arr[mid] && x<=arr[h]){
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }
        }
        return -1;
    }
}


class SearchInRotatedSortedArrayWithRepeatElements {
    public boolean fun1(int[] nums, int target) {

        int n = nums.length;
        if(n==1){
            if(nums[0]==target){
                return true;
            }else{
                return false;
            }
        }

        int l = 0;
        int h = n-1;
        while(l<=h) {
            int mid = (l + h) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] > nums[l]) {  // this equal is very IMP [3,1] find 1 test case
                if (target < nums[mid] && target >= nums[l]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if(nums[mid]<nums[h]){
                if (target>nums[mid] && target <= nums[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }else{
                if(nums[mid]==nums[l]){
                    l++;
                }
                if(nums[mid]==nums[h]){
                    h--;
                }
            }
        }
        return false;
    }
}








class FindPeakElement{
    // naive O(N) approach......
    static void fun1(int[] arr){
        int n = arr.length;
        if(n==1){
            System.out.println(arr[0]);
        }else{
            for(int idx=0;idx<n;idx++){
                if(idx==0){
                    // compare only right one
                    if(arr[idx]>arr[idx+1]){
                        System.out.println(arr[idx]);
                    }
                }else if(idx==n-1){
                    // compare only left side element
                    if(arr[idx]>arr[idx-1]){
                        System.out.println(arr[idx]);
                    }
                } else{
                    if(arr[idx]>arr[idx+1] && arr[idx]>arr[idx-1]){
                        System.out.println(arr[idx]);
                    }
                }
            }
        }
    }

    static int fun2(int[] arr){
        int n = arr.length;
        // handling corner case
        if(n==1){
            return 0;
        }
        int l = 0;
        int h = n-1;
        while(l<=h){
            int mid = (l+h)/2;

            // writting conditions for mid value
            if(mid==0){
                if(arr[mid]>arr[mid+1]){
                    return mid;
                }else{
                    l = mid+1;
                }
            }else if(mid==n-1){
                if(arr[mid]>arr[mid-1]){
                    return mid;
                }else{
                    h = mid-1;
                }
            }else{
                if(arr[mid]>=arr[mid+1] && arr[mid]>=arr[mid-1]){
                    return mid;
                }else{
                    if(arr[mid]<=arr[mid-1]){
                        h = mid-1;
                    }else if(arr[mid]<arr[mid+1]){
                        l = mid+1;
                    }
                }
            }
        }
        return -1;
    }
}


class FindPairInSortedArrayOfSumX{
    static boolean fun1(int[] arr,int x){
        int n= arr.length;
        int s = 0;
        int e = n-1;
        while(s<e){        // two pointer approach
            int sum = arr[s]+arr[e];
            if(sum==x){
                return true;
            }else if(sum<x){
                s++;
            }else{
                e--;
            }
        }
        return false;
    }
}


class TripletSum{

    static boolean findTwoSum(int[] arr,int start,int end,int sum){
        while(start<end){
            int currSum = arr[start] + arr[end];
            if(currSum==sum){
                return true;
            }else if(currSum<sum){
                start++;
            }else{
                end--;
            }
        }
        return false;
    }

    static boolean fun1(int[] arr,int x){
        // for sorted array*****************
        // this is O(N2) solution*********
        int n = arr.length;
        if(n<3){         // it is edge case
            return false;
        }
        for(int i=0;i<n-1;i++) {
            int a = arr[i];
            int sum = x-a;
            boolean res = findTwoSum(arr,i+1,n-1,sum);
            if(res) {
                return true;
            }
        }
        return false;
    }
}

class MedianOfTwoSortedArray{
    static double fun1(int[] a1,int[] a2){
        int n1 = a1.length;
        int n2 = a2.length;
        int l = 0; int high = n1;
        while(l<= high){
            int i = (l+high)/2;
            int j = ((n1+n2+1)/2)-i;

            int max1 = (i==0)?Integer.MAX_VALUE:a1[i-1];
            int min1 = (i==n1)?Integer.MAX_VALUE:a1[i];
            int max2 = (j==0)?Integer.MIN_VALUE:a2[j-1];
            int min2 = (j==n2)?Integer.MIN_VALUE:a2[j];

            if(min1>=max2 && min2>=max1){
                if((n1+n2)%2==0){
                    return ((double)Math.max(max1,max2+Math.min(min1,min2)))/2;
                }else{
                    return (double)Math.max(max1,max2);
                }
            }else if(min1<max2){
                l = i+1;
            }else{
                high = i-1;
            }
        }
        return 0.0;
    }
}





class Solution {
//    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//    You must write an algorithm with O(log n) runtime complexity.
//
//    Example 1:
//
//    Input: nums = [1,3,5,6], target = 5
//    Output: 2
//    Example 2:
//
//    Input: nums = [1,3,5,6], target = 2
//    Output: 1
//    Example 3:
//
//    Input: nums = [1,3,5,6], target = 7
//    Output: 4


    static public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(target==nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                if (mid==n-1){
                    return mid+1;
                }
                if(target<=nums[mid+1]){
                    return mid+1;
                }else{
                    l = mid+1;
                }
            }else{
                if(mid==0){
                    return mid;
                }
                if(target>nums[mid-1]){
                    return mid;
                }else{
                    h = mid-1;

                }            }
        }
        return -1;
    }
}



class isPerfectSquare {
    static public boolean isPerfectSquare(int num) {
        if(num==0 || num==1){
            return true;
        }
        int l = 1;
        int h = num;
        while(l<=h){
            int mid = (l+h)/2;
            int midsq = mid*mid;
            if(midsq==num){
                return true;
            }else if(num<midsq){
                int midminusSq = (mid-1)*(mid-1);
                if(num>midminusSq){
                    return false;
                }else if(num==midminusSq){
                    return true;
                }else{
                    h = mid-1;
                }
            }else{
                int midPlusSq = (mid+1)*(mid+1);
                if(num<midPlusSq){
                    return false;
                }else if(num==midPlusSq){
                    return true;
                }else{
                    l = mid+1;
                }
            }
        }
        return false;
    }

    // second modulo & divide solution
    static boolean fun2(int num){
        int l = 1;
        int h = num;
        while(l<=h){
            int mid = (l+h)/2;
            int res = num/mid; int remainder = num%mid;
            if(res==mid && remainder==0){
                return true;
            }else if(res<mid){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }
}


class ArrangingCoins{
//    You have n coins and you want to build a staircase with these coins. The staircase consists of k rows
//    where the ith row has exactly i coins. The last row of the staircase may be incomplete.
//    Given the integer n, return the number of complete rows of the staircase you will build.
    static int fun1(int n){
        // Linear Solution
        int currentN = n;
        int i;
        for(i = 1;i<=n;i++){
            currentN = currentN-i;
            if(currentN<0){
                return i-1;
            }
        }
        return i;
    }

    static int fun2(int n){
        // Binary search Optimised solution
        if(n==0 || n==1){
            return n;
        }
        // handling base case
        if (n <= 3) {
            return n == 3 ? 2 : 1;  // if n==3 return 2 else return 1;
        }
        long l = 2;
        long h = n/2;
        while (l<=h){
            long mid = l+((h-l)/2);
            long coinFilled = (mid*(mid+1))/2;
            if(coinFilled==n){
                return (int)mid;
            }else if(coinFilled>n){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return (int)h;   // very imp , use n = 5 to understand this condition
    }
}




class CheckIfNAndItsDoubleExists{
    static  boolean fun1(int[] arr){
        // o(N2) solution
        int n = arr.length;
        for(int i =0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]*2==arr[j] || arr[j]*2==arr[i]){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean fun2(int[] arr){
        // o(NlogN) solution
        int n = arr.length;
        Arrays.sort(arr);
        
        for(int idx=0;idx<n;idx++){
            int findElement = arr[idx]*2;
            int ret = -1;
            if(findElement!=arr[idx]){
                ret = Arrays.binarySearch(arr,findElement);
            }
            if(ret>=0){
                return true;
            }
        }
        return false;
    }
}




class findKthPositive {
    static public int fun1(int[] arr, int k) {
        // O(kLogN) solution....
        int n = arr.length;
        int currentMissing = 0;
        int currentCount = 0;
        int i = 1;
        while(true){
            int res = Arrays.binarySearch(arr,i);
            if(res<0){
                currentMissing = i;
                currentCount+=1;
            }
            if(currentCount==k){
                break;
            }
            i++;
        }
        return currentMissing;
    }



    static int fun2(int[] arr,int k){
        // log(N) solution ,,, *** revise it again ****
        int l = 0;
        int h = arr.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(arr[mid]-(mid+1)>k){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l+k;
    }
}


class InterSectionOfTwoSortedArray{
    static int[] fun1(int[] arr1,int[] arr2){
//       Wrong solution , do it when hashmap complete.
        int n1 = arr1.length;
        int n2 = arr2.length;
        if(n2<n1){
            return fun1(arr2,arr1);
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int idx=0;idx<n1;idx++){
            int ele1 = arr1[idx];
            for(int j = 0;j<n2;j++){
                int ele2 = arr2[j];
                if(ele1==ele2){
                    res.add(ele1);
                    break;
                }
            }
        }

        int[] finalRes = new int[res.size()];
        for(int k=0;k<res.size();k++){
            finalRes[k] = res.get(k);
        }
        return finalRes;
    }
}






class fairCandySwap {
    static public int[] fun1(int[] aliceSizes, int[] bobSizes) {
        // o(N2) solution.....
        int aliceSum = findSum(aliceSizes);
        int bobSum = findSum(bobSizes);
        int[] res = new int[2];
        for(int idx=0;idx<aliceSizes.length;idx++){
            int val1 = aliceSizes[idx];
            for(int j=0;j<bobSizes.length;j++){
                int val2 = bobSizes[j];
                int currentBobSum = bobSum - val2 + val1;
                int currentAliceSum = aliceSum - val1 + val2;
                if(currentAliceSum==currentBobSum){
                    res[0] = val1;
                    res[1] = val2;
                    break;
                }
            }
        }
        return res;
    }

    static int findSum(int[] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum = sum + arr[i];
        }
        return sum;
    }


    static public int[] fun2(int[] A, int[] B) {
        int dif = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;
        HashSet<Integer> S = new HashSet<>();
        for (int a : A) S.add(a);
        for (int b : B) if (S.contains(b + dif)) return new int[] {b + dif, b};
        return new int[0];
    }
}

//    Minimum Number of Days to Make m Bouquets
class MinimumNumberOfDaysToMakeMBouquets {
    static public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length){
            return -1;
        }
        // first find the min &max value in arr..
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int value=0;value<bloomDay.length;value++) {
            max = Math.max(bloomDay[value],max);
            min = Math.min(bloomDay[value],min);
        }
        while(min<=max){
            int mid = (min+max)/2;
            int bouquets = findBouquets(bloomDay,k,mid);

            if(bouquets==m){
                int midBouquets = findBouquets(bloomDay,k,mid-1);
                if(midBouquets==m){ // if in mid-1 also makes same bouque as m so will find in max = mid-1
                    max = mid-1;
                }else{
                    return mid;
                }
            }else if(bouquets<m){
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        return max+1;

    }

    static int findBouquets(int[] arr,int k,int day){
        int flow=0;int bouquets =0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<=day){
                flow++;
                if(flow==k) {
                    bouquets++;
                    flow = 0;
                }
            }else{
                flow = 0;
            }
        }
        return bouquets;

    }
}


class smallestDivisor {
    static public int fun1(int[] nums, int threshold) {
        // int max = Integer.MIN_VALUE;
        int min = 1, max = (int)1e6;
        // int min = Integer.MAX_VALUE;
        // for (int i = 0;i<nums.length;i++){
        // max = Math.max(nums[i],max);
        // min = Math.min(nums[i],min);
        // }
        while(min<max){
            int mid = (min+max)/2;
            int sum = findSum(nums,mid);
            if(sum>threshold){
                min = mid+1;
            }else{
                max=mid;
            }
        }
        return min;
    }
    static int findSum(int[] arr,int num){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum = sum +(arr[i]+num-1)/num;
        }
        return sum;
    }
}


class AllocateMinimumPages{
    static int fun1(int[] arr,int k){
        int max = arr[0];
        int sum = arr[0];
        for(int i=0;i<arr.length;i++){
            sum = sum+arr[i];
            max = Math.max(arr[i],max);
        }
        while(max<sum){
            int mid = (max+sum)/2;
            int students = HowManyStudentRequired(arr,mid);
            if(students>k){
                max = mid+1;
            }else{
                sum = mid;
            }
        }
        return max;
    }

    static int HowManyStudentRequired(int[] arr,int pages){
        // it will find no of student required for read all book on allocating pages
        int currentSum = 0;int studentRequired = 0;
        for(int i=0;i<arr.length;i++){
            currentSum = currentSum + arr[i];
            if(currentSum>pages){
                studentRequired++;
                currentSum = arr[i];
            }
        }
        return studentRequired+1;
    }
}




class shipWithinDays {
    public static int fun1(int[] weights, int days) {
        int right = 0;
        int left = 0;
        for(int i = 0;i<weights.length;i++){
            right = right + weights[i];
            left = Math.max(left,weights[i]);
        }
        // ship max capicity = sum of all packages weight
        // ship has min capicity = maximum package weight
        while(left<right){
            int mid = (left+right)/2;

            // find number of days required for this mid cap.
            int RequiredDays = 1; int currentSum = 0;
            for(int i=0;i<weights.length;i++){
                currentSum = currentSum + weights[i];
                if(currentSum>mid){ // if it will greater than only not on equal
                    RequiredDays++;
                    currentSum = weights[i];
                }
            }

            if(RequiredDays>days){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;

    }
}


class Solution4 {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1; int right = 1000000000;int ans;
        while(left<right){
            int mid = left +(right - left)/2;
            // find hours taken by koko to eat in speed mid;
            double requiredHr = 0.0;
            for(int i=0;i<piles.length;i++){
                int val = piles[i];
                requiredHr = requiredHr + Math.ceil((double) val/mid);
            }
            int required = (int) requiredHr;

            if(required>h){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}


//User function Template for Java

class findPeakElement {
    public static int fun1(List<Integer> a) {
        // Code here
        int n = a.size();
        if(n==1){
            return a.get(0);
        }
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = (start+end)/2;
            int peak = a.get(mid);

            if(mid==0){
                if(peak>a.get(mid+1)){
                    return peak;
                }else{
                    start = mid+1;
                }
            }else if(mid==n-1){
                if(peak>a.get(mid-1)){
                    return peak;
                }else{
                    end = mid-1;
                }
            }else{
                if(peak>a.get(mid+1) && peak>a.get(mid-1)){
                    return peak;
                }else{
                    if(peak<a.get(mid-1)){
                        end = mid-1;
                    }else if(peak<a.get(mid+1)){
                        start = mid+1;
                    }
                }
            }
        }
        return -1;
    }
}


class Solution5 {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        for(int i=0;i<n;i++){
            lis[i] = 1;
        }
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i] && lis[j]>=lis[i]){
                    lis[i] = lis[j]+1;
                }
            }
        }
        int max = lis[0];
        for(int k=1;k<n;k++){
            if(lis[k]>max){
                max = lis[k];
            }
        }
        return max;
    }
}




public class BinarySearchProblem {
    public static void main(String[] args){
        int[] arr = {7,7,7,7,7,7,7};
        int res = Solution5.lengthOfLIS(arr);
        System.out.println(res);

    }
}



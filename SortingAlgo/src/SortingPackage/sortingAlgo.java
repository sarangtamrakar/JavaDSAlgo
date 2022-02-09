package SortingPackage;


import java.util.ArrayList;
import java.util.Arrays;

class BubbleSortAlgo{
    static void fun1(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            boolean swapped = false;
            for(int j = 1;j<n-i;j++){
                int val1 = arr[j-1];
                int val2 = arr[j];
                if(val2<val1){
                    // then swap
                    arr[j] = val1;
                    arr[j-1] = val2;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}


class SeletionSort{
    static void fun1(int[] arr1){
        int n = arr1.length;
        for(int i = 0;i<n-1;i++){
            int minIdx=i;
            for(int j = i+1;j<n;j++){
                if(arr1[j]<arr1[minIdx]){
                    minIdx = j;
                }
            }
            int val1 = arr1[minIdx];
            int val2 = arr1[i];
            // swap them
            arr1[i] = val1;
            arr1[minIdx] = val2;
        }
    }
}



class InsertionSortAlgo{
    static void fun1(int[] arr1){
        int n = arr1.length;
        for(int i = 1;i<n;i++){
            int val1 = arr1[i];
            for(int j = i-1;j>=0;j--){
                int val2 = arr1[j];
                if(val1<val2){
                    arr1[j+1] = val2;
                    arr1[j] = val1;
                }else{
                    break;
                }
            }
        }
    }
}
class MergeTwoSortedArray {
    public static void fun1(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m;
        int n2 = n;
        int[] res = new int[n1+n2];
        int i = 0;int j = 0;int idx = 0;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                res[idx] = nums1[i];
                i++;
            }else{
                res[idx] = nums2[j];
                j++;
            }
            idx++;
        }

        while(j<n2){
            res[idx] = nums2[j];
            idx++;
            j++;
        }

        while(i<n1){
            res[idx] = nums1[i];
            idx++;
            i++;
        }

        for(int k=0;k<res.length;k++){
            nums1[k] = res[k];
        }
    }
}


class MergeSortFunction{

    static void fun2(int[] arr,int l , int h ,int m) {
        int n1 = m - l + 1;
        int n2 = h -m;
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];

        // copy element into sub array
        int i;
        for (i = 0; i < n1; i++) {
            a1[i] = arr[l + i];
        }


        for (i = 0; i < n2; i++) {
            a2[i] = arr[m + 1 + i];
        }

        // then merge into main arr
        i = 0;
        int j = 0;
        int idx = l; // IMP for merge sort recursion function
        while (i<n1 && j<n2){
            if(a1[i]<=a2[j]){
                arr[idx] = a1[i];
                i++;
                idx++;
            }else{
                arr[idx] = a2[j];
                j++;
                idx++;
            }
        }

        while(i<n1){
            arr[idx] = a1[i];
            i++;
            idx++;
        }

        while (j<n2){
            arr[idx] = a2[j];
            idx++;
            j++;
        }

    }
}



class MergeSortAlgorithm{
    static void fun1(int[] arr,int l , int r){
        if(l<r){
            int mid = (l+(r-l)/2);
            fun1(arr,l,mid);
            fun1(arr,mid+1,r);
            MergeSortFunction.fun2(arr,l,r,mid);
        }
    }
}


class InterSectionOfTwoSortedArray{
    static void fun1(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = 0; int j = 0;
        while(i<n1 && j<n2){

            // imp case to handle repetive element
            if(i>0 && arr1[i]==arr1[i-1]){
                i++;
                continue;
            }

            if(arr1[i] == arr2[j]){
                System.out.println(arr1[i]);
                i++;
                j++;
            }else if(arr1[i]>arr2[j]){
                j++;
            }else{
                i++;
            }
        }
    }
}


// find intersection in two unsorted array with repeative element...


class UnionOfTwoSortedArrayWithRepeatedElements{
    static void fun1(int[] a1,int[] a2){
        int n1 = a1.length;
        int n2 = a2.length;

        int i = 0; int j = 0;
        while (i<n1 && j<n2) {
            if (i > 0 && a1[i] == a1[i - 1]) {
                i++;
                continue; // continue very imp to check i index bound
            }

            if (a1[i] == a2[j]) {
                System.out.println(a1[i]);
                i++;
                j++;
            } else if (a1[i] < a2[j]) {
                System.out.println(a1[i]);
                i++;
            } else {
                System.out.println(a2[j]);
                j++;
            }
        }

        while(j<n2){
            System.out.println(a2[j]);
            j++;
        }

        while (i<n1){
                System.out.println(a1[i]);
                i++;
            }

    }
}

class intersection {
//    349. Intersection of Two Arrays
//
//    Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
//    Example 1:
//
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2]
//    Example 2:
//
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [9,4]
//    Explanation: [4,9] is also accepted.

    public static int[] fun1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0;i<n1;i++){
            if(i>0){
                // check if this element present in previous than num1[i] or not
                boolean ret = false;
                for(int k=0;k<i;k++){
                    if(nums1[k]==nums1[i]){
                        ret = true;
                        break;
                    }
                }
                if(ret){
                    continue;
                }
                for(int j = 0;j<n2;j++){
                    if(nums2[j]==nums1[i]){
                        result.add(nums1[i]);
                        break;
                    }
                }
            }else{

                for(int j = 0;j<n2;j++){
                    if(nums2[j]==nums1[i]){
                        result.add(nums1[i]);
                        break;
                    }
                }
            }
        }

        int[] finalResult = new int[result.size()];
        for(int m = 0;m<result.size();m++){
            finalResult[m] = result.get(m);
        }
        return finalResult;
    }
}



// find union of two unsorted array with repetive element...


class CountInversionInArray{
    // inversion is that when previous element is greater than next element

    // naive
    static void fun1(int[] arr){
        int count = 0;
        for(int i = 0;i<arr.length-1;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }


    static int fun2(int[] arr,int l,int r){
        int res = 0;
        if(r>l){
            int mid = (l+r)/2;
            res = res + fun2(arr,l,mid);
            res = res + fun2(arr,mid+1,r);
            res = res + CountMerge(arr,l,mid,r);
        }
        return res;
    }


    static int CountMerge(int[] arr,int l , int m , int r){

        // create two separate array....
        int n1 = m-l+1;
        int n2 = r-(m+1)+1;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for(int idx1 = 0;idx1<n1;idx1++){
            arr1[idx1] = arr[l+idx1];
        }

        for(int idx2 = 0; idx2<n2;idx2++){
            arr2[idx2] = arr[m+1+idx2];
        }

        // then apply mergesort
        int i = 0; int j = 0;
        int count  = 0; int k = l;
        while(i<n1 && j < n2){
            if(arr1[i]<=arr2[j]){
                arr[k] = arr1[i];
                i++;
            }else{
                arr[k] = arr2[j];
                j++;
                //****** main counter part****
                count = count + n1-i;
            }
            k++;
        }

        while(i<n1){
            arr[k] = arr1[i];
            k++;
            i++;
        }

        while(j<n2){
            arr[k] = arr[j];
            k++;
            j++;
        }
        return count;
    }
}



// Quick Sort Partitions.......
//  1. Naive partition
//  2. Lomuto partition
//  3. Hoare partition

class Partitions{
    static int[] NaivePartition(int[] arr,int l , int r, int p){
        int i = l; int j = r;
        int pivot = arr[p];
        int[] res = new int[r-l+1];
//        int res = 0;
        for(int k = 0; k<arr.length;k++){
            if(arr[k]<pivot){
                res[i] = arr[k];
                i++;
            }else if(arr[k]>pivot){
                res[j] = arr[k];
                j--;
            }else if(arr[k]==pivot && k!=p){
                res[i] = arr[k];
            }
        }
        res[i] = pivot;
        System.out.println(i);
        for(int idx = 0; idx<res.length;idx++){
            arr[idx] = res[idx];
        }
        return arr;
    }



    // ***** Lomuto Partition ****
    static int LomutoPartition(int[] arr,int l , int h){

        int i = l;
        int pivot = arr[h];
        for(int j = l;j<h;j++){
            if(arr[j]<pivot){
                int val1 = arr[j];
                int val2 = arr[i];
                // swap these two..
                arr[i] = val1;
                arr[j] = val2;
                i++;
            }
        }
        arr[h] = arr[i];
        arr[i] = pivot;
        return i;
    }

    static int Hoare(int[] arr, int l , int h){
        int i = 0; int j = h;
        int pivot = arr[l];
        while(true){

            while(arr[i]<pivot){
                i++;
            }

            while(arr[j]>pivot){
                j--;
            }

            // first check they have crossed each other or not beacause i , j incremented in upper code
            if(i>=j){
                break;
            }

            int val1 = arr[i];
            int val2 = arr[j];
            arr[i] = val2;
            arr[j] = val1;
            i++;
            j--;
        }
        return j;
    }
}



class QuicksortUsingLomutoPartiton{
    static void fun1(int[] arr,int l , int h){
        if(l<h){
            int p = Partitions.LomutoPartition(arr,l,h);
            fun1(arr,l,p-1);
            fun1(arr,p+1,h);
        }
    }
}

class QuicksortUsingHoarepartition{
    static void fun1(int[] arr, int l ,int h){
        if(l<h) {
            int pivot = Partitions.Hoare(arr, l, h);
            fun1(arr, l, pivot);
            fun1(arr, pivot + 1, h);
        }
    }
}


class FindKthSmallestElementInArray{
    static int fun1(int[] arr,int k){
        // we will use Lomuto's Partition
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int p = Partitions.LomutoPartition(arr,l,r); // it will give index after partition
            if(p==k-1){
                return arr[p];
            }else if(p<k-1){
                l = p+1;
            }
            else{
                r = p-1;
            }
        }
        return -1;
    }
}

class ChocoletDistributionProblem{
    static int fun1(int[] arr, int k){
        int n = arr.length;
        if(k>n){
            return -1;
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n-(k-1);i++){
            int diff = arr[i+k-1] - arr[i];
            min = Math.min(diff,min);
        }
        return min;
    }
}


class FindKthLargestElementInArray{
    static int fun1(int[] arr,int k){
        // we will use Lomuto's Partition
        int l = 0;
        int r = arr.length-1;
        int n = arr.length;
        while(l<=r){
            int p = Partitions.LomutoPartition(arr,l,r); // it will give index after partition
            if(p==n-k){
                return arr[p];
            }else if(p<n-k){
                l = p+1;
            }
            else{
                r = p-1;
            }
        }
        return -1;
    }
}


// sort the array having 2 types of elements


// sort the array having three types of elements
class SortTheArrayHavingThreeTypesOfElements{
    // sort the array having 0 , 1, 2
    static void fun1(int[] arr){
        // i for zero , j for iteration , k for twos
        int i = 0; int j = 0 ; int k = arr.length-1;
        while(j<=k){  // very good comparision Dutch partition algorithms
            if(arr[j]==0){
                int val1 = arr[j];
                int val2 = arr[i];
                arr[i]  = val1;
                arr[j] = val2;
                i++;
                j++;
            }
            else if(arr[j] ==2){
                int val3 = arr[j];
                int val4 = arr[k];
                arr[k] = val3;
                arr[j] = val4;
                k--;
                //j++; Edge case never do j++ here**********************
                //[0,1,0,2,1,2] case dry run it to understand
            }
            else{
                j++;
            }

        }
    }
}




class ThreeWayPartitioning{
    static void fun1(int[] arr,int p){
        int i=0 ; int j=0 ; int k = arr.length-1;
        while (j<=k){
            if(arr[j]==p){
                j++;
            }else if(arr[j]<p){
                int v1 = arr[j];
                int v2 = arr[i];
                arr[j] = v2;
                arr[i] = v1;
                j++;
                i++;
            }else{
                int v3 = arr[j];
                int v4 = arr[k];
                arr[k] = v3;
                arr[j] = v4;
                k--;
                //j++; don't do this here
            }
        }
    }
}


class MinimumDifferenceInArray{

    // ****** Naive approach O(N2) *******
    static int fun1(int[] arr){
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                int diff = Math.abs(arr[i]-arr[j]);
                min = Math.min(diff,min);
            }
        }
        return min;
    }

    static int fun2(int[] arr){
        // adjust the elements surround the it's closest numbers
        // then compare the adjacents
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<arr.length;i++){
            int diff = Math.abs(arr[i]-arr[i-1]);
            min = Math.min(diff,min);
        }
        return min;
    }
}


//class MergeIntervals {
//    pair<Integer, Integer> p = new pair<Integer, Integer>();
//
//}


class MeetingTheMaximumGuests{
    static int fun1(int[] arr,int[] dep){
        // efficient approach
        // maxGuest = 0
        // int res = 0 ; int i = 0 ; int j = 0;   ==> i for arr , j for dep
        // 1. we will sort arrival & departure array then
        // 2. then compare if arr[i] is less than dep[j] res++; i++;
        // 3. else res--; j++;
        // also maintain maxGuest = Math.max(res,maxGuest)

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0; int j = 0; int res = 0;int MaxGuest = 0;
        while(i<arr.length && j<dep.length){
            if(arr[i]<dep[j]){
                res++;
                i++;
                MaxGuest = Math.max(MaxGuest,res);
            }else{
                res--;
                j++;
            }
        }
        return MaxGuest;
    }
}



class CycleSortAlgorithmsForDistinctElements{
    static void fun1(int[] arr){
        for(int cs = 0 ; cs<arr.length-1;cs++){
            int pos = cs; // initialize with its current position
            // count how many elemnts less than this element
            int item = arr[pos];
            for(int i = pos+1;i<arr.length;i++){
                if(arr[i]<item){
                    pos++;
                }
            }

            int temp = arr[pos];
            arr[pos] = item;
            item = temp;

            while(cs!=pos){
                pos = cs;
                for(int j=pos+1;j<arr.length;j++){
                    if(arr[j]<item){
                        pos++;
                    }
                }

                if(arr[pos]!=item){
                    temp = arr[pos];
                    arr[pos] = item;
                    item = temp;
                }
            }
        }
    }
}


class CycleSort{
    static void fun1(int[] arr){
        for(int cs= 0 ; cs<arr.length-1; cs++) {
            int pos = cs;
            int item = arr[pos];
            // count how many elements are less than item on right side
            for(int i= pos+1;i<arr.length;i++){
                if(arr[i]<item){
                    pos++;
                }
            }

            if(pos!=cs){
                int temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }

            // set another elemets on corect position in cycle manner until pos reaches again cs
            while(pos!=cs){
                pos = cs;

                // again count number elements less than item on right of cs
                for(int j = pos+1;j<arr.length;j++){
                    if(arr[j]<item){
                        pos++;
                    }
                }
                if(arr[pos]!=item){  // element on reached pos is not equal to item than only assign
                    int temp2 = arr[pos];
                    arr[pos] = item;
                    item = temp2;
                }
            }
        }
    }
}


class CountSortAlgorithm{
    static void fun1(int[] arr,int k){
        // make a empty counting arr of size k which is number of distinct elements are there
        int[] countarr = new int[k];

        // filling the counting arr
        for(int i = 0;i<k;i++){
            for(int j = 0;j<arr.length;j++){
                if(arr[j]==i){
                    countarr[i]++;
                }
            }
        }

        // copy elements into the original arr based on counting;
        int idx3 = 0;
        for(int idx1 = 0;idx1<countarr.length;idx1++){
            for(int idx2=0;idx2<countarr[idx1];idx2++){
                arr[idx3] = idx1;
                idx3++;
            }
        }
    }
}


public class sortingAlgo {
    public static void main(String[] args){
        System.out.println("Hello Sorting Algorithms");
        int[] arr1 = {1,4,4,3,0,1,1};
        int[] arr2 = {1000,800,730};
        CountSortAlgorithm.fun1(arr1,5);
//        System.out.println(min);
        System.out.println(Arrays.toString(arr1));
//        System.out.println(res);
    }
}



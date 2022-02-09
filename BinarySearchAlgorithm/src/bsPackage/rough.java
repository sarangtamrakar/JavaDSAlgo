package bsPackage;


import java.util.Arrays;

public class rough {
    public static void main(String[] args) {
        // find the square root
        int[] arr1 = {1,0,1,1,1};
        int res = fun1(arr1,0);
        System.out.println(res);
    }

    static int fun1(int[] arr1 ,int x){
        int n = arr1.length;
        if(n==1){
            if(arr1[0]==x){
                return 0;
            }else return -1;
        }

        int l = 0;int h = n-1;
        while(l<=h){
            int mid = (l+(h-l)/2);
            if(arr1[mid]==x){
                return mid;
            }
            // check left half is sorted or not
            else if(arr1[mid]>=arr1[l]){
                // check whether x lies in this range or not;
                if(x>=arr1[l] && x<arr1[mid]){
                    h = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                if(x>arr1[mid] && x<=arr1[h]){
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }
        }
        return -1;

    }
}




class Solution7 {
    public boolean search(int[] nums, int target) {

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

            // most Imp case to Handle non distinct elements...
            if(nums[mid]==nums[l] && nums[mid]==nums[h]){
                l++;
            }

            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] >= nums[l]) {  // this equal is very IMP [3,1] find 1 test case
                if (target < nums[mid] && target >= nums[l]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target>nums[mid] && target <= nums[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return false;
    }
}
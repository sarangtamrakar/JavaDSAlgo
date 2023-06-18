package SortingPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class Basic {
    public static void main(String[] args){
//        int[] arr1 = {20,40,10,30};


        // ****** Arrays.sort()******* in java

//        // sort the array  in fix order
//        Arrays.sort(arr1,1,3); // fromindex inclusive & toindex is exclusive
//        System.out.println(Arrays.toString(arr1));
//
//        // sort the complete array
//        Arrays.sort(arr1);
//        System.out.println(Arrays.toString(arr1));

//        // wrapper class which is non-primitive
//        Integer[] a1= {400,30,40};
//        Arrays.sort(a1,Collections.reverseOrder());
//        System.out.println(Arrays.toString(a1));
//
//        // convert the int[] to Integer[] array
//        int[] arr2 = {10,20,30};
//        Integer[] a2 = new Integer[arr2.length];
//        for(int i=0;i<arr2.length;i++){
//            int val = arr2[i];
//            a2[i] = val;
//        }
//        System.out.println(Arrays.toString(arr2));
//        System.out.println(Arrays.toString(a2));




        // ******** Collection.sort() in java************
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(10);
        arr1.add(20);
        arr1.add(-1);

        // incresing order sorting
        Collections.sort(arr1);
        System.out.println(arr1);


        // decresing order sorting

        // 1st way..
        Collections.sort(arr1,Collections.reverseOrder());
        System.out.println(arr1);

        // 2nd way.. arr1.sort(Must Need Comparator)
        arr1.sort(Collections.reverseOrder());


    }
}

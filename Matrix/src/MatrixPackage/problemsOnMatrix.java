package MatrixPackage;



// Basic Questions of Matrix

import java.util.Arrays;

class PrintMatrixInSnakePattern{
    static void fun1(int[][] mat){

        for(int r = 0 ; r<mat.length;r++){

            if(r%2==0){ // if it is even so traverse through the start
                for(int c=0;c<mat[r].length;c++){
                    System.out.println(mat[r][c]);
                }
            }else{  // if r index is odd so traverse through the end
                for(int c= mat[r].length-1;c>=0;c--){
                    System.out.println(mat[r][c]);
                }
            }
            System.out.println();
        }
    }
}


class PrintBoundryPattern{
    static void fun1(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;
        int i; int j;

        // handle only one row case  & handle only one column case
        if(r == 1){
            for(i = 0;i<c;i++){
                System.out.println(arr[0][i]);
            }
        }else if(c==1){
            for(j = 0; j<r;j++){
                System.out.println(arr[j][0]);
            }
        }else {
            // print first row
            for (i = 0; i < c; i++) {
                System.out.println(arr[0][i]);
            }

            // print last column from 2nd row
            for (j = 1; j < r; j++) {
                System.out.println(arr[j][c - 1]);
            }

            // print bottom row;
            for (i = c - 2; i >= 0; i--) {
                System.out.println(arr[r - 1][i]);
            }

            // print first column
            for (j = r - 2; j > 0; j--) {
                System.out.println(arr[j][0]);
            }
        }
    }
}


class TransposeOfMatrix{

    // Naive solution using n*n extra space
    static void fun1(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;
        int i ; int j;

        int[][] res = new int[r][c];

        for(i= 0 ;i<r;i++){
            for(j = 0 ; j<c;j++){
                res[j][i] = arr[i][j];
            }
        }

        for(i= 0 ;i<r;i++) {
            for (j = 0; j < c; j++) {
                System.out.println(res[i][j]);
            }
            System.out.println();
        }
    }



    // Efficient Solution
    // here diagonal elements are same so we will not swap them,
    // we will only swap one side of diagonal to second side of diagonal
    static void fun2(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;
        int i; int j;
        if(r==c){
            for(i = 0;i<r-1;i++){
                for(j = i+1;j<c;j++){
                    // swap anti diagonal elements
                    int val1 = arr[i][j];
                    int val2 = arr[j][i];
                    arr[i][j] = val2;
                    arr[j][i] = val1;
                }
            }

            // print transpose matrix
            for(i = 0; i<r;i++){
                for(j= 0; j<c;j++){
                    System.out.println(arr[i][j]);
                }
                System.out.println();
            }

        }
    }

}



class RotateMatrixByNINTYDegree{

    // clock wise
    static void fun1(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;
        // create blank matrix
        int[][] res = new int[c][r];


        // rotate matrix
        for(int i = 0;i<r;i++){
            for(int j=0;j<arr[i].length;j++){
//                res[arr[i].length-1-j][i] = arr[i][j];
                res[j][r-1-i] = arr[i][j];
            }
        }

        // print res matrix
        for(int i = 0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.println(res[i][j]);
            }
            System.out.println();
        }
    }


    // Anti clock wise
    static void fun2(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;

        int[][] res = new int[c][r];


        for(int i = 0;i<r;i++){
            for(int j=0;j<arr[i].length;j++){
//                res[arr[i].length-1-j][i] = arr[i][j];
                res[c-1-j][i] = arr[i][j];
            }
        }

        for(int i = 0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.println(res[i][j]);
            }
            System.out.println();
        }
    }

    // anti-clock wise naive approach
    static void optimisedAntiClockWise(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;
        int i; int j;

        // first transpose the matrix
        for(i =0;i<r;i++){
            for(j = i+1;j<c;j++){
                int val1 = arr[i][j];
                int val2 = arr[j][i];
                arr[i][j] = val2;
                arr[j][i] = val1;
            }
        }

        // now reverse the rows
        for(i=0;i<r;i++){
            int l = 0; int h = r-1;
            while(l<h){
                int val1 = arr[l][i];
                int val2 = arr[h][i];
                arr[l][i] = val2;
                arr[h][i] = val1;
                h--;
                l++;
            }
        }

        // print matrix
        for(i =0;i<r;i++){
            for(j = 0;j<c;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}



// solve reverse the columns
class ReverseTheColumns{
    static void fun1(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;
        int i;

        // reverse the columns
        for(i=0;i<r;i++){
            int l = 0; int h = c-1;
            while(l<h){
                int val1 = arr[i][l];
                int val2 = arr[i][h];
                arr[i][l] = val2;
                arr[i][h] = val1;
                l++;
                h--;
            }
        }

        // print reverse column matrix
        for(i = 0 ;i<r;i++){
            for(int j = 0 ; j<c;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}


// solve reverse columns
class ReverseTheRows{
    static void fun1(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;

        // reverse rows
        int i;
        for(i=0;i<c;i++){
            int l = 0; int h = r-1;
            while(l<h){
                int val1 = arr[l][i];
                int val2 = arr[h][i];
                arr[l][i] = val2;
                arr[h][i] = val1;
                l++;
                h--;
            }
        }

        for(i=0;i<r;i++){
            for(int j = 0;j<c;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}


// Revise it again
class PrintSpiralMatrix{
    static void fun1(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;

        int l=0; int r=cols-1; int t=0; int b=rows-1;

        while(l<=r && t<=b){
            int i ; int j;
            // print top row

            for(i=l;i<=r;i++){
                System.out.print(arr[t][i]);
            }
            t++;

            // print right column

            for (j = t; j <= b; j++) {
                System.out.print(arr[j][r]);
            }

            r--;

            // print last row;
            if(l<=r) {
                for (i = r; i >= l; i--) {
                    System.out.print(arr[b][i]);
                }
                b--;
            }



            // print first column
            if(t<=b) {
                for (j = b; j >=t; j--) {
                    System.out.print(arr[j][l]);
                }
                l++;
            }

        }
    }
}


class SearchInRowWiseAndColumnWiseSortedArray{

    // Naive Approach simple iterate through each elements of matrix
    // O(r*c) solution
    static boolean fun1(int[][] arr, int k){
        int r = arr.length;
        int c = arr[0].length;

        for(int i = 0;i<r;i++){
            for(int j = 0 ; j<c;j++){
                if(k==arr[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    // optimised approach
    // In This approach we will  start searching with (0,c-1) & after that we will
    // if element to be search is less than we will go left (c--) otherwise we will go down (r++);
    static void fun2(int[][] arr, int k){
        int r = arr.length;
        int c = arr[0].length;
        int i = 0; int j = c-1;
        while(i<r && j>=0){
            if(k==arr[i][j]){
                System.out.println(i);
                System.out.println(j);
                break;
            }else if(k<arr[i][j]){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("Not Found");
    }
}



class MedianOfRowWiseSortedArray{
    // Naive solution
    // 1. First copy all matrix elements in array & sort the array & then return middle elements
    // r*cLog(r*c) time & r*c aux space

    // efficient Solution use binary search
    // find min & max in array ==> min  find in (all rows , 0 column)  ===> max find in (all rows,c-1 column)
    static int fun2(int[][] arr){

        int rows = arr.length;
        int cols = arr[0].length;
        // first find min & max
        int Min = Integer.MAX_VALUE; int Max = Integer.MIN_VALUE;
        for(int i=0;i<rows;i++){
            Max = Math.max(Max,arr[i][cols-1]);
            Min = Math.min(Min,arr[i][0]);
        }

        int medianIdx = (rows*cols+1)/2;

        while(Min<=Max){
            int mid = (Min+Max)/2;

            // count how many elements are less or equal to mid (find index of mid)
            int midIdx = 0;
            for(int i = 0 ; i<rows;i++){
                midIdx += Math.abs(Arrays.binarySearch(arr[i],mid)+1);
            }

            if(midIdx==medianIdx){
                return mid;
            }
            else if(midIdx>medianIdx){
                Max = mid-1;
            }else{
                Min = mid+1;
            }
        }
        return -1;
    }




    static int fun3(int[][] arr){

        int rows = arr.length;
        int cols = arr[0].length;
        // first find min & max
        int Min = Integer.MAX_VALUE; int Max = Integer.MIN_VALUE;
        for(int i=0;i<rows;i++){
            Max = Math.max(Max,arr[i][cols-1]);
            Min = Math.min(Min,arr[i][0]);
        }

        int medianIdx = (rows*cols+1)/2;

        while(Min<Max){
            int mid = (Min+Max)/2;

            // count how many elements are less or equal to mid (find index of mid)
            int midIdx = 0;
            for(int i = 0 ; i<rows;i++){
                midIdx += Math.abs(Arrays.binarySearch(arr[i],mid)+1);
            }


            if(midIdx<medianIdx){
                Min = mid+1;
            }else{
                Max = mid;
            }
        }
        return Max;
    }
}


public class problemsOnMatrix {
    public static void main(String[] args){
        int[][] mat = {{1,2},{1,7}};

        int res = MedianOfRowWiseSortedArray.fun3(mat);
        System.out.println(res);
    }
}

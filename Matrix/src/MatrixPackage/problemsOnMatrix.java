package MatrixPackage;



// Basic Questions of Matrix

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




public class problemsOnMatrix {
    public static void main(String[] args){
        int[][] mat = {{1,2,3},{4,5,6}};
        ReverseTheRows.fun1(mat);
    }
}
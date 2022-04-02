package MatrixPackage;

public class rough {
    public static void main(String[] args){
        System.out.println("Hello Matrix in java");
        int[][] mat = {{1,2,3},{4,5,6},{8,9,10}};
        reverseRows(mat);
    }


    static void printSnakepattern(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;

        for(int i = 0;i<r;i++){
            if(i%2==0){
                for(int j = 0; j<c;j++){
                    System.out.println(arr[i][j]);
                }
            }else{
                for(int j = c-1;j>=0;j--){
                    System.out.println(arr[i][j]);
                }
            }
        }
    }

    static void printBoundryPattern(int[][] arr){
        // print upper row
        int rows = arr.length;
        int cols = arr[0].length;
        int i ; int j;


        if(rows==1){
            // print first row
            for(i = 0;i<cols;i++){
                System.out.println(arr[0][i]);
            }
        }else if(cols==1){
            for(j = 0;j<rows;j++){
                System.out.println(arr[j][0]);
            }
        }else {

            // print first row
            for (i = 0; i < cols; i++) {
                System.out.println(arr[0][i]);
            }

            // print last column
            for (j = 1; j < rows; j++) {
                System.out.println(arr[j][cols - 1]);
            }

            // print last row
            for (i = cols - 2; i >= 0; i--) {
                System.out.println(arr[rows - 1][i]);
            }

            // print first col
            for (j = rows - 2; j > 0; j--) {
                System.out.println(arr[j][0]);
            }
        }
    }

    static void TransposeOfMatrix(int[][] arr){
        // naive approach
        int rows = arr.length;
        int cols = arr[0].length;
        int i ; int j;

        int[][] aux = new int[cols][rows];

        for(i = 0; i<rows;i++){
            for(j = i+1; j<cols;j++){
                int val1 = arr[i][j];
                int val2 = arr[j][i];
                arr[i][j] = val2;
                arr[j][i] = val1;
            }
        }

        for(i = 0; i<rows;i++){
            for(j = 0; j<cols;j++){
                System.out.println(arr[i][j]);
            }
        }
    }


    static void rotateMatrixAnticlockwise(int[][] arr){
        // Naive method
        int rows = arr.length;
        int cols = arr[0].length;
        int i ; int j;

        int[][] aux = new int[cols][rows];

        for(i = 0; i<rows;i++){
            for(j = 0;j<cols;j++){
                aux[cols-1-j][i] = arr[i][j];
            }
        }

        for(i = 0; i<rows;i++){
            for(j = 0;j<cols;j++){
                System.out.println(aux[i][j]);
            }
        }
    }

    static void reverseColumns(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;
        int i = 0 ; int j = cols-1;

        while(i<j){
            for(int k = 0; k<rows;k++){
                int val1 = mat[k][i];
                int val2 = mat[k][j];
                mat[k][i] = val2;
                mat[k][j] = val1;
            }
            i++;
            j--;
        }

        for(i=0;i<rows;i++){
            for(j=0;j<cols;j++){
                System.out.println(mat[i][j]);
            }
            System.out.println();
        }

    }


    static void reverseRows(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;
        int i=0; int j=rows-1;

        while(i<j){
            for(int k = 0; k<cols;k++){
                int val1 = arr[i][k];
                int val2 = arr[j][k];
                arr[i][k] = val2;
                arr[j][k] = val1;
            }
            i++;
            j--;
        }

        for(i = 0; i<rows;i++){
            for(j=0;j<cols;j++){
                System.out.println(arr[i][j]);
            }
        }
    }
}

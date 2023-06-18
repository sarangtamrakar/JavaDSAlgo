package MatrixPackage;

public class basicMatrix {
    public static void main(String[] args){
        System.out.println("Hello Matrix");


        // 1st way:-  Initialized the matrix in the java with zeroes
        int[][] mat = new int[2][3];    // 2 row 3 column

        for(int row = 0 ; row<mat.length;row++){
            for(int col = 0;col<mat[row].length;col++){
                mat[row][col] = 10;
                System.out.print(mat[row][col]);
            }
            System.out.println();
        }



        // 2nd Way:-  Initialized the matrix in java 2md way;
        int[][] mat2 = {{10,10,10},{10,10,10,10,10}};
        for(int i = 0 ;i<mat2.length;i++){
            for(int j=0;j<mat2[i].length;j++){
                System.out.print(mat2[i][j]);
            }
            System.out.println();
        }



        // create Jacket Matrix defined only number of rows while creating
        int[][] mat3 = new int[3][];
        for(int r=0;r<mat3.length;r++){
            mat3[r] = new int[r+1];
            for(int c=0;c<mat3[r].length;c++){
                mat3[r][c] = r;
                System.out.print(mat3[r][c]);
            }
            System.out.println();
        }
    }
}







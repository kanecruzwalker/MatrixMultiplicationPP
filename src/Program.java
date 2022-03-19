public class Program {
    public static void main(String[] args) {
        //Dimension of matrices in use
        int rowAndCol = 4;

        //Program Matrices into code

        //2 Matrices to be used
        int[][] matrixA = {{1,0,0,1},{0,1,0,1},{0,0,1,0},{1,1,1,0}};
        int[][] matrixB = {{0,1,1,1},{1,1,0,1},{0,1,0,1},{1,0,1,0}};

        //Get Matrix of 2 matrices multiplied (Product of two patrices)
        int[][] newMatrix = getMultipliedMatrices(matrixA, matrixB, rowAndCol);

        //Output new matrix created when multiplying 2 matrices
        displayProduct(newMatrix);


        //------------To Do
        //Output number of connections within the directed graph being depicted
        //Get User Input as well as hard coded
    }

    //Pass 2 Matrices return a Matrix of the product
    public static int[][] getMultipliedMatrices(int[][] matrixA, int[][] matrixB, int rowAndColLength){
        int[][] resultingMatrix = new int[rowAndColLength][rowAndColLength];
        for(int i = 0; i < rowAndColLength; i++){
            for(int j = 0; j < rowAndColLength; j++){
                for(int k = 0; k < rowAndColLength; k++){
                    resultingMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return resultingMatrix;
    }

    //Display a Matrix
    public static void displayProduct(int[][] product){
        System.out.println("Product of two matrices is: ");
        for(int[] row : product){
            for(int column : row){
                System.out.print(column + "   ");
            }
            System.out.println();
        }
    }
}

//Big thanks to the following :
//https://www.programiz.com/java-programming/examples/multiply-matrix-function
//https://www.youtube.com/watch?v=sxHRXwXhpRI
//https://mathbits.com/MathBits/Java/arrays/Matrices.htm

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //------------To Do
        //Understand the logic of connections and implement in java
        //Allow user to input a matrix of their choice

        //Dimension of matrices in use
        int rowAndCol = 4;
        //2 Matrices to be used
        int[][] matrixA = {{1,0,0,1},{0,1,0,1},{0,0,1,0},{1,1,1,0}};
        int[][] matrixB = {{0,1,1,1},{1,1,0,1},{0,1,0,1},{1,0,1,0}};

        //Get Matrix of 2 matrices multiplied (Product of two matrices)
        int[][] newMatrix = getMultipliedMatrices(matrixA, matrixB, rowAndCol);
        //Get Number of Connections
        int numberOfConnections = getConnectionsInMatrix(newMatrix);

        initialGreeting();
        runProgram(newMatrix, numberOfConnections);
    }

    public static void initialGreeting(){
        System.out.println("-------------Welcome to Matrix Connections-------------");
        System.out.println("        -We have provided a Matrix A and B-");
        System.out.println("-Please input integer values to navigate the program-\n");
    }

    public static void runProgram(int[][] matrix, int connections){
        int menuChoice;

        while(true){
            programMenu();
            menuChoice = getMenuChoice();
            switch (menuChoice){
                case 1:
                    System.out.println("\nYou have chosen ("+menuChoice+") : The product of Matrix A and B is as follows : ");
                    //Output new matrix created when multiplying 2 matrices
                    displayProduct(matrix);
                    break;
                case 2:
                    System.out.println("\nYou have chosen ("+menuChoice+") : The number of Connection in the Matrix C"i);
                    //Output number of connections in matrix
                    displayConnections(connections);
                    break;
                case 3:
                    System.out.println("\nYou have chosen ("+menuChoice+") -Inputting your own matrix-");
                    System.out.println("Working on matrix input ability");
                    break;
                case 4:
                    System.out.println("\nYou have chosen (" + menuChoice + ") -Exit Program-");
                    System.out.println("=====================================================================");
                    System.out.println("Thank you for using the program. I hope you enjoyed the experience :D");
                    System.out.println("=====================================================================");
                    System.exit(0);
                    //default case to display the message invalid choice made by the user
                default:
                    System.out.println("::Error Occurred :: Need Valid input number (1-4). \\n\\n");
            }
        }
    }

    public static int getMenuChoice(){
        Scanner menuInput = new Scanner(System.in);
        String stringInput;
        boolean done = false;
        int menuIntChoice = 0;

        while(!done){
            System.out.print("Enter your input here : ");
            stringInput = menuInput.nextLine();
            try{
                menuIntChoice = Integer.parseInt(stringInput);
                if(menuIntChoice < 1 || menuIntChoice > 4){
                    System.out.println(":::ERROR::: Please input a number 1-4");
                    continue;
                }
                done = true;
            }
            catch(Exception e){
                System.out.println(":::ERROR::: Please input Number");
            }
        }
        return menuIntChoice;
    }

    public static void programMenu(){
        System.out.println("---------------Input One of the following--------------");
        System.out.println("(1) Check the Product of Two Matrices");
        System.out.println("(2) Check the number of Connections in a Matrix");
        System.out.println("(3) Input 2 Matrices");
        System.out.println("(4) Exit Program");
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

    //Pass 1 matrics, return an int number of connections
    public static int getConnectionsInMatrix(int[][] matrixIn){
        //Return value, set to -9 to establish value
        int intOut = -9;
        //calculate connections
        //set intOut = connectionsCount
        return intOut;
    }

    //Display a Matrix
    public static void displayProduct(int[][] product){
        System.out.println("A x B = C\nC:" +
                "");
        for(int[] row : product){
            for(int column : row){
                System.out.print(column + "   ");
            }
            System.out.println();
        }
    }

    //Display Connections
    public static void displayConnections(int connectionIn){
        System.out.println(connectionIn +" connections found in matrix C (The product of matrix A and B)");
    }



    //int[][] userMatrix1 = getMatrixFromUser();
    //---Work Towards User Inputed Data---
    //int[][] userMatrix2 = getMatrixFromUser();
    //int[][] usersMatrixProduct = getMultipliedMatrices(userMatrix1, userMatrix2, rowAndCol);
    //int numberOfConnectionsUserInput = getConnectionsInMatrix(usersMatrixProduct);
    //displayInputedMatrix1(userMatrix1);
    //displayConnections(numberOfConnectionsUserInput);
    //--------------------

//
//    public static int[][] getMatrixFromUser(){
//       int[][] outputMatrix = {{-2,-4},{-2,-4},{-2,-4},{-2,-4},{-2,-4}};
//       //set outputMatrix = getMatrixValues
//        //Scanner
//        //Loop , try catch , validate non valid
//
//        return outputMatrix;
//    }

//    //Display a MatrixInputed
//    public static void displayInputedMatrix1(int[][] product){
//        System.out.println("Product of two matrices is: ");
//        for(int[] row : product){
//            for(int column : row){
//                System.out.print(column + "   ");
//            }
//            System.out.println();
//        }
//    }
}

//Big thanks to the following :
//https://www.programiz.com/java-programming/examples/multiply-matrix-function
//https://www.youtube.com/watch?v=sxHRXwXhpRI
//https://mathbits.com/MathBits/Java/arrays/Matrices.htm

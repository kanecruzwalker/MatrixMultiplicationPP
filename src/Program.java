import java.util.Scanner;

public class Program {
    //Initial Program Greeting
    public static void initialGreeting(){
        System.out.println("-------------Welcome to Matrix Connections-------------");
        System.out.println("        -We have provided a Matrix A and B-");
        System.out.println("-Please input integer values to navigate the program-");
    }

    //Display Program Menu
    public static void programMenu(){
        System.out.println("\n---------------Input One of the following--------------");
        System.out.println("(1) Check the Product of Two Matrices");
        System.out.println("(2) Check the number of Connections in a Matrix");
        System.out.println("(3) Input 2 Matrices");
        System.out.println("(4) Exit Program");
    }
    
    //Main Function
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
        int[][] matrixC = getMultipliedMatrices(matrixA, matrixB, rowAndCol);
        //Get Number of Connections
        int numberOfConnections = getConnectionsInMatrix(matrixC);


        //Program Starts Here
        initialGreeting();
        runProgram(matrixC, numberOfConnections, matrixA, matrixB);
    }


    //Program Initiation
    public static void runProgram(int[][] matrix, int connections, int[][] matrixA, int[][] matrixB){
        //Users menu choice
        int menuChoice;

        //Program Operates under these conditions
        while(true){
            //Display Program Menu
            programMenu();
            //Get Users Choice
            menuChoice = getMenuChoice();

            //Based on selection, program does the following
            switch (menuChoice){

                //Resultant when you multiply 2 matrices
                case 1:
                    System.out.println("\nYou have chosen ("+menuChoice+") : The cross product of Matrix A and B is as follows : ");
                    //Output resultant matrix when multiplying 2 matrices
                    System.out.println("Matrix A:");
                    displayMatrix(matrixA);
                    System.out.println("Matrix B:");
                    displayMatrix(matrixB);
                    //Display C
                    displayMatrixCofAXB(matrix);
                    break;
                // Number of connections in Matrix
                case 2:
                    System.out.println("\nYou have chosen ("+menuChoice+") : The number of Connection in the Matrix C : ");
                    //Output number of connections in matrix
                    displayConnections(connections);
                    break;
                // Input Unique Matrices
                case 3:
                    System.out.println("\nYou have chosen ("+menuChoice+") -Inputting your own matrices-");
                    System.out.println(":::Functionality under construction:::");
                    break;
                // Exit Program
                case 4:
                    System.out.println("\nYou have chosen (" + menuChoice + ") -Exit Program-");
                    System.out.println("=====================================================================");
                    System.out.println("Thank you for using the program. I hope you enjoyed the experience :D");
                    System.out.println("=====================================================================");
                    System.exit(0);
                    //default case to display the message invalid choice made by the user
                default:
                    System.out.println("::Error Occurred :: Please contact development. \\n\\n");
            }
        }
    }

    //Get Main Menu Choice
    public static int getMenuChoice(){
        //Variables Used
        Scanner menuInput = new Scanner(System.in);
        String stringInput;
        boolean done = false;
        int menuIntChoice = 0;

        //Iterate until we declare valid input
        while(!done){
            //Get user input
            System.out.print("Enter your input here : ");
            stringInput = menuInput.nextLine();

            //Validate numbers 1-4 as only valid input
            try{
                menuIntChoice = Integer.parseInt(stringInput);
                if(menuIntChoice < 1 || menuIntChoice > 4){
                    System.out.println(":::ERROR::: Please input a number 1-4");
                    continue;
                }
                done = true;
            }
            catch(Exception e){
                System.out.println(":::ERROR::: Please input a number 1-4");
            }
        }
        return menuIntChoice;
    }

    //Pass 2 Matrices return a Matrix of the product (A X B = C) a , b in, c out
    public static int[][] getMultipliedMatrices(int[][] matrixA, int[][] matrixB, int rowAndColLength){
        int[][] resultingMatrix = new int[rowAndColLength][rowAndColLength];

        //Multiply 2 matrices
        for(int i = 0; i < rowAndColLength; i++){
            for(int j = 0; j < rowAndColLength; j++){
                for(int k = 0; k < rowAndColLength; k++){
                    //Set product matrix based on A and B
                    resultingMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        //Return matrix C
        return resultingMatrix;
    }

    //Pass 1 matrices, return an int number of connections
    public static int getConnectionsInMatrix(int[][] matrixIn){
        int count = 0;

        //Add all values to count while iterating over MatrixIn
        for(int[] innerArray : matrixIn){
            for(int val: innerArray){
                count = count+val;
            }
        }
        return count;
    }

    //Display a Matrix
    public static void displayMatrixCofAXB(int[][] product){
        System.out.println("" +
                "Matrix C = (A x B):");

        //Display Matrix
        for(int[] row : product){
            for(int column : row){
                System.out.print(column + "   ");
            }
            System.out.println();
        }
    }

    //Display Matrix
    public static void displayMatrix(int[][] product){
        for(int[] row : product){
            for(int column : row){
                System.out.print(column + "   ");
            }
            System.out.println();
        }
    }

    //Display Connections
    public static void displayConnections(int connectionIn){
        System.out.println(connectionIn +" connections have been found in matrix C.");
        System.out.println("(Connections = Sum of all values in Matrix C)");
    }
}

//Big thanks to the following :
//https://www.programiz.com/java-programming/examples/multiply-matrix-function
//https://www.youtube.com/watch?v=sxHRXwXhpRI
//https://mathbits.com/MathBits/Java/arrays/Matrices.htm
import java.util.Scanner;

public class Program {
    //Main Function
    public static void main(String[] args) {
        //------------To Do
        //Allow user to input a matrix of their choice

        //Dimension of matrices in use
        int rowAndCol = 4;
        //2 Matrices to be used
        int[][] matrixA = {{1,0,0,1},{0,1,0,1},{0,0,1,0},{1,1,1,0}};
        int[][] matrixB = {{0,1,1,1},{1,1,0,1},{0,1,0,1},{1,0,1,0}};

        //Get Matrix of 2 matrices multiplied (Product of two matrices)
        int[][] matrixC = getMultipliedMatrices(matrixA, matrixB, rowAndCol);
        //Get a binary matrix of matrixC
        int[][] binaryMatrixC = makeMatrixBinary(matrixC, rowAndCol);
        //Get Number of Connections
        int numberOfConnections = getConnectionsInMatrix(matrixC);

        //Program Starts Here
        initialGreeting();
        runProgram(matrixC, numberOfConnections, matrixA, matrixB, binaryMatrixC);
    }

    //Initial Program Greeting
    public static void initialGreeting(){
        System.out.println("-------------Welcome to Matrix Multiplication and Connections-------------");
        System.out.println("-We have provided Matrix A and B-");
        System.out.println("-Please input integer values to navigate the program-");
    }

    //Display Program Menu
    public static void programMenu(){
        System.out.println("\n---------------Input One of the Following--------------");
        System.out.println("(1) Check the Product of AxB ");
        System.out.println("(2) Check the number of Connections in a Matrix C");
        System.out.println("(3) Input 2 Matrices");
        System.out.println("(4) Exit Program");
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

    //Program Initiation
    public static void runProgram(int[][] matrixC, int connections, int[][] matrixA, int[][] matrixB, int[][] binaryMatrixC){
        //Users menu choice
        int menuChoice;

        //Program Operates under these conditions
        while(true){
            //Display Program Menu
            programMenu();
            //Get Users Choice
            menuChoice = getMenuChoice();

            //Based on selection, program does the following
            switch (menuChoice) {
                //Resultant when you multiply 2 matrices
                case 1 -> {
                    System.out.println("\nYou have chosen (" + menuChoice + ": The cross product of Matrix A and B)");
                    System.out.println("Matrix A:");
                    displayMatrix(matrixA);
                    System.out.println("Matrix B:");
                    displayMatrix(matrixB);
                    displayMatrixCofAxB(matrixC);
                    displayBinaryMatrixCofAxB(binaryMatrixC);
                }
                // Number of connections in Matrix
                case 2 -> {
                    System.out.println("\nYou have chosen (" + menuChoice + ": The number of Connections in Matrix C) ");
                    displayConnections(connections);
                }
                // Input Unique Matrices
                case 3 -> {
                    System.out.println("\nYou have chosen (" + menuChoice + ": Inputting your own matrices)");
                    System.out.println(":::This Functionality is under construction:::Check back another time or talk to development:::");
                }
                // Exit Program
                case 4 -> {
                    System.out.println("\nYou have chosen (" + menuChoice + ") -Exit Program-\n");
                    System.out.println("=====================================================================");
                    System.out.println("Thank you for using the program. I hope you enjoyed the experience :D");
                    System.out.println("=====================================================================");
                    System.exit(0);
                }
                //default case to display the message invalid choice made by the user
                default -> System.out.println("::Error Occurred :: Please contact development. \\n\\n");
            }
        }
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

    //Make Non Binary Matrix Binary
    public static int[][] makeMatrixBinary(int[][] matrixIn, int rowAndColLength){
        int[][] temp = new int[rowAndColLength][rowAndColLength];

        for(int i = 0; i < rowAndColLength; i++){
            for(int j = 0; j < rowAndColLength; j++){
                for(int k = 0; k < rowAndColLength; k++){
                    //Set value to 1 or 0 if val > 0
                    if(matrixIn[i][j] > 0){
                        temp[i][j] = 1;
                    }else{
                        temp[i][j] = 0;
                    }
                }
            }
        }
        return temp;
    }

    //Pass 1 matrices, return an int number of connections
    public static int getConnectionsInMatrix(int[][] matrixIn){
        int count = 0;

        //Add all values to count if val > 0
        for(int[] innerArray : matrixIn){
            for(int val: innerArray){
                if(val > 0)
                count++;
            }
        }
        return count;
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

    //Display a Matrix
    public static void displayMatrixCofAxB(int[][] product){
        System.out.println("Matrix C (A x B):");

        //Display Matrix
        for(int[] row : product){
            for(int column : row){
                System.out.print(column + "   ");
            }
            System.out.println();
        }
    }

    //Display Binary Matrix C
    public static void displayBinaryMatrixCofAxB(int[][] product){
        System.out.println("Matrix C as a Binary Matrix:");
        for(int[] row : product){
            for(int column : row){
                System.out.print(column + "   ");
            }
            System.out.println();
        }
    }

    //Display Connections
    public static void displayConnections(int connectionIn){
        System.out.println(connectionIn +" connections have been found in matrix C.\n");
        System.out.println("(Connections = Sum of all values in Matrix C)");
        System.out.println("(If it is not a binary matrix, count numbers greater than 1, only as 1, when adding them to the sum.)");

    }
}
//Fun Times
//Big thanks to the following helpful links :
//https://www.programiz.com/java-programming/examples/multiply-matrix-function
//https://www.youtube.com/watch?v=sxHRXwXhpRI
//https://mathbits.com/MathBits/Java/arrays/Matrices.htm
import java.util.Scanner;

public class Main {
    
    private static Scanner input;
    private static String[][][]board;
    private static String difficultyChoice, orderChoice;
    private static int diff, num;
    private static boolean goFirst;
    
    public static void main(String[] args) throws Exception {
        input = new Scanner(System.in);
        board = new String[3][3][3];
        num = 1;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    board[i][j][k] = "" + num;
                    num++;
                }
            }
        }

        System.out.println("Hello! Welcome to TicTacToeV2.");
        while(true){
            System.out.println("Choose your difficulty: Easy, Medium, or Hard");
            difficultyChoice = input.nextLine();
            if(difficultyChoice.contains("hard") || difficultyChoice.contains("Hard")){
                diff = 3;
                break;
            }
            else if(difficultyChoice.contains("medium") || difficultyChoice.contains("Medium")){
                diff = 2;
                break;
            }
            else if(difficultyChoice.contentEquals("easy") || difficultyChoice.contentEquals("Easy")){
                diff = 1;
                break;
            }
            else{
                System.out.println("Please enter a valid option.");
            }
        }
        while(true){
            System.out.println("Would you like to go first: Yes, or No?");
            orderChoice = input.nextLine();
            if(orderChoice.contains("yes") || orderChoice.contains("Yes")){
                goFirst = true;
                break;
            }
            else if(orderChoice.contains("no") || orderChoice.contains("No")){
                goFirst = false;
                break;
            }
            else{
                System.out.println("Please enter a valid option.");
            }
        }
        
        if(goFirst){
            Ops.player(board, input, diff);
        }
    }
}

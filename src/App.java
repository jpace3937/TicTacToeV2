import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[][][] board = new int[3][3][3];
        String difficultyChoice;
        String orderChoice;
        int diff;
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! Welcome to TicTacToeV2.");
        while(true){
            System.out.println("Choose your difficulty: Easy, Medium, or Hard");
            difficultyChoice = input.nextLine();
            if(difficultyChoice.contains("h") || difficultyChoice.contains("H")){
                diff = 3;
                break;
            }
            else if(difficultyChoice.contains("m") || difficultyChoice.contains("M")){
                diff = 2;
                break;
            }
            else if(difficultyChoice.contentEquals("ea") || difficultyChoice.contentEquals("Ea")){
                diff = 1;
                break;
            }
            else{
                System.out.println("Please enter a valid option.");
            }
        }
        while(true){
            System.out.println("Would you like to go first?");
            orderChoice = input.nextLine();
            if(orderChoice.contains("h") || orderChoice.contains("H")){
                diff = 3;
                break;
            }
            else if(orderChoice.contains("m") || orderChoice.contains("M")){
                diff = 2;
                break;
            }
            else if(difficultyChoice.contentEquals("ea") || difficultyChoice.contentEquals("Ea")){
                diff = 1;
                break;
            }
            else{
                System.out.println("Please enter a valid option.");
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    if(k == 2){
                        System.out.print(board[i][j][k]);
                    }
                    else{
                        System.out.print(board[i][j][k] + " | ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
        if(diff == 1){
            
        }
    }
}

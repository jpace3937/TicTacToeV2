import java.util.Scanner;

public class Ops {
    
    private static boolean flag, flag1, keepGoing, done = false;
    private static String move, orderChoice, choice;
    private static int num1, compMove1, compMove2, compMove3;
    private static int num = 1;
    
    /**
     * This method prints the board.
     * @param String[][][] board
     * */
    public static void printBoard(String[][][] board){
        
        System.out.println();
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
    }
    
    /**
     * This method makes the player move.
     * @param String[][][] board
     * @param int diff
     * @param boolean goFirst
     * @param Scanner input
     * */
    public static void player(String[][][] board, int diff, boolean goFirst, Scanner input){
        
        printBoard(board);
        
        while(true){
            if(winner(board, input)){
                while(true){
                    System.out.println("\nWould you like to keep playing: Yes, or No?");
                    choice = input.nextLine();
                    if(choice.equals("yes") || choice.equals("Yes")){
                        keepGoing = true;
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                for(int k = 0; k < 3; k++){
                                    board[i][j][k] = "" + num;
                                    num++;
                                }
                            }
                        }
                        num = 1;
                        break;
                    }
                    else if(choice.equals("no") || choice.equals("No")){
                        System.out.println("\n\nThanks for playing!");
                        input.close();
                        while(true){
                            if(num > 100){
                                break;
                            }
                        }
                    }
                    else{
                        System.out.println("\nPlease enter a valid option.");
                    }
                }
                while(keepGoing){
                    System.out.println("\nWould you like to go first: Yes, or No?");
                    orderChoice = input.nextLine();
                    if(orderChoice.equals("yes") || orderChoice.equals("Yes")){
                        goFirst = true;
                        printBoard(board);
                        break;
                    }
                    else if(orderChoice.equals("no") || orderChoice.equals("No")){
                        goFirst = false;
                        done = false;
                        player2(board, diff, goFirst, input);
                        printBoard(board);
                        break;
                    }
                    else{
                        System.out.println("\nPlease enter a valid option.");
                    }
                }
            }
            System.out.println("\nPlease enter your move.");
            move = input.nextLine();
            flag = false;
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        for(int k = 0; k < 3; k++){
                            if(move.equals(board[i][j][k])){
                                board[i][j][k] = "X";
                                computer(board, diff, goFirst, input);
                                flag = true;
                            }
                            else if(!flag && i == 2){
                                System.out.println("\nPlease choose a valid option.");
                                flag = true;
                            }
                        }
                    }
                }
            }
    }
    
    /**
     * This method makes the player move second.
     * @param String[][][] board
     * @param int diff
     * @param boolean goFirst
     * @param Scanner input
     * */
    public static void player2(String[][][] board, int diff, boolean goFirst, Scanner input){
        
        computer(board, diff, goFirst, input);
        player(board, diff, goFirst, input);
    }
    
    /**
     * This method makes the computer move.
     * @param String[][][] board
     * @param int diff
     * @param boolean goFirst
     * @param Scanner input
     * */
    public static void computer(String[][][]board, int diff, boolean goFirst, Scanner input){
        
        if(diff == 1){
            while(true){
                compMove1 = (int) (Math.random()*2);
                compMove2 = (int) (Math.random()*2);
                compMove3 = (int) (Math.random()*2);
                if(!board[compMove1][compMove2][compMove3].equals("X") && !board[compMove1][compMove2][compMove3].equals("X")){
                    board[compMove1][compMove2][compMove3] = "O";
                    if(goFirst || done){
                        printBoard(board);
                    }
                    done = true;
                    break;
                }
            }
        }
        else if(diff == 2){
            while(true){
                if(num1 % 2 == 0){
                    compMove1 = (int) (Math.random()*2);
                    compMove2 = (int) (Math.random()*2);
                    compMove3 = (int) (Math.random()*2);
                    if(!board[compMove1][compMove2][compMove3].equals("X") && !board[compMove1][compMove2][compMove3].equals("X")){
                        board[compMove1][compMove2][compMove3] = "O";
                        if(goFirst || done){
                            printBoard(board);
                        }
                        done = true;
                        num1++;
                        break;
                    }
                }
                else{
                    compMove(board);
                    if(goFirst || done){
                        printBoard(board);
                    }
                    done = true;
                    num1++;
                    break;
                }
            }
        }
        else{
            compMove(board);
            if(goFirst || done){
                printBoard(board);
            }
            done = true;
        }
    }
    
    /**
     * This method will check for a computer win, then a computer block.
     * @param String[][][] board
     * */
     public static void compMove(String[][][] board){
              
        flag1 = false;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    if(k % 2 != 0 && !flag1){
                        if(board[i][j][k].equals("X") && board[i][j][k - 1].equals("X") && (!board[i][j][k + 1].equals("O") || !board[i][j][k + 1].equals("X"))){
                            board[i][j][k + 1] = "O";
                            flag1 = true;
                        }
                        else if(board[i][j][k].equals("X") && board[i][j][k + 1].equals("X") && (!board[i][j][k - 1].equals("O") || !board[i][j][k - 1].equals("X"))){
                            board[i][j][k - 1] = "O";
                            flag1 = true;
                        }
                        else if(board[i][j][k - 1].equals("X") && board[i][j][k + 1].equals("X") && (!board[i][j][k].equals("O") || !board[i][j][k].equals("X"))){
                            board[i][j][k] = "O";
                            flag1 = true;
                        }
                        else if(board[i][k][j].equals("X") && board[i][k - 1][j].equals("X") && (!board[i][k + 1][j].equals("O") || !board[i][k + 1][j].equals("X"))){
                            board[i][k + 1][j] = "O";
                            flag1 = true;
                        }
                        else if(board[i][k][j].equals("X") && board[i][k + 1][j].equals("X") && (!board[i][k - 1][j].equals("O") || !board[i][k - 1][j].equals("X"))){
                            board[i][k - 1][j] = "O";
                            flag1 = true;
                        }
                        else if(board[i][k + 1][j].equals("X") && board[i][k - 1][j].equals("X") && (!board[i][k][j].equals("O") || !board[i][k][j].equals("X"))){
                            board[i][k][j] = "O";
                            flag1 = true;
                        }
                        else if(board[k][i][j].equals("X") && board[k - 1][i][j].equals("X") && (!board[k + 1][i][j].equals("O") || !board[k + 1][i][j].equals("X"))){
                            board[k + 1][i][j] = "O";
                            flag1 = true;
                        }
                        else if(board[k][i][j].equals("X") && board[k + 1][i][j].equals("X") && (!board[k - 1][i][j].equals("O") || !board[k - 1][i][j].equals("X"))){
                            board[k - 1][i][j] = "O";
                            flag1 = true;
                        }
                        else if(board[k + 1][i][j].equals("X") && board[k - 1][i][j].equals("X") && (!board[k][i][j].equals("O") || !board[k][i][j].equals("X"))){
                            board[k][i][j] = "O";
                            flag1 = true;
                        }
                    }
                }
            }
        }
        if(board[0][0][0].equals("X") && board[0][1][1].equals("X") && (!board[0][2][2].equals("O") || !board[0][2][2].equals("X"))){
            board[0][2][2] = "O";
        }
        else if(board[0][0][0].equals("X") && board[0][2][2].equals("X") && (!board[0][1][1].equals("O") || !board[0][1][1].equals("X"))){
            board[0][1][1] = "O";
        }
        else if(board[0][1][1].equals("X") && board[0][2][2].equals("X") && (!board[0][2][2].equals("O") || !board[0][2][2].equals("X"))){
            board[0][0][0] = "O";
        }
        else if(board[0][0][2].equals("X") && board[0][1][1].equals("X") && (!board[0][2][0].equals("O") || !board[0][2][0].equals("X"))){
            board[0][2][0] = "O";
        }
        else if(board[0][0][2].equals("X") && board[0][2][0].equals("X") && (!board[0][1][1].equals("O") || !board[0][1][1].equals("X"))){
            board[0][1][1] = "O";
        }
        else if(board[0][1][1].equals("X") && board[0][2][0].equals("X") && (!board[0][0][2].equals("O") || !board[0][0][2].equals("X"))){
            board[0][0][2] = "O";
        }
        else if(board[1][0][0].equals("X") && board[1][1][1].equals("X") && (!board[1][2][2].equals("O") || !board[1][2][2].equals("X"))){
            board[1][2][2] = "O";
        }
        else if(board[1][0][0].equals("X") && board[1][2][2].equals("X") && (!board[1][1][1].equals("O") || !board[1][1][1].equals("X"))){
            board[1][1][1] = "O";
        }
        else if(board[1][2][2].equals("X") && board[1][1][1].equals("X") && (!board[1][0][0].equals("O") || !board[1][0][0].equals("X"))){
            board[1][0][0] = "O";
        }
        else if(board[1][0][2].equals("X") && board[1][1][1].equals("X") && (!board[1][2][0].equals("O") || !board[1][2][0].equals("X"))){
            board[1][2][0] = "O";
        }
        else if(board[1][0][2].equals("X") && board[1][2][0].equals("X") && (!board[1][1][1].equals("O") || !board[1][1][1].equals("X"))){
            board[1][1][1] = "O";
        }
        else if(board[1][2][0].equals("X") && board[1][1][1].equals("X") && (!board[1][0][2].equals("O") || !board[1][2][0].equals("X"))){
            board[1][0][2] = "O";
        }
        else if(board[2][0][0].equals("X") && board[2][1][1].equals("X") && (!board[2][2][2].equals("O") || !board[2][2][2].equals("X"))){
            board[2][2][2] = "O";
        }
        else if(board[2][2][2].equals("X") && board[2][1][1].equals("X") && (!board[2][0][0].equals("O") || !board[2][0][0].equals("X"))){
            board[2][0][0] = "O";
        }
        else if(board[2][0][0].equals("X") && board[2][2][2].equals("X") && (!board[2][1][1].equals("O") || !board[2][1][1].equals("X"))){
            board[2][1][1] = "O";
        }
        else if(board[2][0][2].equals("X") && board[2][1][1].equals("X") && (!board[2][2][0].equals("O") || !board[2][2][0].equals("X"))){
            board[2][2][0] = "O";
        }
        else if(board[2][2][0].equals("X") && board[2][1][1].equals("X") && (!board[2][0][2].equals("O") || !board[2][0][2].equals("X"))){
            board[2][0][2] = "O";
        }
        else if(board[2][2][0].equals("X") && board[2][0][2].equals("X") && (!board[2][1][1].equals("O") || !board[2][1][1].equals("X"))){
            board[2][1][1] = "O";
        }
        else if(board[0][0][0].equals("X") && board[1][1][0].equals("X") && (!board[2][2][0].equals("O") || !board[2][2][0].equals("X"))){
            board[2][2][0] = "O";
        }
        else if(board[0][0][0].equals("X") && board[2][2][0].equals("X") && (!board[1][1][0].equals("O") || !board[1][1][0].equals("X"))){
            board[1][1][0] = "O";
        }
        else if(board[1][1][0].equals("X") && board[2][2][0].equals("X") && (!board[0][0][0].equals("O") || !board[0][0][0].equals("X"))){
            board[0][0][0] = "O";
        }
        else if(board[0][0][1].equals("X") && board[1][1][1].equals("X") && (!board[2][2][1].equals("O") || !board[2][2][1].equals("X"))){
            board[2][2][1] = "O";
        }
        else if(board[0][0][1].equals("X") && board[2][2][1].equals("X") && (!board[1][1][1].equals("O") || !board[2][2][1].equals("X"))){
            board[1][1][1] = "O";
        }
        else if(board[2][2][1].equals("X") && board[1][1][1].equals("X") && (!board[0][0][1].equals("O") || !board[0][0][1].equals("X"))){
            board[0][0][1] = "O";
        }
        else if(board[0][0][2].equals("X") && board[1][1][2].equals("X") && (!board[2][2][2].equals("O") || !board[2][2][2].equals("X"))){
            board[2][2][2] = "O";
        }
        else if(board[0][0][2].equals("X") && board[2][2][2].equals("X") && (!board[1][1][2].equals("O") || !board[1][1][2].equals("X"))){
            board[1][1][2] = "O";
        }
        else if(board[2][2][2].equals("X") && board[1][1][2].equals("X") && (!board[0][0][2].equals("O") || !board[0][0][2].equals("X"))){
            board[0][0][2] = "O";
        }
        
        
        /*
        else if(board[0][2][0].equals("X") && board[1][1][0].equals("X") && board[2][2][0].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[0][2][1].equals("X") && board[1][1][1].equals("X") && board[2][2][1].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[0][2][2].equals("X") && board[1][1][2].equals("X") && board[2][2][2].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[0][0][0].equals("X") && board[1][1][1].equals("X") && board[2][2][2].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[0][0][2].equals("X") && board[1][1][1].equals("X") && board[2][2][0].equals("X")){
            System.out.println("X's won!");
            return true;
        }*/
     }
    
    /**
     * This method checks if X's or O's have won.
     * @param String[][][] board
     * @param Scanner input
     * @return true if there is a winner
     * */
    public static boolean winner(String[][][] board, Scanner input){
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    if(k % 2 != 0){
                        if(board[i][j][k].equals("X") && board[i][j][k - 1].equals("X") && board[i][j][k + 1].equals("X")){
                            System.out.println("X's won!");
                            return true;
                        }
                        else if(board[i][k][j].equals("X") && board[i][k - 1][j].equals("X") && board[i][k + 1][j].equals("X")){
                            System.out.println("X's won!");
                            return true;
                        }
                        else if(board[k][i][j].equals("X") && board[k - 1][i][j].equals("X") && board[k + 1][i][j].equals("X")){
                            System.out.println("X's won!");
                            return true;
                        }
                    }
                }
            }
        }
        if(board[0][0][0].equals("X") && board[0][1][1].equals("X") && board[0][2][2].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[0][0][2].equals("X") && board[0][1][1].equals("X") && board[0][2][0].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[1][0][0].equals("X") && board[1][1][1].equals("X") && board[1][2][2].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[1][0][2].equals("X") && board[1][1][1].equals("X") && board[1][2][0].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[2][0][0].equals("X") && board[2][1][1].equals("X") && board[2][2][2].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[2][0][2].equals("X") && board[2][1][1].equals("X") && board[2][2][0].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[0][0][0].equals("X") && board[1][1][0].equals("X") && board[2][2][0].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[0][0][1].equals("X") && board[1][1][1].equals("X") && board[2][2][1].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[0][0][2].equals("X") && board[1][1][2].equals("X") && board[2][2][2].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[0][2][0].equals("X") && board[1][1][0].equals("X") && board[2][2][0].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[0][2][1].equals("X") && board[1][1][1].equals("X") && board[2][2][1].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[0][2][2].equals("X") && board[1][1][2].equals("X") && board[2][2][2].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[0][0][0].equals("X") && board[1][1][1].equals("X") && board[2][2][2].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        else if(board[0][0][2].equals("X") && board[1][1][1].equals("X") && board[2][2][0].equals("X")){
            System.out.println("X's won!");
            return true;
        }
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    if(k % 2 != 0){
                        if(board[i][j][k].equals("O") && board[i][j][k - 1].equals("O") && board[i][j][k + 1].equals("O")){
                            System.out.println("O's won!");
                            return true;
                        }
                        else if(board[i][k][j].equals("O") && board[i][k - 1][j].equals("X") && board[i][k + 1][j].equals("O")){
                            System.out.println("O's won!");
                            return true;
                        }
                        else if(board[k][i][j].equals("O") && board[k - 1][i][j].equals("X") && board[k + 1][i][j].equals("O")){
                            System.out.println("O's won!");
                            return true;
                        }
                    }
                }
            }
        }
        if(board[0][0][0].equals("O") && board[0][1][1].equals("O") && board[0][2][2].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        else if(board[0][0][2].equals("O") && board[0][1][1].equals("O") && board[0][2][0].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        else if(board[1][0][0].equals("O") && board[1][1][1].equals("O") && board[1][2][2].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        else if(board[1][0][2].equals("O") && board[1][1][1].equals("O") && board[1][2][0].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        else if(board[2][0][0].equals("O") && board[2][1][1].equals("O") && board[2][2][2].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        else if(board[2][0][2].equals("O") && board[2][1][1].equals("O") && board[2][2][0].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        else if(board[0][0][0].equals("O") && board[1][1][0].equals("O") && board[2][2][0].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        else if(board[0][0][1].equals("O") && board[1][1][1].equals("O") && board[2][2][1].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        else if(board[0][0][2].equals("O") && board[1][1][2].equals("O") && board[2][2][2].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        else if(board[0][2][0].equals("O") && board[1][1][0].equals("O") && board[2][2][0].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        else if(board[0][2][1].equals("O") && board[1][1][1].equals("O") && board[2][2][1].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        else if(board[0][2][2].equals("O") && board[1][1][2].equals("O") && board[2][2][2].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        else if(board[0][0][0].equals("O") && board[1][1][1].equals("O") && board[2][2][2].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        else if(board[0][0][2].equals("O") && board[1][1][1].equals("O") && board[2][2][0].equals("O")){
            System.out.println("O's won!");
            return true;
        }
        return false;
    }
}

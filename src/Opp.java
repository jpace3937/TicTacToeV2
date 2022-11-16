import java.util.Scanner;

public class Ops {
    
    private static boolean flag, keepGoing, goFirst = false;
    private static String move, orderChoice, choice;
    private static int moveNum;
    private static int num = 1;
    
    public static void printBoard(String[][][] board){
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
    
    
    public static void player(String[][][] board, Scanner input, int diff){
        printBoard(board);
        while(true){
            if(winner(board, input)){
                while(true){
                    System.out.println("Would you like to keep playing: Yes, or No?");
                    choice = input.nextLine();
                    if(choice.contains("yes") || choice.contains("Yes")){
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
                    else if(choice.contains("no") || choice.contains("No")){
                        System.out.println("\n\nThanks for playing!");
                        input.close();
                        while(true){
                            if(num > 100){
                                break;
                            }
                        }
                    }
                    else{
                        System.out.println("Please enter a valid option.");
                    }
                }
                while(keepGoing){
                    System.out.println("Would you like to go first: Yes, or No?");
                    orderChoice = input.nextLine();
                    if(orderChoice.contains("yes") || orderChoice.contains("Yes")){
                        goFirst = true;
                        printBoard(board);
                        break;
                    }
                    else if(orderChoice.contains("no") || orderChoice.contains("No")){
                        goFirst = false;
                        printBoard(board);
                        break;
                    }
                    else{
                        System.out.println("Please enter a valid option.");
                    }
                }
            }
            System.out.println("Please enter your move.");
            move = input.nextLine();
            flag = false;
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        for(int k = 0; k < 3; k++){
                            if(move.equals(board[i][j][k])){
                                board[i][j][k] = "X";
                                computer(board, diff, input);
                                flag = true;
                            }
                            else if(!flag && i == 2){
                                System.out.println("Please choose a valid option.");
                                flag = true;
                            }
                        }
                    }
                }
            }
    }
    
    
    public static void computer(String[][][]board, int diff, Scanner input){
        
        int compMove1, compMove2, compMove3;
        
        if(diff == 1){
            while(true){
                compMove1 = (int) (Math.random()*2);
                compMove2 = (int) (Math.random()*2);
                compMove3 = (int) (Math.random()*2);
                if(!board[compMove1][compMove2][compMove3].equals("X") && !board[compMove1][compMove2][compMove3].equals("X")){
                    board[compMove1][compMove2][compMove3] = "O";
                    printBoard(board);
                    break;
                }
            }
        }
    }
    
    
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

import java.util.Scanner;

public class Ops {
    
    private static boolean flag = false;
    private static String move;
    private static int moveNum;
    
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
        System.out.println("Please enter your move.");
        move = input.nextLine();
        flag = false;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    for(int k = 0; k < 3; k++){
                        if(move.equals(board[i][j][k])){
                            board[i][j][k] = "X";
                            computer(board, diff);
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
    
    
    public static void computer(String[][][]board, int diff){
        
        int compMove1, compMove2, compMove3;
        
        if(diff == 1){
            while(true){
                compMove1 = (int) (Math.random()*2 + 1);
                compMove2 = (int) (Math.random()*2 + 1);
                compMove3 = (int) (Math.random()*2 + 1);
                if(!board[compMove1][compMove2][compMove3].equals("X") || !board[compMove1][compMove2][compMove3].equals("X")){
                    board[compMove1][compMove2][compMove3] = "O";
                    printBoard(board);
                    break;
                }
            }
        }
    }
}

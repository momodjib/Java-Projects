package tictactoe;
import java.util.InputMismatchException;
import java.util.Scanner;
public class TicTacToe {
    private static Scanner sc = new Scanner(System.in);
    private static char[][] grid = new char[3][3];
    private static int player = 1;
    private static boolean winner = false;
    private static boolean valid, draw = false;

    private static void checkLines(){ //Verify after each moves if we have a winner on one of the lines
        if(grid[0][0] !='\0' && grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2]){
            System.out.println(grid[0][0] + " wins");
            winner = true;
        }
        else if(grid[1][0] !='\0' && grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2]){
            System.out.println(grid[1][0] + " wins");
            winner = true;
        }
        else if(grid[2][0] !='\0' && grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2]){
            System.out.println(grid[2][0] + " wins");
            winner = true;
        }
    }
    private static void checkColumns(){ //Verify after each moves if we have a winner on one of the columns
        if(grid[0][0] !='\0' && grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0]){
            System.out.println(grid[0][0] + " wins");
            winner = true;
        }
        else if(grid[0][1] !='\0' && grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1]){
            System.out.println(grid[0][1] + " wins");
            winner = true;
        }
        else if(grid[0][2] !='\0' && grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2]){
            System.out.println(grid[0][2] + " wins");
            winner = true;
        }
    }
    private static void checkDiagonals(){ //Verify after each moves if we have a winner on one of the diagonals
        if(grid[0][0] !='\0' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]){
            System.out.println(grid[0][0] + " wins");
            winner = true;
        }
        else if(grid[0][2] !='\0' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]){
            System.out.println(grid[0][2] + " wins");
            winner = true;
        }
    }
    private static void verdict(){ //Verify after each moves if we have to stop the game because it is a draw
        if(player == 10 && !winner){
            draw = true;
            System.out.println("Draw");
        }
    }
    private static void drawGrid(char [][] grid){ //Draw the grid
        System.out.println("---------");
        for(char[] tab : grid) {
            System.out.print("| ");
            for (char c : tab) {
                System.out.print(c + " ");
            }
            System.out.print('|');
            System.out.println();
        }
        System.out.println("---------");
    }
    private static void action(){
        while(!winner && !draw){ //where all the action is actually done
            do{
                try{
                    System.out.println("Enter the coordinates: ");
                    int col = sc.nextInt();
                    int row = sc.nextInt();
                    makeMove(col, row);
                }catch(InputMismatchException e) {
                    System.out.println("You must enter numbers");
                    sc.next(); sc.next();
                }
            }
            while(!valid);
            checkLines();
            checkColumns();
            checkDiagonals();
            verdict();
        }
    }
    private static void makeMove(int col, int row){ // make a move if possible (empty cells and valid coordinates)
        valid = false;
        if(col==1){
            switch(row){
                case 1:
                    if(checkMove(col,row)){
                        if(player % 2 != 0){grid[2][0] = 'X';}
                        else{grid[2][0] = 'O';}
                        valid=true;
                        player++;
                        drawGrid(grid);
                        return;
                    }else{
                        System.out.println("This cell is occupied! Choose another one");
                        return;
                    }
                case 2:
                    if(checkMove(col,row)){
                        if(player % 2 != 0){grid[1][0] = 'X';}
                        else{grid[1][0] = 'O';}
                        valid=true;
                        player++;
                        drawGrid(grid);
                        return;
                    }else{
                        System.out.println("This cell is occupied! Choose another one");
                        return;
                    }
                case 3:
                    if(checkMove(col,row)){
                        if(player % 2 != 0){grid[0][0] = 'X';}
                        else{grid[0][0] = 'O';}
                        valid=true;
                        player++;
                        drawGrid(grid);
                        return;
                    }else{
                        System.out.println("This cell is occupied! Choose another one");
                        return;
                    }
            }
        }else if(col==2){
            switch(row){
                case 1:
                    if(checkMove(col,row)){
                        if(player % 2 != 0){grid[2][1] = 'X';}
                        else{grid[2][1] = 'O';}
                        valid=true;
                        player++;
                        drawGrid(grid);
                        return;
                    }else{
                        System.out.println("This cell is occupied! Choose another one");
                        return;
                    }
                case 2:
                    if(checkMove(col,row)){
                        if(player % 2 != 0){grid[1][1] = 'X';}
                        else{grid[1][1] = 'O';}
                        valid=true;
                        player++;
                        drawGrid(grid);
                        return;
                    }else{
                        System.out.println("This cell is occupied! Choose another one");
                        return;
                    }
                case 3:
                    if(checkMove(col,row)){
                        if(player % 2 != 0){grid[0][1] = 'X';}
                        else{grid[0][1] = 'O';}
                        valid=true;
                        player++;
                        drawGrid(grid);
                        return;
                    }else{
                        System.out.println("This cell is occupied! Choose another one");
                        return;
                    }
            }
        }else if(col==3){
            switch(row){
                case 1:
                    if(checkMove(col,row)){
                        if(player % 2 != 0){grid[2][2] = 'X';}
                        else{grid[2][2] = 'O';}
                        valid=true;
                        player++;
                        drawGrid(grid);
                        return;
                    }else{
                        System.out.println("This cell is occupied! Choose another one");
                        return;
                    }
                case 2:
                    if(checkMove(col,row)){
                        if(player % 2 != 0){grid[1][2] = 'X';}
                        else{grid[1][2] = 'O';}
                        valid=true;
                        player++;
                        drawGrid(grid);
                        return;
                    }else{
                        System.out.println("This cell is occupied! Choose another one");
                        return;
                    }
                case 3:
                    if(checkMove(col,row)){
                        if(player % 2 != 0){grid[0][2] = 'X';}
                        else{grid[0][2] = 'O';}
                        valid=true;
                        player++;
                        drawGrid(grid);
                        return;
                    }else{
                        System.out.println("This cell is occupied! Choose another one");
                        return;
                    }
            }
        }System.out.println("Coordinates should be from 1 to 3!");
    }
    private static boolean checkMove(int col, int row){ //verifies if we have empty cells
        if(col==1){
            switch(row){ //Character.MIN_VALUE
                case 1:
                    return grid[2][0] == '\0';
                case 2:
                    return grid[1][0] == '\0';
                case 3:
                    return grid[0][0] == '\0';
            }
        }else if(col==2){
            switch(row){
                case 1:
                    return grid[2][1] == '\0';
                case 2:
                    return grid[1][1] == '\0';
                case 3:
                    return grid[0][1] == '\0';
            }
        }else if(col==3){
            switch(row){
                case 1:
                    return grid[2][2] == '\0';
                case 2:
                    return grid[1][2] == '\0';
                case 3:
                    return grid[0][2] == '\0';
            }
        }
        return false;
    }
    public static void main(String[] args) {
        drawGrid(grid);
        action();
    }
}

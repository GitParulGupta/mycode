package design.lowleveldesign.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public int getSize() {
        return size;
    }

    public void printBoard(){

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print((board[i][j]==null?" ":board[i][j].type.toString()) + "|");
            }
            System.out.print("\n");
        }
    }

    public boolean addPiece(int row, int col, PlayingPiece piece){
        if(board[row][col] != null){
            return false;
        }
        board[row][col] = piece;
        return true;
    }

    public boolean checkWinner(int row, int col, PlayingPiece currentPlayerPiece){
        boolean rowMatch = true;
        //check Row
        for(int i = 0; i < size; i++){
            if(board[row][i]==null || !board[row][i].type.equals(currentPlayerPiece.type)){
                rowMatch = false;
            }
        }
        boolean colMatch = true;
        for(int i = 0; i < size; i++){
            if(board[i][col] == null || !board[i][col].type.equals(currentPlayerPiece.type)){
                colMatch = false;
            }
        }

        boolean diagonalMatch = true;
        for(int i = 0, j=0; i < size; i++,j++){
            if(board[i][j]==null || !board[i][j].type.equals(currentPlayerPiece.type)){
                diagonalMatch = false;
            }
        }

        boolean antiDiagonalMatch = true;
        for(int i = 0, j=size-1; i < size; i++,j--){
            if(board[i][j]==null || !board[i][j].type.equals(currentPlayerPiece.type)){
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }

    public List<int[][]> getFreeCells(){
        List<int[][]> freeCells = new ArrayList<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] == null){
                    freeCells.add(new int[][]{{i,j}});
                }
            }
        }
        return freeCells;
    }
}

package design.lowleveldesign.tictactoe;

import design.lowleveldesign.tictactoe.model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    Deque<Player> playerList;
    Board board;

    public TicTacToeGame() {
        initialiseGame();
    }

    private void initialiseGame(){
        playerList = new LinkedList<>();
        PlayingPieceX cross = new PlayingPieceX();
        Player player1 = new Player("Player1",cross);

        PlayingPieceO zero = new PlayingPieceO();
        Player player2 = new Player("Player2",zero);

        playerList.add(player1);
        playerList.add(player2);

        board = new Board(3);
    }

    public void startGame(){

        boolean noWinner = true;
        Scanner input = new Scanner(System.in);

        while (noWinner){

            Player currentPlayer = playerList.removeFirst();
            board.printBoard();

            List<int[][]> freeCells = board.getFreeCells();
            if(freeCells.isEmpty()){
                noWinner = false;
                System.out.println("Its a tie");
            }

            System.out.println(currentPlayer.getName()+" Enter the row and column");
            int row = input.nextInt();
            int col = input.nextInt();

            boolean validMove = board.addPiece(row,col, currentPlayer.getPlayingPiece());
            if(!validMove){
                System.out.println("Incorrect row or column");
                playerList.addFirst(currentPlayer);
                continue;
            }

            boolean isWinner = board.checkWinner(row,col,currentPlayer.getPlayingPiece());
            if(isWinner){
                noWinner = false;
                System.out.println("Winner "+currentPlayer.getName());
            }
            playerList.addLast(currentPlayer);
        }
    }
}

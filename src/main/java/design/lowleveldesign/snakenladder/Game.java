package design.lowleveldesign.snakenladder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Board board;
    Dice dice;
    Deque<Player> playerList;
    Player winner;
    
    public Game(){
        initialiseGame();
        addPlayers();
    }

    private void initialiseGame() {
        board = new Board(10,5,6);
        dice = new Dice(1);
        playerList = new LinkedList<>();
        winner = null;
    }

    private void addPlayers(){
        Player p1 = new Player("player1",0);
        Player p2 = new Player("player2",0);
        playerList.add(p1);
        playerList.add(p2);
    }


    public void startGame(){

        System.out.println("Starting game...");

        while(winner==null){
            Player currentPlayer = getCurrentPlayer();
            System.out.println("Current player"+currentPlayer.name+" Current Position"+currentPlayer.currentPosition);
            int rollDiceNum = dice.rollDice();

            int nextPosition = currentPlayer.currentPosition+rollDiceNum;
            int nextPositionPostJump = checkJump(nextPosition);
            currentPlayer.currentPosition = nextPositionPostJump;
            if(nextPositionPostJump>board.boardSize*board.boardSize-1){
                winner = currentPlayer;
            }
        }

        System.out.println("Winner is "+winner.name);
    }

    private Player getCurrentPlayer(){
        Player currentPlayer = playerList.removeFirst();
        playerList.addLast(currentPlayer);
        return currentPlayer;
    }

    private int checkJump(int newPosition){
        if(newPosition> board.boardSize*board.boardSize-1){
            return newPosition;
        }
        Cell cell = board.getCell(newPosition);
        if(cell.jump!=null && cell.jump.start == newPosition){
            String jumpBy = (cell.jump.start<cell.jump.end)?"ladder":"snake";
            System.out.println(jumpBy+" start:"+cell.jump.start+" end:"+cell.jump.end);
            return cell.jump.end;
        }

        return newPosition;
    }
}

package design.lowleveldesign.snakenladder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;
    int boardSize;
    int numOfSnakes;
    int numOfLadders;

    public Board(int boardSize, int  numOfSnakes, int numOfLadders) {
        this.boardSize = boardSize;
        this.numOfSnakes = numOfSnakes;
        this.numOfLadders = numOfLadders;
        initialiseBoard(boardSize);
        initialiseSnakesAndLadders(cells, numOfLadders, numOfSnakes);
    }

    private void initialiseBoard(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private void initialiseSnakesAndLadders(Cell[][] cells, int numOfLadders, int numOfSnakes) {
        while (numOfLadders > 0) {

            int ladderStart = ThreadLocalRandom.current().nextInt(0, cells.length* cells.length - 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(0, cells.length* cells.length - 1);
            if(ladderStart>ladderEnd) {
                continue;
            }

            Jump ladderJump = new Jump();
            ladderJump.start =  ladderStart;
            ladderJump.end = ladderEnd;

            Cell ladderCell = getCell(ladderStart);
            ladderCell.jump = ladderJump;
            numOfLadders--;

        }

        while (numOfSnakes > 0) {

            int snakeStart = ThreadLocalRandom.current().nextInt(0, cells.length* cells.length - 1);
            int snakeEnd = ThreadLocalRandom.current().nextInt(0, cells.length* cells.length - 1);
            if(snakeStart<snakeEnd) {
                continue;
            }

            Jump snakeJump = new Jump();
            snakeJump.start =  snakeStart;
            snakeJump.end = snakeEnd;

            Cell snakeCell = getCell(snakeStart);
            snakeCell.jump = snakeJump;
            numOfSnakes--;

        }
    }

    public Cell getCell(int ladderStart) {
        int row = ladderStart / boardSize;
        int col = ladderStart % boardSize;
        return cells[row][col];
    }
}

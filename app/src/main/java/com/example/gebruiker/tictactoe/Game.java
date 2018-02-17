package com.example.gebruiker.tictactoe;

import java.io.Serializable;

/**
 * Created by Gebruiker on 15-2-2018.
 */

public class Game implements Serializable {

    // Properties
    final private int BOARD_SIZE = 3;
    private Tile[][] board;
    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    // Constructor
    public Game() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = Tile.BLANK;
            }
        }
        playerOneTurn = true;
        gameOver = false;
    }

    // Method
    public Tile draw(int row, int column) {

        Tile selectedTile = board[row][column];

        if (selectedTile == Tile.BLANK) {
            if (playerOneTurn == true) {
                selectedTile = Tile.CROSS;   //let op!!
                movesPlayed += 1;
                playerOneTurn = false;
                return Tile.CROSS;
            }
            else {
                selectedTile = Tile.CIRCLE;
                movesPlayed += 1;
                playerOneTurn = true;
                return Tile.CIRCLE;
            }
        }
        else {
            return Tile.INVALID;
        }
    }

    public GameState gameState() {
        if ((board[0][0] == Tile.CROSS && board[0][1] == Tile.CROSS && board[0][2] == Tile.CROSS) ||
                (board[1][0] == Tile.CROSS && board[1][1] == Tile.CROSS && board[1][2] == Tile.CROSS) ||
                (board[2][0] == Tile.CROSS && board[2][1] == Tile.CROSS && board[2][2] == Tile.CROSS)){
            gameOver = true;
            return GameState.PLAYER_ONE;
        }
        else if ((board[0][0] == Tile.CIRCLE && board[0][1] == Tile.CIRCLE && board[0][2] == Tile.CIRCLE) ||
                (board[1][0] == Tile.CIRCLE && board[1][1] == Tile.CIRCLE && board[1][2] == Tile.CIRCLE) ||
                (board[2][0] == Tile.CIRCLE && board[2][1] == Tile.CIRCLE && board[2][2] == Tile.CIRCLE)){
            gameOver = true;
            return GameState.PLAYER_TWO;
        }
        else if (movesPlayed == 9) {
            gameOver = true;
            return GameState.DRAW;
        }
        else {
            return GameState.IN_PROGRESS;
        }
    }
}

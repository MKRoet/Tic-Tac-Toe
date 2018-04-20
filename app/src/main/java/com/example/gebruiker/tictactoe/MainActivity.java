package com.example.gebruiker.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Game game;
    public int row;
    public int column;
    public int boardSize = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    public void tileClicked(View view) {

        int id = view.getId();

        switch(id){
            case R.id.Tile00:
                column = 0;
                row = 0;
                break;
            case R.id.Tile01:
                column = 0;
                row = 1;
                break;
            case R.id.Tile02:
                column = 0;
                row = 2;
                break;
            case R.id.Tile10:
                column = 1;
                row = 0;
                break;
            case R.id.Tile11:
                column = 1;
                row = 1;
                break;
            case R.id.Tile12:
                column = 1;
                row = 2;
                break;
            case R.id.Tile20:
                column = 2;
                row = 0;
                break;
            case R.id.Tile21:
                column = 2;
                row = 1;
                break;
            case R.id.Tile22:
                column = 2;
                row = 2;
                break;
        }

        Button button = findViewById(id);
        TextView textview = findViewById(R.id.textMessage);

        Tile tile = game.draw(row, column);


        switch (tile) {
            case CROSS:
                button.setText("X");
                break;
            case CIRCLE:
                button.setText("O");
                break;
            case INVALID:
                textview.setText("Move invalid");
                break;
        }

        GameState gamestate = game.gameState();
        switch (gamestate) {
            case PLAYER_ONE:
                textview.setText("Victory for player one!");
                break;
            case PLAYER_TWO:
                textview.setText("Hurray, player 2 wins!");
                break;
            case DRAW:
                textview.setText("Undecided!");
                break;
            case IN_PROGRESS:
                break;
        }
    }
    public void resetClicked(View view) {

        game = new Game();

//        int id = view.getId();
//        Button Button1 = R.id.Tile00;
//
//
//        button.setText("");


        TextView textview = findViewById(R.id.textMessage);
        textview.setText("");





    }
}



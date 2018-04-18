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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    public void tileClicked(View view) {

        int id = view.getId();
        Button button = findViewById(id);
        TextView textview = findViewById(R.id.textMessage);

        Log.d("row", String.valueOf(row));
        Log.d("column", String.valueOf(column));
        Tile tile = game.draw(row, column);
        Log.d("tile", String.valueOf(tile));

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
//        Button button = findViewById(id);
//        button.setText(" ");

    }
}



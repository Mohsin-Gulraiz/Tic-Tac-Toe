package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   boolean gameActive = true;
    //0 is X
    //1 is O
    int activePlayer = 0;
    int [] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //State Meanings
    //0 is X
    //1 is O
    //2 is Null
    int [][] winPositions = {{1,2,3}, {4,5,6,}, {7,8,9}, {1,4,7}, {2,5,8}, {3,6,9}, {1,5,9}, {7,5,3}};
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImage]==2){
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O Turn - Tap to Play");
            }
            else{
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X Turn - Tap to Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        //Check if any player has won
        for(int[] winPosition: winPositions){
            if(gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[2]] == gameState[winPosition[3]] &&
                    gameState[winPosition[1]] !=2);{
                        //Somebody Has Won
                String winnerStr;
//                gameActive = false;
                if(gameState[winPosition[0]]==0){
                    winnerStr = "X has won";
                }
                else{
                    winnerStr = "O has Won";
                }
                //Update the Status bar
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }
    }


    public void gameReset(View view){
        gameActive = true;
        activePlayer = 0;
        for (int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
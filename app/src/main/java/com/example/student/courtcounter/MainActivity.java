package com.example.student.courtcounter;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView countView;
    private TextView countViewTwo;
    public int scoreOne;
    public int scoreTwo;
    AlertDialog gameOverAlert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameOverAlert= new AlertDialog.Builder(MainActivity.this).create();

        countView= (TextView)findViewById(R.id.buttonCounter);
        countView.setText(""+scoreOne);

        countViewTwo= (TextView)findViewById(R.id.buttonClicker);
        countViewTwo.setText(""+scoreTwo);

        scoreOne = 0;
        scoreTwo = 0;

    }

    public void clickFunction1(View view){
        countView.setText(String.valueOf(scoreOne));
        scoreOne++;
    }

    public void clickFunction2(View view){
        countViewTwo.setText(String.valueOf(scoreTwo));
        scoreTwo++;
    }

    public void gameOverFunction(View view) {
        if (scoreOne > scoreTwo) {
            gameOverAlert.setMessage("Team 1 wins");
        }
        if (scoreTwo > scoreOne) {
            gameOverAlert.setMessage("Team 2 wins");
        }

        gameOverAlert.setTitle("GAME OVER!!");
        gameOverAlert.setMessage("Message Text");

        gameOverAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        gameOverAlert.show();

        scoreOne = 0;
        countView.setText(String.valueOf(scoreOne));
        scoreTwo = 0;
        countViewTwo.setText(String.valueOf(scoreTwo));

    }
}

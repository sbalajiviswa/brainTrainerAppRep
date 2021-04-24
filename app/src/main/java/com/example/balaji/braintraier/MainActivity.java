package com.example.balaji.braintraier;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button go;
    Button pagain;
    TextView question;
    TextView score;
    TextView timertext;
    Button choice1;
    Button choice2;
    Button choice3;
    Button choice4;
    TextView result;

//    ConstraintLayout gameLay;
    int correctans;
    int scr = 0;
//    public void playAgain(View view){
//        gobutton(view);
//        scr = 0;
//        score.setText(Integer.toString(scr));
//        timertext.setText("30s");
//
//    }

    public void gobutton(View view){
        scr = 0;
        score.setText(Integer.toString(scr));
        timertext.setText("30s");
        go.setVisibility(View.INVISIBLE);
        question.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        timertext.setVisibility(View.VISIBLE);
        choice1.setVisibility(View.VISIBLE);
        choice2.setVisibility(View.VISIBLE);
        choice3.setVisibility(View.VISIBLE);
        choice4.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
//        gameLay.setVisibility(View.VISIBLE);
        generate(view);
        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long l) {
                timertext.setText((l/1000)+"s");
            }

            @Override
            public void onFinish() {
                pagain.setVisibility(View.VISIBLE);
                result.setText("Finished");
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                choice4.setVisibility(View.INVISIBLE);


            }
        }.start();
    }
    public int generate(View view){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Random random = new Random();
        int a = random.nextInt(21);
        int b = random.nextInt(21);
        question.setText(Integer.toString(a)+"+"+Integer.toString(b));
        for(int i =0;i<4;i++){
        correctans = random.nextInt(4);
            int wrongans = random.nextInt(41);
            if(i == correctans){
                ans.add(a+b);
            }else {
                while(wrongans == a+b){
                    wrongans =random.nextInt(41);
                }
                ans.add(wrongans);
            }

        }
        choice1.setText(Integer.toString(ans.get(0)));
        choice2.setText(Integer.toString(ans.get(1)));
        choice3.setText(Integer.toString(ans.get(2)));
        choice4.setText(Integer.toString(ans.get(3)));
        return correctans;


    }
    public void choices(View view){
        if(view.getTag().toString().equals(Integer.toString(correctans))) {
            result.setText("Correct!");
            scr++;
            generate(view);
            score.setText(Integer.toString(scr));
        }else{
            result.setText("wrong");
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        gameLay =  findViewById(R.id.answers);
        setContentView(R.layout.activity_main);
        pagain = findViewById(R.id.button);
        go = findViewById(R.id.Go);
        question = findViewById(R.id.question);
        score = findViewById(R.id.scoretext);
        timertext = findViewById(R.id.timer);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);
        result = findViewById(R.id.result);
        result.setText("");
        score.setText(Integer.toString(scr));
        question.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        timertext.setVisibility(View.INVISIBLE);
        choice1.setVisibility(View.INVISIBLE);
        choice2.setVisibility(View.INVISIBLE);
        choice3.setVisibility(View.INVISIBLE);
        choice4.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
        go.setVisibility(View.VISIBLE);
        pagain.setVisibility(View.INVISIBLE);






    }
}

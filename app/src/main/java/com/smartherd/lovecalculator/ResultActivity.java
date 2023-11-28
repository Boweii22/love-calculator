package com.smartherd.lovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView numberPercentage;
    private TextView loveDescription;
    private Handler handler;
    private int currentNumber;

    Button tryAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        loveDescription = findViewById(R.id.text2);
        numberPercentage = findViewById(R.id.numerPercentage);
        tryAgainButton = findViewById(R.id.reCalculateLove);
        handler = new Handler(Looper.getMainLooper());

        //incrementation of the loop
        startIncrementing();

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void startIncrementing(){
    //using a Runnable to increment the number of intervals
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Increment the current number
                currentNumber++;

                int random_No = (int)Math.floor(Math.random() * (100-60+1) + 60);
                // Update the TextView
                numberPercentage.setText(String.valueOf(currentNumber) + "%");

                if(currentNumber >=50 && currentNumber <= 70){
                    loveDescription.setText("Casual");
                } else if (currentNumber>70 && currentNumber <=80) {
                    loveDescription.setText("Friends");
                } else if (currentNumber>80 && currentNumber<=90) {
                    loveDescription.setText("Close Friends");
                }else{
                    loveDescription.setText("Admirers");
                }
                // Check if the current number has reached 100
                if (currentNumber < random_No) {
                    // Call the Runnable again after a delay
                    handler.postDelayed(this, 50); // Change the delay as needed (in milliseconds)
                }
            }
            };
        // Start the initial delay
        handler.postDelayed(runnable, 50); // Change the initial delay as needed (in milliseconds)
        finish();
        }
    }
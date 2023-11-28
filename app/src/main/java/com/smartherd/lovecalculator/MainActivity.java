package com.smartherd.lovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;

    Button calculateLoveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final EditText name = findViewById(R.id.Name);
        final EditText partnerName = findViewById(R.id.matchName);

        calculateLoveButton = findViewById(R.id.calculateLove);

        calculateLoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String getName = name.getText().toString();
                final String getMatchName = name.getText().toString();
                if (getName.isEmpty() || getMatchName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter the names", Toast.LENGTH_SHORT).show();
                } else {
                   Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                   intent.putExtra("Name",getName);
                   intent.putExtra("MatchName", getMatchName);
                   startActivity(intent);
                }
            }
        });
    }
}
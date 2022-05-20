package com.example.basicapplicationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView selectedCoffee;

    public void onClick(View view){

        switch (view.getId()){
            case R.id.espresso:
                selectedCoffee.setText("Espresso");
                break;
            case R.id.cappicino:
                selectedCoffee.setText("Cappicino");
                break;
            case R.id.americano:
                selectedCoffee.setText("Americano");
                break;
            case R.id.irish:
                selectedCoffee.setText("Irish");
                break;
            case R.id.latte:
                selectedCoffee.setText("Latte");
                break;
            case R.id.mocha:
                selectedCoffee.setText("Mocha");
                break;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectedCoffee = findViewById(R.id.preferred_coffee);
    }
}
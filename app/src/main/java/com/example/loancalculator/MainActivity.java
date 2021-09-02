package com.example.loancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtLoanAmount, txtRate, txtTerms;
    Button Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLoanAmount = findViewById(R.id.txtLoanAmount);
        txtRate = findViewById(R.id.txtRate);
        txtTerms = findViewById(R.id.txtTerms);
        Calculate = findViewById(R.id.btnCalculate);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtLoanAmount.getText().toString().equals("") ||txtRate.getText().toString().equals("")
                 ||txtTerms.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please fill all blanks to calculate.",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    String amount = txtLoanAmount.getText().toString();
                    String rate = txtRate.getText().toString();
                    String terms = txtTerms.getText().toString();
                    Intent intent = new Intent(MainActivity.this,OutputActivity.class);
                    intent.putExtra("amount", amount);
                    intent.putExtra("rate", rate);
                    intent.putExtra("terms", terms);
                    startActivity(intent);
                }
            }
        });
    }
}
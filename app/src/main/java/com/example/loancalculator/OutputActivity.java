package com.example.loancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class OutputActivity extends AppCompatActivity {

    TextView Loan, Rate, Months, Mpayments, Tpayments;
    Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        Loan = findViewById(R.id.tvLoanAmount);
        Rate = findViewById(R.id.tvRate);
        Months = findViewById(R.id.tvMonths);
        Mpayments = findViewById(R.id.tvMpayments);
        Tpayments = findViewById(R.id.tvTpayments);

        Intent intent = getIntent();
        String amount = intent.getStringExtra("amount");
        String rate = intent.getStringExtra("rate");
        String terms = intent.getStringExtra("terms");
        final DecimalFormat df2 = new DecimalFormat(".##");
        double Years= Double.parseDouble(terms);
        double Monthperiod = Years * 12;
        double r = Double.parseDouble(rate);
        double rt = r/100/12;
        double loanAmount = Double.parseDouble(amount);
        double Mpayment =(loanAmount*rt*Math.pow(1+rt,Monthperiod))/(Math.pow(1+rt,Monthperiod)-1);
        double Ttpayments = Mpayment * Monthperiod;
        String MonthelyPeriod = String.valueOf(Math.round(Monthperiod));

        Loan.setText(amount);
        Rate.setText(rate+"%");
        Months.setText(MonthelyPeriod);
        Mpayments.setText(df2.format(Mpayment));
        Tpayments.setText(df2.format(Ttpayments));

    }
}
package com.onurkayabasi.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.editTextNum1);
        num2 = findViewById(R.id.editTextNum2);
        resultText = findViewById(R.id.textViewResult);
    }

    public void sum(View view) {
        int intNum1;
        int intNum2;

        if (!ValidateIntegerStrings(num1.getText().toString()) || !ValidateIntegerStrings(num2.getText().toString())) {
            resultText.setTextSize(18);
            resultText.setText("Please enter a number !");
        } else {
            intNum1 = Integer.parseInt(num1.getText().toString());
            intNum2 = Integer.parseInt(num2.getText().toString());

            int result = intNum1 + intNum2;

            resultText.setTextSize(32);
            resultText.setText("Result : " + result);
        }
    }

    public void subtract(View view) {
        int intNum1;
        int intNum2;

        if (!ValidateIntegerStrings(num1.getText().toString()) || !ValidateIntegerStrings(num2.getText().toString())) {
            resultText.setTextSize(18);
            resultText.setText("Please enter a number !");
        } else {
            intNum1 = Integer.parseInt(num1.getText().toString());
            intNum2 = Integer.parseInt(num2.getText().toString());

            int result = intNum1 - intNum2;

            resultText.setTextSize(32);
            resultText.setText("Result : " + result);
        }
    }

    public void divide(View view) {
        int intNum1;
        int intNum2;

        if (!ValidateIntegerStrings(num1.getText().toString()) || !ValidateIntegerStrings(num2.getText().toString())) {
            resultText.setTextSize(18);
            resultText.setText("Please enter a number !");
        } else if (Integer.parseInt(num2.getText().toString()) == 0) {
            resultText.setTextSize(18);
            resultText.setText("The second number cannot be zero!");
        } else {
            intNum1 = Integer.parseInt(num1.getText().toString());
            intNum2 = Integer.parseInt(num2.getText().toString());

            int result = intNum1 / intNum2;

            resultText.setTextSize(32);
            resultText.setText("Result : " + result);
        }
    }

    public void multiply(View view) {
        int intNum1;
        int intNum2;

        if (!ValidateIntegerStrings(num1.getText().toString()) || !ValidateIntegerStrings(num2.getText().toString())) {
            resultText.setTextSize(18);
            resultText.setText("Please enter a number !");
        } else {
            intNum1 = Integer.parseInt(num1.getText().toString());
            intNum2 = Integer.parseInt(num2.getText().toString());

            int result = intNum1 * intNum2;

            resultText.setTextSize(32);
            resultText.setText("Result : " + result);
        }
    }

    private boolean ValidateIntegerStrings(String number) {
        return number.matches("[+-]?[0-9][0-9]*");
    }
}
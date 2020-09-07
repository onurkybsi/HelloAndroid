package com.onurkayabasi.helloandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    private int currentResult = 0;

    private EditText num1;
    private EditText num2;
    private TextView resultText;
    private TextView textViewSavedResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("com.onurkayabasi.helloandroid", Context.MODE_PRIVATE);

        int savedResult = sharedPreferences.getInt("savedResult", currentResult);

        textViewSavedResult = findViewById(R.id.textViewSavedResult);

        textViewSavedResult.setText("Saved Result : " + savedResult);

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

            currentResult = intNum1 + intNum2;

            resultText.setTextSize(32);
            resultText.setText("Result : " + currentResult);
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

            currentResult = intNum1 - intNum2;

            resultText.setTextSize(32);
            resultText.setText("Result : " + currentResult);
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

            currentResult = intNum1 / intNum2;

            resultText.setTextSize(32);
            resultText.setText("Result : " + currentResult);
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

            currentResult = intNum1 * intNum2;

            resultText.setTextSize(32);
            resultText.setText("Result : " + currentResult);
        }
    }

    public void saveResult(View view) {

        sharedPreferences.edit().putInt("savedResult", currentResult).apply();
        textViewSavedResult.setText("Saved Result : " + currentResult);
    }

    public void deleteSavedResult(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Delete");
        alert.setMessage("Do you really want to delete saved result ?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int savedResult = sharedPreferences.getInt("savedResult", 0);

                if (savedResult != 0) {
                    sharedPreferences.edit().remove("savedResult").apply();
                    textViewSavedResult.setText("Saved Result : " + 0);

                    Toast.makeText(MainActivity.this, "Deleted!", Toast.LENGTH_LONG).show();
                }
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        alert.show();
    }

    private boolean ValidateIntegerStrings(String number) {
        return number.matches("[+-]?[0-9][0-9]*");
    }
}
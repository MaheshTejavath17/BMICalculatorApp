package com.example.bmicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

public class MainActivity extends Activity {
    private EditText weightInput, heightInput;
    private TextView bmiValue, categoryText, adviceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        bmiValue = findViewById(R.id.bmiValue);
        categoryText = findViewById(R.id.categoryText);
        adviceText = findViewById(R.id.adviceText);

        Button calculateButton = findViewById(R.id.calculateButton);
        Button clearButton = findViewById(R.id.clearButton);

        calculateButton.setOnClickListener(v -> calculateBMI());
        clearButton.setOnClickListener(v -> clearAll());
    }

    private void calculateBMI() {
        String weightText = weightInput.getText().toString().trim();
        String heightText = heightInput.getText().toString().trim();

        if (weightText.isEmpty() || heightText.isEmpty()) {
            Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double weight = Double.parseDouble(weightText);
            double heightCm = Double.parseDouble(heightText);

            if (weight <= 0 || heightCm <= 0 || weight > 500 || heightCm > 300) {
                Toast.makeText(this, "Enter realistic positive values", Toast.LENGTH_SHORT).show();
                return;
            }

            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);

            if (Double.isNaN(bmi) || Double.isInfinite(bmi)) {
                Toast.makeText(this, "Unable to calculate BMI", Toast.LENGTH_SHORT).show();
                return;
            }

            bmiValue.setText(String.format(Locale.getDefault(), "%.1f", bmi));

            String category;
            String advice;
            if (bmi < 18.5) {
                category = "Underweight";
                advice = "Your BMI is below the usual adult healthy range.";
            } else if (bmi < 25.0) {
                category = "Normal weight";
                advice = "Your BMI is within the usual adult healthy range.";
            } else if (bmi < 30.0) {
                category = "Overweight";
                advice = "Your BMI is above the usual adult healthy range.";
            } else {
                category = "Obesity";
                advice = "Your BMI is in the obesity range for adults.";
            }

            categoryText.setText(category);
            adviceText.setText(advice);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numeric values", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearAll() {
        weightInput.setText("");
        heightInput.setText("");
        bmiValue.setText("--");
        categoryText.setText("Your category will appear here");
        adviceText.setText("Enter your details to calculate BMI.");
        weightInput.requestFocus();
    }
}

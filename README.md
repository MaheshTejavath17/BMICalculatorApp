# BMI Calculator Android App (Java + XML)

A simple Android app that calculates Body Mass Index from weight (kg) and height (cm).

## Features
- BMI calculation using weight / height²
- Adult categories: Underweight, Normal weight, Overweight, Obesity
- Empty and invalid input validation
- Rejects non-positive and unrealistic values
- Clean results screen and Clear button

## Requirements
- Android Studio
- Android SDK 35 (install when prompted)
- JDK 17 (Android Studio embedded JDK)

## Run
1. Extract `BMICalculatorApp.zip`.
2. Open Android Studio and choose **Open**.
3. Select the extracted `BMICalculatorApp` folder (contains `settings.gradle`).
4. Wait for Gradle sync and install SDK 35 if prompted.
5. Start an emulator in Device Manager or connect an Android phone with USB debugging enabled.
6. Click **Run ▶**.

## Input units
Weight in kilograms (kg); height in centimetres (cm).

## Formula
BMI = weight in kilograms / (height in metres × height in metres)

BMI categories are adult screening ranges and are not a medical diagnosis.

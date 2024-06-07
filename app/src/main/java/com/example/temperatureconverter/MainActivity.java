package com.example.temperatureconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputTemperature;
    private RadioGroup radioGroup;
    private RadioButton celsiusRadio, fahrenheitRadio;
    private Button convertButton;
    private TextView convertedTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTemperature = findViewById(R.id.input_temperature);
        radioGroup = findViewById(R.id.radio_group);
        celsiusRadio = findViewById(R.id.radio_celsius);
        fahrenheitRadio = findViewById(R.id.radio_fahrenheit);
        convertButton = findViewById(R.id.convert_button);
        convertedTemperature = findViewById(R.id.converted_temperature);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String inputString = inputTemperature.getText().toString();
        if (inputString.isEmpty()) {
            return;
        }

        double temperature = Double.parseDouble(inputString);
        boolean isCelsius = celsiusRadio.isChecked();

        double convertedTemp;
        if (isCelsius) {
            convertedTemp = temperature * 1.8 + 32; // Convert to Fahrenheit
        } else {
            convertedTemp = (temperature - 32) / 1.8; // Convert to Celsius
        }

        String result = String.format("%.2f°%s", convertedTemp, isCelsius ? "F" : "C");
        convertedTemperature.setText(result);
    }
}

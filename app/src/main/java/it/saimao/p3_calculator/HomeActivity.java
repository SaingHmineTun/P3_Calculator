package it.saimao.p3_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import it.saimao.p3_calculator.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void onNumberClicked(View view) {
        Button btn = (Button) view;
        String text = btn.getText().toString();

        String input = binding.etCalculator.getText().toString();
        if (input.equals("0")) {
            binding.etCalculator.setText(text);
        } else {
            binding.etCalculator.append(text);
        }

    }

    public void onOperatorClicked(View view) {

        Button btn = (Button) view;
        String operator = btn.getText().toString();

        if (operator.equals("=")) {
            try {
                double operation = Double.parseDouble(binding.tvOperation.getText().toString());
                double current = Double.parseDouble(binding.etCalculator.getText().toString());
                double result = 0;
                String previousOperator = binding.tvOperator.getText().toString();
                switch (previousOperator) {
                    case "+" -> result = operation + current;
                    case "-" -> result = operation - current;
                    case "*" -> result = operation * current;
                    case "/" -> result = operation / current;
                }
                binding.etCalculator.setText(String.valueOf(result));
                binding.tvOperator.setText("Operator");
                binding.tvOperation.setText("Operation");
            } catch (Exception e) {
                Toast.makeText(this, "Invalid action", Toast.LENGTH_SHORT).show();
            }
        } else {
            binding.tvOperator.setText(operator);
            String operation = binding.etCalculator.getText().toString();
            binding.tvOperation.setText(operation);
            binding.etCalculator.setText("0");
        }
    }


    public void onClearClicked(View view) {
        binding.tvOperation.setText("Operation");
        binding.tvOperator.setText("Operator");
        binding.etCalculator.setText("0");
    }
}
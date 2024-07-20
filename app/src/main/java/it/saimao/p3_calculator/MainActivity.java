package it.saimao.p3_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import it.saimao.p3_calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initListeners();
    }

    private void initListeners() {
        binding.cbRed.setOnCheckedChangeListener(this);
        binding.cbGreen.setOnCheckedChangeListener(this);
        binding.cbBlue.setOnCheckedChangeListener(this);
        binding.btClickMe.setOnClickListener(v -> {
            String text = "You selected - ";
            int initLength = text.length();
            if (binding.cbRed.isChecked()) text += "RED, ";
            if (binding.cbGreen.isChecked()) text += "Green, ";
            if (binding.cbBlue.isChecked()) text += "Blue, ";
            if (text.length() == initLength) text += "None";
            if (text.contains(",")) text = text.substring(0, text.lastIndexOf(","));
            binding.tvText.setText(text);
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == binding.cbRed.getId()) {
            Toast.makeText(this, "You checked red check box - " + isChecked, Toast.LENGTH_SHORT).show();
        } else if (buttonView.getId() == binding.cbGreen.getId()) {
            Toast.makeText(this, "You checked green check box - " + isChecked, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You checked blue check box - " + isChecked, Toast.LENGTH_SHORT).show();
        }
    }
}
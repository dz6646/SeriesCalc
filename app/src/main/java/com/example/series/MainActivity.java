package com.example.series;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    String serie[];
    Switch choose;
    EditText first;
    EditText progress;
    Intent si;
    Button pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choose = findViewById(R.id.series);
        first = findViewById(R.id.first);
        progress = findViewById(R.id.progress);
        pass = findViewById(R.id.pass);
        serie = new String[20];
        si = new Intent(this, resActivity.class);
    }

    public void changeTxt(View view) {
        if(choose.isChecked())
        {
            choose.setText("Math");
        }
        else
        {
            choose.setText("Engineering");
        }

    }

    public void pass2Sec(View view) {
        String temp = first.getText().toString();

        si.putExtra("chose", choose.isChecked());
        si.putExtra("first", Double.parseDouble(temp));
        temp = progress.getText().toString();
        si.putExtra("prog", Double.parseDouble(temp));
        startActivity(si);
    }
}
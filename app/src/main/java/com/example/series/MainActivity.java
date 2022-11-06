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
    String series[];
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
        series = new String[20];
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

        si.putExtra("choice", choose.isChecked());
        if(inputCheck(temp))
        {
            si.putExtra("first", Double.parseDouble(temp));
        }
        else
        {
            si.putExtra("first", 0);
        }
        temp = progress.getText().toString();
        if(inputCheck(temp))
        {
            si.putExtra("prog", Double.parseDouble(temp));
        }
        else
        {
            si.putExtra("prog", 0);
        }
        startActivity(si);
    }

    public boolean inputCheck(String st)
    {
        int i = 0;

        for(i = 0; i < st.length(); i++)
        {
            if((st.charAt(i) < '0' || st.charAt(i) > '9') && st.charAt(i) != '.')
            {
                return false;
            }
        }

        return true;
    }
}
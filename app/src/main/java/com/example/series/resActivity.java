package com.example.series;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class resActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Intent gi;
    double first, prog;
    boolean choice;
    String[] series = new String[20];
    TextView[] texts = new TextView[4];
    ListView lv;
    ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

        initArr();
        initTexts();

        lv = findViewById(R.id.serie);
        gi = getIntent();

        first = gi.getDoubleExtra("first", 0);
        prog = gi.getDoubleExtra("prog", 0);
        choice = gi.getBooleanExtra("choice", true);

        adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, series);
        lv.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);

        series[0] = String.valueOf(first);
        if(choice)
        {
            mathSeries();
        }
        else
        {
            engSeries();
        }

        lv.setAdapter(adp);
    }

    public void initArr()
    {
        int i = 0;

        for(i = 0; i < series.length; i++)
        {
            series[i] = null;
        }
    }

    public void mathSeries()
    {
        int i;
        Double temp;
        for(i = 1; i < series.length; i++)
        {
            temp = Double.parseDouble(series[i - 1]) + prog;
            series[i] = String.valueOf(temp);
        }
    }

    public void engSeries()
    {
        int i;
        Double temp;
        for(i = 1; i < series.length; i++)
        {
            temp = Double.parseDouble(series[i - 1]) * prog;
            series[i] = String.valueOf(temp);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

        int i = 0;
        double sum = Double.parseDouble(series[0]);

        for(i = 1; i < pos; i++)
        {
            sum += Double.parseDouble(series[i]);
        }

        texts[0].setText("X1: " + sum);
        texts[1].setText("d: " + prog);
        texts[2].setText("n: " + pos);
        texts[3].setText("Sn: " + series[pos]);
    }

    public void initTexts()
    {
        texts[0] = findViewById(R.id.X1);
        texts[1] = findViewById(R.id.d);
        texts[2] = findViewById(R.id.n);
        texts[3] = findViewById(R.id.SN);
    }
}


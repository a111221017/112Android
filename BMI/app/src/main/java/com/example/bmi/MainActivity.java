package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txvShow;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvShow = (TextView) findViewById(R.id.txvShow);
        txvShow.setTextSize(36);
        Button BtnCalc = (Button) findViewById(R.id.BtnCalc);
        Button BtnClear = (Button) findViewById(R.id.BtnClear);
        BtnCalc.setOnClickListener(this);
        BtnClear.setOnClickListener(this);
    }

    public  void onClick(View v){
        EditText edtHeight = (EditText) findViewById(R.id.edtHeight);
        EditText edtWeight = (EditText) findViewById(R.id.edtWeight);

        if (v.getId() == R.id.BtnCalc){
            double height = Double.parseDouble(edtHeight.getText().toString());
            double weight = Double.parseDouble(edtWeight.getText().toString());
            double bmi = weight / Math.pow(height/100.0,2);
            if (bmi >= 24)
                txvShow.setTextColor(Color.RED);
            else if (bmi < 18.5)
                txvShow.setTextColor(Color.BLUE);
            else
                txvShow.setTextColor(Color.GREEN);

            txvShow.setText(String.format("%.2f", bmi));
        }
        else {
            edtHeight.setText("0");
            edtWeight.setText("0");
            txvShow.setText("");

        }
    }
}
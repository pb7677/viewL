package com.example.viewl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LV2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView LV2;
    TextView TV1;
    TextView TV2;
    TextView TV3;
    TextView TV4;
    Double first;
    Double [] arr = new Double[20];
    Double sum=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv2);

        Intent Fi = getIntent();
        int Mog =Fi.getIntExtra("Mog",1);
        first = Fi.getDoubleExtra("FirstNum",2);
        Double MoA = Fi.getDoubleExtra("MoA",3);
        arr[0]= first;


        TV1 = findViewById(R.id.textView5);
        TV2 = findViewById(R.id.textView7);
        TV3 = findViewById(R.id.textView9);
        TV4 = findViewById(R.id.textView11);
        LV2 = findViewById(R.id.listV);

        for (int i=1;i<20;i++){
            if (Mog==1){
                arr[i]=arr[i-1]*MoA;
            }else {
                arr[i]=arr[i-1]+MoA;
            }
        }
        LV2.setOnItemClickListener(this);

        ArrayAdapter adp = new ArrayAdapter(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arr);
        LV2.setAdapter(adp);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TV1.setText(""+first);
        if (position==19){
            TV2.setText("cannot perform this action");
        }else {
            TV2.setText(""+(arr[position+1]-arr[position]));
        }
        TV3.setText(""+arr[position]);
        for (int g = 0;g<position;g++){
            sum = (Double) (sum+arr[g]);
        }
        TV4.setText(""+sum);
    }
}
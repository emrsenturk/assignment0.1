package com.example.sentrkk.helloandroidapp02;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        adapter.notifyDataSetChanged();
        refreshCounter();
        super.onRestoreInstanceState(savedInstanceState);
    }

    private ArrayAdapter<cow> adapter;
    private ArrayList<cow> lıstOfCows=new ArrayList<cow>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter=new ArrayAdapter<cow>(this,android.R.layout.simple_expandable_list_item_1,lıstOfCows);
        ListView lv=findViewById(R.id.listView);
        lv.setAdapter(adapter);

        //clear button
        final Button buttonclear = findViewById(R.id.button3);
        buttonclear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lıstOfCows.clear();
                refreshCounter();
                adapter.notifyDataSetChanged();
            }
        });

        //add button
        final Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText breeText = findViewById(R.id.breedField);
                EditText ıdText = findViewById(R.id.idField);

                //toast message for uygun olmayan input
                if (breeText.getText().toString().equals("") && !ıdText.getText().toString().equals("") ||
                        !breeText.getText().toString().equals("") && ıdText.getText().toString().equals("") ||
                         breeText.getText().toString().equals("") && ıdText.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(), "Provide both inputs ", Toast.LENGTH_SHORT).show();

                } else
                     {
                cow newCow = new cow(Integer.parseInt(breeText.getText().toString()), Integer.parseInt(ıdText.getText().toString()));
                lıstOfCows.add(newCow);
                adapter.notifyDataSetChanged();
                refreshCounter();
            }


            }
        });

        //reject button
        final Button buttonrej = findViewById(R.id.button2);
        buttonrej.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText breeText = findViewById(R.id.breedField);
                EditText ıdText = findViewById(R.id.idField);
                breeText.setText("");
                ıdText.setText("");

            }
        });

    }

    public void refreshCounter (){
        TextView tw=findViewById(R.id.cowsCounter);
        tw.setText(Integer.toString(lıstOfCows.size()));

    }

}


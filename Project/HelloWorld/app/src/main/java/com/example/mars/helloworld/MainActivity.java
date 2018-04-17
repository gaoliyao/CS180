package com.example.mars.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

//Bundle Intent
//ListView

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> names = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdd = (Button) findViewById(R.id.ButtonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv1 = (TextView) findViewById(R.id.tv1);
                String originalNumStr = tv1.getText().toString();
                int originalNum = Integer.parseInt(originalNumStr);
                int changedNum = originalNum + 1;
                String replaceStr = Integer.toString(changedNum);
                tv1.setText(replaceStr);
            }
        });

        Button buttonSub = (Button) findViewById(R.id.ButtonSub);
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv1 = (TextView) findViewById(R.id.tv1);
                String originalNumStr = tv1.getText().toString();
                int originalNum = Integer.parseInt(originalNumStr);
                int changedNum = originalNum - 1;
                String replaceStr = Integer.toString(changedNum);
                tv1.setText(replaceStr);
            }
        });

        Button buttonNew = (Button) findViewById(R.id.ButtonNewPage);
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                secondActivityIntent.putExtra("username1", 123);
                secondActivityIntent.putExtra("username2", 456);
                //key-value par
                startActivity(secondActivityIntent);
            }
        });
    }
}
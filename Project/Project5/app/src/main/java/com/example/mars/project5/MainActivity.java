package com.example.mars.project5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public static HashMap<String, Integer> nameAndCountMap = new HashMap<>();
    public static ListView mListView;
    public static ArrayAdapter adapter;
    public static ArrayList<String> nameList = new ArrayList<>();
    public static ArrayList<String> valueList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        mListView = (ListView) findViewById(R.id.recipe_list_view);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent counterActivity = new Intent(MainActivity.this, Counter.class);
                TextView tv = (TextView) view.findViewById(R.id.t);
                String name = (String) tv.getText();
                System.out.println(name);
                name = name.substring(0, name.indexOf(":"));
                counterActivity.putExtra("Name", name);
                counterActivity.putExtra("CountNum", Integer.toString(nameAndCountMap.get(name)));
                System.out.println(nameAndCountMap.get(name));
                startActivity(counterActivity);
            }
        });
// 1
        nameAndCountMap.put("New Counter", 0);
// 2
        Button buttonAuto = (Button) findViewById(R.id.buttonAuto);
        buttonAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (String str: nameAndCountMap.keySet()){
                    nameAndCountMap.put(str, nameAndCountMap.get(str)+1);
                }
                drawList(MainActivity.this);
            }
        });

        Button buttonAddNew = (Button) findViewById(R.id.buttonAddNew);
        buttonAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addNewActivity = new Intent(MainActivity.this, AddNew.class);
                startActivity(addNewActivity);
            }
        });
        drawList(this);
    }

    public static void drawList(Context context){
        String[] listItems = new String[nameAndCountMap.size()];
        int counter = 0;
        for (String str: nameAndCountMap.keySet()){
            listItems[counter] = str + ": " + Integer.toString(nameAndCountMap.get(str));
            counter++;
        }
        adapter = new ArrayAdapter<String>(context, R.layout.text, listItems);
        mListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

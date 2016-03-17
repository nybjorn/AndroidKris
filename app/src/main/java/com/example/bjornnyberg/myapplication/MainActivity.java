package com.example.bjornnyberg.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.bjornnyberg.myapplication.krisinfo.CapMessage;
import com.example.bjornnyberg.myapplication.krisinfo.KrisInfoResponse;
import com.example.bjornnyberg.myapplication.krisinfo.KrisInformationService;
import com.example.bjornnyberg.myapplication.krisinfo.RetrofitTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivity main;

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


        main = this;

        RetrofitTest retrofitTest = new RetrofitTest(new KrisInfoResponse() {
            @Override
            public void processFinish(List<CapMessage> messageList) {
                ListView lv = (ListView) findViewById(R.id.listView);

                List<String> your_array_list = new ArrayList<>();
                for (CapMessage krisInfo:messageList) {
                    your_array_list.add(krisInfo.getInfo().getDescription());
                }


                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        main,
                        android.R.layout.simple_list_item_1,
                        your_array_list);

                lv.setAdapter(arrayAdapter);

            }
        });

        retrofitTest.execute();


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

package com.zhangqie.flexboxlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zhangqie.flexboxlayout.activity.Demo1;
import com.zhangqie.flexboxlayout.activity.Demo2;
import com.zhangqie.flexboxlayout.activity.Demo3;
import com.zhangqie.flexboxlayout.activity.Demo4;


//https://github.com/google/flexbox-layout

public class MainActivity extends AppCompatActivity {

    String[] strings=new String[]{"demo1","demo2","demo3","demo4"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        listView= (ListView) findViewById(R.id.listview);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,strings);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                if (position == 0){
                    intent.setClass(MainActivity.this, Demo1.class);
                }else if(position == 1){
                    intent.setClass(MainActivity.this, Demo2.class);
                }else if (position ==2){
                    intent.setClass(MainActivity.this, Demo3.class);
                }else {
                    intent.setClass(MainActivity.this, Demo4.class);
                }
                startActivity(intent);
            }
        });
    }
}

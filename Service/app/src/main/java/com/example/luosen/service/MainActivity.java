package com.example.luosen.service;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Mydata mydata=new Mydata(this,"INFO",null,1);
        final ContentValues contentValues=new ContentValues();
        Button button=(Button)findViewById(R.id.button1);
        final EditText nameEdit=(EditText)findViewById(R.id.nameedit);
        final EditText idEdit=(EditText)findViewById(R.id.idedit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=mydata.getWritableDatabase();
                String name=nameEdit.getText().toString();
                String id=idEdit.getText().toString();
                contentValues.put("name",name);
                contentValues.put("id",id);
                db.insert("INFO",null,contentValues);
                contentValues.clear();
                /*SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                Log.d("提交时间",format.format(System.currentTimeMillis()));*/
                Intent intent1=new Intent(MainActivity.this,Myservice.class);
                startService(intent1);
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}

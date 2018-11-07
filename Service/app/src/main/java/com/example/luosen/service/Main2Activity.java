package com.example.luosen.service;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SQLiteDatabase db=openOrCreateDatabase("INFO",Context.MODE_PRIVATE,null);
        Cursor cursor=db.query("INFO",null,null,null,null,null,null);
        int k=0;
        if(cursor.moveToFirst()){
            do{
                String name=cursor.getString(cursor.getColumnIndex("name"));
                String id=cursor.getString(cursor.getColumnIndex("id"));
                TextView textView=new TextView(this);
                textView.setText(name+" "+id);
                textView.setId(k);
                textView.setClickable(true);
                LinearLayout linearLayout=(LinearLayout)findViewById(R.id.showlayout);
                linearLayout.addView(textView);
                k++;
            }while (cursor.moveToNext());
        }
        cursor.close();
        View deleteView=getWindow().getDecorView();
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.showlayout);
        for (int i=0;i<linearLayout.getChildCount();i++){
                final TextView textView=(TextView)linearLayout.getChildAt(i);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(Main2Activity.this);
                        builder.setTitle("删除数据");
                        builder.setMessage("确认删除?");
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SQLiteDatabase db1=openOrCreateDatabase("INFO",MODE_PRIVATE,null);
                                String [] strings=textView.getText().toString().split(" ");
                                String name=strings[0];
                                System.out.print(name);
                                db1.delete("INFO","name=?",new String[]{name});
                                startActivity(new Intent(Main2Activity.this,Main2Activity.class));
                                finish();
                            }
                        });
                        builder.show();
                    }
                });
        }
    }
}

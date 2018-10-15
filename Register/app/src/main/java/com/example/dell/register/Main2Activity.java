package com.example.dell.register;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_info);
        TextView textView5=(TextView)findViewById(R.id.text5);
        ArrayList<TextView> list=new ArrayList<TextView>();
        Resources resources=getResources();
        /*通过循环批量获取控件属性*/
        for(int i=0;i<6;i++){
            int id=resources.getIdentifier("text"+i,"id",getPackageName());
            TextView textView=(TextView) findViewById(id);
            list.add(textView);
        }
        Intent intent=getIntent();
        /*通过循环批量获取上一个活动通过Intent传递的数据*/
        for (int i=0;i<5;i++){
            list.get(i).setText(intent.getStringExtra(""+i));
        }
        textView5.setText(intent.getStringExtra("academic"));
        Button button1=(Button)findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

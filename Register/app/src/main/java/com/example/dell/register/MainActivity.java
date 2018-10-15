package com.example.dell.register;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import java.lang.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button1);
        /*
        * 通过适配器将资源文件加载到布局，实现输入的自动联想
        * */
        String [] academic=getResources().getStringArray(R.array.academic);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,academic);
        final AutoCompleteTextView autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.edit7);
        autoCompleteTextView.setAdapter(arrayAdapter);
        final ArrayList<EditText> editTexts=new ArrayList<EditText>();
        Resources resources=getResources();
        /*
        * 通过循环批量获取控件属性
        * */
        for(int i=0;i<7;i++){
            int id=resources.getIdentifier("edit"+i,"id",getPackageName());
            EditText editText=(EditText)findViewById(id);
            editTexts.add(editText);
        }
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*
                * 通过Intent将文本数据传向下一个活动
                * */
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("academic",autoCompleteTextView.getText().toString());
                for(int i=0;i<7;i++) {
                    intent.putExtra("" + i, editTexts.get(i).getText().toString());
                    /*
                    * 判断输入框是否为空，所限的为必填项
                    * */
                    if (editTexts.get(i).getText().toString().length() == 0) {
                        Toast toast = Toast.makeText(MainActivity.this, "内容不能为空！", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                    /*判断输入与确认密码是否一致*/
                    else if(editTexts.get(5).getText().toString().equals(editTexts.get(6).getText().toString())==false){
                        Toast toast=Toast.makeText(MainActivity.this,"密码内容不一致！",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }
                   else{
                       if(i==6) {
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}

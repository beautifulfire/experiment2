package com.example.hello.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        //TextView text1 = (TextView)findViewById(R.id.textView);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        //text1.setText(name);
        //Integer age=intent.getIntExtra("age", 20);
        Toast.makeText(this,name,Toast.LENGTH_LONG).show();

        Button bt1 = (Button) findViewById(R.id.button3);
        Button bt2 = (Button) findViewById(R.id.button4);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AnotherActivity.this);
        builder.setMessage("确认退出吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                AnotherActivity.this.finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    protected void dialog2() {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog, null);
        final EditText edit1 = layout.findViewById(R.id.Id);

        new AlertDialog.Builder(this).setTitle("传输文本框").setView(layout)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(AnotherActivity.this,MainActivity.class);

                        intent.putExtra("name",edit1.getText().toString());
                        startActivity(intent);
                        //setResult(0,intent);
                        //finish();
                    }
                })
                .setNegativeButton("取消", null)
                .show();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button3:
                dialog();
                break;
            case R.id.button4:
                dialog2();
                break;
            default:
                break;
        }
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

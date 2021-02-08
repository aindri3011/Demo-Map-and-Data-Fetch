package com.aindri.demomap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SwitchActivity extends AppCompatActivity {
Button bt_datafetch,bt_map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        bt_datafetch=findViewById(R.id.bt_datafetch);
        bt_map=findViewById(R.id.bt_map);


        bt_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
   Intent intent=new Intent(SwitchActivity.this,MainActivity.class);
   startActivity(intent);
   finish();
            }
        });

        bt_datafetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SwitchActivity.this,Datafetch.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(SwitchActivity.this);
        builder.setTitle("Alert!");
        builder.setMessage("Do to you want to exit?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }
}
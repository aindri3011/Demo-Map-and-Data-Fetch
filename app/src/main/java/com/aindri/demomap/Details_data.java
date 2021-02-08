package com.aindri.demomap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.aindri.demomap.Datafetch.EXTRA_ADDRESS;
import static com.aindri.demomap.Datafetch.EXTRA_CATEGORY;
import static com.aindri.demomap.Datafetch.EXTRA_CATEGORYID;
import static com.aindri.demomap.Datafetch.EXTRA_CONTACT;
import static com.aindri.demomap.Datafetch.EXTRA_DESCRIPTION;
import static com.aindri.demomap.Datafetch.EXTRA_EMPLOYEECODE;
import static com.aindri.demomap.Datafetch.EXTRA_ID;
import static com.aindri.demomap.Datafetch.EXTRA_NAME;
import static com.aindri.demomap.Datafetch.EXTRA_URL;

public class Details_data extends AppCompatActivity {
    TextView txt_id_detail,txt_name_detail,txt_category_detail,txt_contact_detail,txt_categoryId_detail,txt_address_detail,txt_descrip_detail,txt_employeecode_detail;
ImageView img_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_data);

        Intent intent=getIntent();
        String ID=intent.getStringExtra(EXTRA_ID);
        String NAME=intent.getStringExtra(EXTRA_NAME);
        String CATEGORY=intent.getStringExtra(EXTRA_CATEGORY);
        String CATEGORYID=intent.getStringExtra(EXTRA_CATEGORYID);
        String ADDRESS=intent.getStringExtra(EXTRA_ADDRESS);
        String DESCRIPTION=intent.getStringExtra(EXTRA_DESCRIPTION);
        String CONTACT=intent.getStringExtra(EXTRA_CONTACT);
        String EMPLOYEECODE=intent.getStringExtra(EXTRA_EMPLOYEECODE);
        String imageUrl=intent.getStringExtra(EXTRA_URL);


        txt_name_detail=findViewById(R.id.txt_name_detail);
        txt_id_detail=findViewById(R.id.txt_id_detail);
        txt_category_detail=findViewById(R.id.txt_category_detail);
        txt_contact_detail=findViewById(R.id.txt_contact_detail);
        txt_categoryId_detail=findViewById(R.id.txt_categoryId_detail);
        txt_address_detail=findViewById(R.id.txt_address_detail);
        txt_descrip_detail=findViewById(R.id.txt_descrip_detail);
        txt_employeecode_detail=findViewById(R.id.txt_employeecode_detail);
        img_detail=findViewById(R.id.img_detail);


        txt_id_detail.setText(ID);
        txt_name_detail.setText(NAME);
        txt_category_detail.setText(CATEGORY);
        txt_categoryId_detail.setText(CATEGORYID);
        txt_address_detail.setText(ADDRESS);
        txt_descrip_detail.setText(DESCRIPTION);
        txt_contact_detail.setText(CONTACT);
        txt_employeecode_detail.setText(EMPLOYEECODE);
        Glide.with(this).load(imageUrl).into(img_detail);
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Details_data.this,SwitchActivity.class);
        startActivity(intent);
    }

    }

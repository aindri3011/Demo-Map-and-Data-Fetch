package com.aindri.demomap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.ClickableSpan;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class Datafetch extends AppCompatActivity implements DataInsertAdapter.OnItemClickListener {

    public static final String EXTRA_ID="ID";
    public static final String EXTRA_NAME="NAME";
    public static final String EXTRA_CATEGORY="CATEGORY";
    public static final String EXTRA_CATEGORYID="CATEGORYID";
    public static final String EXTRA_ADDRESS="ADDRESS";
    public static final String EXTRA_DESCRIPTION="DESCRIPTION";
    public static final String EXTRA_CONTACT="CONTACT";
    public static final String EXTRA_EMPLOYEECODE="EMPLOYEECODE";
    public static final String EXTRA_URL="imageUrl";


    Retrofit retrofit;

    RecyclerView reclycler1;
    ArrayList<Model>arrayList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datafetch);

        reclycler1=findViewById(R.id.recycler1);
        arrayList=new ArrayList<>();


        retrofit=new Retrofit.Builder()
                .baseUrl("Put raw url part here")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetroApi retroApi=retrofit.create(RetroApi.class);


        Call<List<Model>> call=retroApi.getListData();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
          if(response.code()==200){
              List<Model> datas=response.body();
              for(Model data:datas){
//                  String responseTest="";
//                  responseTest +=data.getId();

//                  int k=data.getId();
//                  String name=data.getName();
//                  String category=data.getCategory();
//                  int  categoryid=data.getCategoryid();
//                  String address=data.getAddress();
//                  String description=data.getDescription();
//                  String contact=data.getContact();
//                  String empcode=data.getEmpcode();
//                  int image=data.getImage();

                  arrayList.add(data);


              }
              PutDataIntoRecyclerView(arrayList);
          }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }

    private void PutDataIntoRecyclerView(ArrayList<Model> arrayList) {
        DataInsertAdapter dataInsertAdapter=new DataInsertAdapter(arrayList,Datafetch.this);
        reclycler1.setLayoutManager(new LinearLayoutManager(this));
        reclycler1.setAdapter(dataInsertAdapter);
        dataInsertAdapter.setOnItemClickListener(Datafetch.this);

    }


    @Override
    public void onItemClick(int position) {
        Intent detailIntent=new Intent(this,Details_data.class);
        Model clickedItem=arrayList.get(position);

        detailIntent.putExtra(EXTRA_ID,clickedItem.getId());
        detailIntent.putExtra(EXTRA_NAME,clickedItem.getName());
        detailIntent.putExtra(EXTRA_CATEGORY,clickedItem.getCategory());
        detailIntent.putExtra(EXTRA_CATEGORYID,clickedItem.getCategoryid());
        detailIntent.putExtra(EXTRA_ADDRESS, clickedItem.getAddress());
        detailIntent.putExtra(EXTRA_DESCRIPTION,clickedItem.getDescription());
        detailIntent.putExtra(EXTRA_CONTACT,clickedItem.getDescription());
        detailIntent.putExtra(EXTRA_EMPLOYEECODE,clickedItem.getEmpcode());
        detailIntent.putExtra(EXTRA_URL,clickedItem.getImage());

        startActivity(detailIntent);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Datafetch.this,SwitchActivity.class);
        startActivity(intent);
    }
}




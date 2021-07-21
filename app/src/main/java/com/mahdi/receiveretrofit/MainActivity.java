package com.mahdi.receiveretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import com.mahdi.receiveretrofit.api.Api;
import com.mahdi.receiveretrofit.api.RetrofitClient;
import com.mahdi.receiveretrofit.recyclerview.adapters.CustomAdabter;
import com.mahdi.receiveretrofit.recyclerview.model.Model;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private List<Model> list1;
    private RecyclerView recyclerView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView1 = findViewById(R.id.recyclerView1);


        Api api = RetrofitClient.getApiServices();
        Call<List<Model>> call = api.getListCall();


        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                try {
                    recyclerView1.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    list1 = response.body();
                    recyclerView1.setAdapter(new CustomAdabter(MainActivity.this, list1));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });


    }




}
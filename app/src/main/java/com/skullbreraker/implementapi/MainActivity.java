package com.skullbreraker.implementapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.skullbreraker.implementapi.Adapter.FreeGameAdapter;
import com.skullbreraker.implementapi.Api.ApiEndPoint;
import com.skullbreraker.implementapi.Api.ApiService;
import com.skullbreraker.implementapi.Model.FreeGameModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//    Tanggal Pengerjaan : 5 - 14 Juli 2022
//    NIM : 10119213
//    Nama : Tri Tafriyadi
//    Kelas : IF6

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = BuildConfig.API_KEY;
    private FreeGameAdapter viewAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner List = findViewById(R.id.spinner);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Daftar Game Gratis");

        viewAdapter = new FreeGameAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView = findViewById(R.id.recyclerFreegame);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(viewAdapter);

        Button Submit = findViewById(R.id.submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDataFreeGame(List.getSelectedItem().toString());
            }
        });
    }
    private void loadDataFreeGame(String list) {
        ApiService api = ApiEndPoint.getClient().create(ApiService.class);
        Call<List<FreeGameModel>> call = api.groupList(API_KEY,list);
        call.enqueue(new Callback<List<FreeGameModel>>() {
            @Override
            public void onResponse(Call<List<FreeGameModel>> call, Response<List<FreeGameModel>> response) {
                viewAdapter.setFreeGameModelList(response.body());
            }

            @Override
            public void onFailure(Call<List<FreeGameModel>> call, Throwable t) {

            }
        });
    }

}
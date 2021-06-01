package com.example.loginpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginpage.models.Badges;
import com.example.loginpage.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsigniasActivity extends AppCompatActivity {
    private Usuario user;
    public View view;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insignias);

        user = UserInstance.getInstance().getUser();
        view = findViewById(android.R.id.content).getRootView();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view2);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Call<List<Badges>> badges = MyApiAdapter.getApiService().getBadges();
        badges.enqueue(new Callback<List<Badges>>() {
            @Override
            public void onResponse(Call<List<Badges>> call, Response<List<Badges>> response) {
                mAdapter = new MyAdapter(response.body());
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Badges>> call, Throwable throwable) {

            }
        });

    }

    public void onClickBackIns(View v){
        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
    }
}

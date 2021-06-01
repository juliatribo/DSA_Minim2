package com.example.loginpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginpage.models.Usuario;

public class PerfilActivity extends AppCompatActivity {
    private Usuario user;
    public View view;
    TextView name;
    TextView userText;
    ImageView image;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);

        user = UserInstance.getInstance().getUser();

        view = findViewById(android.R.id.content).getRootView();

        name = view.findViewById(R.id.nameTextView);
        userText = view.findViewById(R.id.userTextView);
        //image = view.findViewById(R.id.imageView1);

        String nameText = String.valueOf(user.getName()+" "+user.getSurname());
        name.append(nameText);

        String userid = String.valueOf(user.getId());
        userText.append(userid);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view2);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(user.getBadgesList());
        recyclerView.setAdapter(mAdapter);

    }

    public void onClickBackPerf(View v){
        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
    }
}

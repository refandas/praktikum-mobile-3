package com.example.tugaskedua;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHero;
    private ArrayList<ModelHero> heroes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewHero = findViewById(R.id.recycle_hero);
        recyclerViewHero.setHasFixedSize(true);

        heroes.addAll(DataHero.getListDetail());
        showRecycler();
    }

    private void showRecycler() {
        recyclerViewHero.setLayoutManager(new LinearLayoutManager(this));
        AdapterHero adapterHero = new AdapterHero(heroes);
        adapterHero.setListHero(heroes);
        recyclerViewHero.setAdapter(adapterHero);

        adapterHero.setOnItemClickCallback(new AdapterHero.OnItemClickCallback() {
            @Override
            public void onItemClicked(ModelHero hero) {
                Toast.makeText(MainActivity.this, "Memilih " + hero.getHeroName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_DATA, (Parcelable) hero);
                startActivity(intent);
            }
        });
    }
}

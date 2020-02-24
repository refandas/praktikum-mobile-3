package com.example.tugaskedua;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_DATA = "extra_data";
    private ImageView adivHeroPhoto;
    private TextView adtvHeroName, adtvHeroDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        adivHeroPhoto   = findViewById(R.id.adiv_hero_image);
        adtvHeroName    = findViewById(R.id.adtv_hero_name);
        adtvHeroDesc    = findViewById(R.id.adtv_hero_desc);

        ModelHero hero = getIntent().getParcelableExtra(EXTRA_DATA);
        int image       = hero.getHeroImage();
        String name     = hero.getHeroName();
        String desc     = hero.getHeroDesc();

        if (hero != null) {
            Glide.with(this).load(image).into(adivHeroPhoto);
            adtvHeroName.setText(name);
            adtvHeroDesc.setText(desc);
        }
    }
}

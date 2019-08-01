package com.example.f19.fuadmz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void instagram (View view){
        Intent igIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/blackcube.std/"));
        startActivity(igIntent);
    }
    public void lokasi (View view){
        Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/place/6%C2%B035'45.4%22S+110%C2%B041'07.2%22E/@-6.5986981,110.6839351,15.96z/data=!4m5!3m4!1s0x0:0x0!8m2!3d-6.5959294!4d110.6853204?hl=en3");
        Intent lokasiIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        lokasiIntent.setPackage("com.google.android.apps.maps");
        startActivity(lokasiIntent);
    }

    public void panggil(View view) {
        String nomor = "08586043946" ;
        Intent panggil = new Intent(Intent. ACTION_DIAL);
        panggil.setData(Uri. fromParts("tel",nomor,null));
        startActivity(panggil);
    }

}

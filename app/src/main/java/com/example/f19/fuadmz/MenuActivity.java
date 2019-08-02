package com.example.f19.fuadmz;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.WindowManager;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void btnProfil (View view){
        Intent profil = new Intent(MenuActivity.this, ProfileActivity.class);
        startActivity(profil);
    }

    public void btnBranding (View view){
        Intent branding = new Intent(MenuActivity.this, BrandingActivity.class);
        startActivity(branding);
    }
    public void btnComingSoon (View view){
        Intent cs = new Intent(MenuActivity.this, ComingSonActivity.class);
        startActivity(cs);
    }

}

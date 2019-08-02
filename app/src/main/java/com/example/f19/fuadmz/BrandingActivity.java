package com.example.f19.fuadmz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandingActivity extends AppCompatActivity {

    private GridLayoutManager gridLayoutManager;
    private BrandingAdapter brandingAdapter;
    private List<BrandingModel> mItems = new ArrayList<>();
    private RecyclerView rView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branding);
        ButterKnife.bind(this);

        gridLayoutManager = new GridLayoutManager(BrandingActivity.this, 1, GridLayoutManager.VERTICAL, false);
        rView = (RecyclerView) findViewById(R.id.rv_banding);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(gridLayoutManager);

        brandingAdapter = new BrandingAdapter(mItems, BrandingActivity.this);
        rView.setAdapter(brandingAdapter);


        loadDataBranding();

    }

    public void loadDataBranding(){
        ApiService api = ApiEndPoint.getClient().create(ApiService.class);

        Call<ResBranding> call = api.getBranding();
        call.enqueue(new Callback<ResBranding>() {
            @Override
            public void onResponse(Call<ResBranding> call, Response<ResBranding> response) {
                String statusCode = response.body().getStatus_code();

                progressBar.setVisibility(View.GONE);
                if (statusCode.equals("200")) {
                    mItems = response.body().getResult();
                    brandingAdapter = new BrandingAdapter(mItems, BrandingActivity.this);
                    rView.setAdapter(brandingAdapter);
                }

            }

            @Override
            public void onFailure(Call<ResBranding> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(BrandingActivity.this, "Oops, your connection is WONGKY! ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void btnProfil (View view){
        Intent profil = new Intent(BrandingActivity.this, ProfileActivity.class);
        startActivity(profil);
    }

}

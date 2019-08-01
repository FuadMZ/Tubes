package com.example.f19.fuadmz;



import retrofit2.Call;
import retrofit2.http.GET;
import com.example.f19.fuadmz.ResBranding;

public interface ApiService {

    @GET("android_get_branding.php")
    Call<ResBranding> getBranding();
}

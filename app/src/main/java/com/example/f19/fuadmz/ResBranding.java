package com.example.f19.fuadmz;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResBranding {
    List<BrandingModel> result;
    @SerializedName("status_code")
    private String status_code;
    @SerializedName("message")
    private String message;

    public List<BrandingModel> getResult(){
        return  result;
    }

    public void setResult(List<BrandingModel> result){
        this.result = result;
    }

    public ResBranding(String status_code, String message) {
        this.status_code = status_code;
        this.message = message;
    }

    public String getStatus_code() {
        return status_code;
    }

    public String getMessage() {
        return message;
    }
}

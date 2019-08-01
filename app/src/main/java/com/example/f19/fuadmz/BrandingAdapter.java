package com.example.f19.fuadmz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class BrandingAdapter extends RecyclerView.Adapter<BrandingAdapter.ViewHolder> {

    private List<BrandingModel> brandingModels;
    private Context context;

    public BrandingAdapter(List<BrandingModel> bandingModels, Context context) {
        this.brandingModels = bandingModels;
        this.context = context;
    }

    @NonNull
    @Override
    public BrandingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_branding_recycler, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandingAdapter.ViewHolder viewHolder, int i) {

        viewHolder.nama_branding.setText(brandingModels.get(i).getNama_branding());
        viewHolder.desc_banding.setText(brandingModels.get(i).getDesc_branding());
        Glide.with(context).load(brandingModels.get(i).getFoto_branding()).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.foto_branding);

    }

    @Override
    public int getItemCount() {
        return brandingModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView foto_branding;
        TextView desc_banding,nama_branding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foto_branding = itemView.findViewById(R.id.imagebranding);
            desc_banding = itemView.findViewById(R.id.desc_banding);
            nama_branding = itemView.findViewById(R.id.nama_banding);

        }
    }
}

package com.skullbreraker.implementapi.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.skullbreraker.implementapi.Model.FreeGameModel;
import com.skullbreraker.implementapi.R;

import java.util.List;

//    Tanggal Pengerjaan : 5 - 14 Juli 2022
//    NIM : 10119213
//    Nama : Tri Tafriyadi
//    Kelas : IF6

public class FreeGameAdapter extends RecyclerView.Adapter<FreeGameAdapter.MyHolder> {
    private final Context context;
    private List<FreeGameModel> freeGameModelList;

    public FreeGameAdapter(Context context){this.context =context;}

    @SuppressLint("NotifyDataSetChanged")
    public void setFreeGameModelList(List<FreeGameModel> freeGameModelList) {
        this.freeGameModelList = freeGameModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.title.setText(this.freeGameModelList.get(position).getTitle());
        holder.gameurl.setText(this.freeGameModelList.get(position).getGameUrl());
        holder.releasedate.setText(this.freeGameModelList.get(position).getReleaseDate());
        holder.platform.setText(this.freeGameModelList.get(position).getPlatform());
        holder.shortdesc.setText((this.freeGameModelList.get(position).getShortDescription()));

        String url = this.freeGameModelList.get(position).getThumbnail();
        Glide.with(context)
                .load(url)
                .fitCenter()
                .centerCrop()
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        if (freeGameModelList == null) {
            return 0;
        }
        return this.freeGameModelList.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder{
        TextView title,shortdesc,platform,releasedate,gameurl;
        ImageView thumbnail;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            shortdesc = itemView.findViewById(R.id.txtShortDesc);
            platform = itemView.findViewById(R.id.txtPlatform);
            releasedate = itemView.findViewById(R.id.txtReleaseDate);
            gameurl = itemView.findViewById(R.id.txtGameUrl);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}

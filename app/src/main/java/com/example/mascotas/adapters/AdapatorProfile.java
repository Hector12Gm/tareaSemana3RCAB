package com.example.mascotas.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mascotas.R;
import com.example.mascotas.pojo.Pet;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapatorProfile extends  RecyclerView.Adapter<AdapatorProfile.VistaVieja> {

    ArrayList<Pet> mascotas;

    public  AdapatorProfile (ArrayList<Pet> mascotas){
        this.mascotas=mascotas;

    }
    @NonNull
    @Override
    public VistaVieja onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_petp,parent,false);
        return  new AdapatorProfile.VistaVieja  (view);
    }

    @Override
    public void onBindViewHolder(@NonNull VistaVieja holder, int position) {
        Pet mascota = this.mascotas.get(position);
        holder.tvPetnameP.setText(mascota.getNombre());
        holder.tvCountP.setText(Integer.toString(mascota.getLikes()));
        holder.tvImgV.setImageResource(mascota.getImg());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static  class VistaVieja extends RecyclerView.ViewHolder{

        private TextView tvPetnameP;
        private TextView tvCountP;
        private ImageView tvImgV;

        public VistaVieja(@NonNull View itemView) {
            super(itemView);
            this.tvPetnameP = ( TextView ) itemView.findViewById( R.id.tvPetnameP );
            this.tvCountP = ( TextView ) itemView.findViewById( R.id.tvLikesPetItemP );
            this.tvImgV = ( ImageView ) itemView.findViewById( R.id.imgPetP );

        }
    }
}

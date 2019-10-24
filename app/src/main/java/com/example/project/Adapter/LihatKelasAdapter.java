package com.example.project.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Model.LihatKelas;
import com.example.project.R;

import java.util.ArrayList;

public class LihatKelasAdapter extends RecyclerView.Adapter<LihatKelasAdapter.ViewHolder> {
    private ArrayList<LihatKelas>lihatKelasAdapterArrayList;
    public LihatKelasAdapter(ArrayList<LihatKelas>lihatKelasAdapterArrayList){
        this.lihatKelasAdapterArrayList=lihatKelasAdapterArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.card_view_lihat_kelas,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtKode.setText(lihatKelasAdapterArrayList.get(position).getKodeMatkulKls());
        holder.txtMatkul.setText(lihatKelasAdapterArrayList.get(position).getMatkulKls());
        holder.txtHari.setText(lihatKelasAdapterArrayList.get(position).getHariKls());
        holder.txtSesi.setText(lihatKelasAdapterArrayList.get(position).getSesiKLs());
        holder.txtDosen.setText(lihatKelasAdapterArrayList.get(position).getDosenPengampuKls());
        holder.txtJmlMhs.setText(lihatKelasAdapterArrayList.get(position).getJmlMhsKls());
    }

    @Override
    public int getItemCount() {
        return (lihatKelasAdapterArrayList !=null)?lihatKelasAdapterArrayList.size():0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtKode,txtMatkul,txtHari,txtSesi,txtDosen,txtJmlMhs;

        public ViewHolder(View view) {
            super(view);
            txtKode = view.findViewById(R.id.txtKodeMatkulLhtKls);
            txtMatkul=view.findViewById(R.id.txtMatkulLhtKls);
            txtHari = view.findViewById(R.id.txtHariLhtKls);
            txtSesi=view.findViewById(R.id.txtSesiLhtKls);
            txtDosen=view.findViewById(R.id.txtDosenPengampiLhtKls);
            txtJmlMhs=view.findViewById(R.id.txtJmlMhsLhtKls);
        }
    }
}

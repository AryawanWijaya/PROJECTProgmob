package com.example.project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.CRUDDosenAdminActivity;
import com.example.project.CRUDKrs;
import com.example.project.Model.KRS;
import com.example.project.R;

import java.util.ArrayList;

public class KRSAdapter extends RecyclerView.Adapter<KRSAdapter.ViewHolder> {
    private Context context;
    private ArrayList<KRS>krsArrayList;
    public KRSAdapter(ArrayList<KRS>krsArrayList1){
        this.krsArrayList=krsArrayList1;
    }

    @NonNull
    @Override
    public KRSAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.card_view_krs,parent,false);
        context =parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KRSAdapter.ViewHolder holder, int position) {
        holder.txtKodeMatkul.setText(krsArrayList.get(position).getKodeMatkul());
        holder.txtMatkul.setText(krsArrayList.get(position).getNamaMatkul());
        holder.txtHari.setText(krsArrayList.get(position).getHari());
        holder.txtSesi.setText(krsArrayList.get(position).getSesi());
        holder.txtJmlSks.setText(krsArrayList.get(position).getJumlahSKS());
        holder.txtDosenPengampu.setText(krsArrayList.get(position).getDosenPengampu());
        holder.txtJmlMhs.setText(krsArrayList.get(position).getJumlahMhs());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context!=null){
                    Intent intent = new Intent(context, CRUDKrs.class);
                    context.startActivities(new Intent[]{intent});
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (krsArrayList !=null)?krsArrayList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtKodeMatkul,txtMatkul,txtSesi,txtHari, txtJmlSks, txtDosenPengampu, txtJmlMhs;
        private CardView cv;
        public ViewHolder(View view){
            super(view);
            txtKodeMatkul =view.findViewById(R.id.txtKodeMatkul);
            txtMatkul = view.findViewById(R.id.txtMatkul);
            txtHari=view.findViewById(R.id.txtHari);
            txtSesi = view.findViewById(R.id.txtSesiMatkulCRUD);
            txtJmlSks=view.findViewById(R.id.txtJmlSks);
            txtDosenPengampu=view.findViewById(R.id.txtDosenPengampu);
            txtJmlMhs=view.findViewById(R.id.txtJmlMhs);
            cv=view.findViewById(R.id.cvKrs);
        }
    }
}




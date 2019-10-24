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

import com.example.project.CRUDKrs;
import com.example.project.CRUDMatkul;
import com.example.project.Model.Matkul;
import com.example.project.R;

import java.util.ArrayList;

public class MatkulAdapter  extends RecyclerView.Adapter<MatkulAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Matkul>matkulArrayList;
    public  MatkulAdapter(ArrayList<Matkul>matkulArrayList){
        this.matkulArrayList=matkulArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.card_view_matkul,parent,false);
        context =parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtKodeMatkul.setText(matkulArrayList.get(position).getKodeMatkul());
        holder.txtMatkul.setText(matkulArrayList.get(position).getNamaMatkul());
        holder.txtHari.setText(matkulArrayList.get(position).getHari());
        holder.txtSesi.setText(matkulArrayList.get(position).getSesi());
        holder.txtJmlSks.setText(matkulArrayList.get(position).getJumlahSKS());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context!=null){
                    Intent intent = new Intent(context, CRUDMatkul.class);
                    context.startActivities(new Intent[]{intent});
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (matkulArrayList !=null)?matkulArrayList.size():0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtKodeMatkul,txtMatkul,txtSesi,txtHari, txtJmlSks;
        private CardView cv;
        public ViewHolder(View view){
            super(view);
            txtKodeMatkul =view.findViewById(R.id.txtKodeMatkulMATKUL);
            txtMatkul = view.findViewById(R.id.txtMatkulMATKUL);
            txtHari=view.findViewById(R.id.txtHariMATKUL);
            txtSesi = view.findViewById(R.id.txtSesiMATKUL);
            txtJmlSks=view.findViewById(R.id.txtJmlSksMATKUL);
            cv=view.findViewById(R.id.cvMatkul);
    }
}

}

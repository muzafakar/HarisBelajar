package com.muzadev.akisdummy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muzadev.akisdummy.R;
import com.muzadev.akisdummy.model.Kelas;
import com.muzadev.akisdummy.util.AppParams;
import com.muzadev.akisdummy.view.SiswaActivity;

import java.util.ArrayList;
import java.util.List;

public class AdpKelas extends RecyclerView.Adapter<AdpKelas.ViewHolder> {
    private Context context;
    private List<Kelas> dataKelas;

    public AdpKelas(Context context) {
        this.context = context;
        dataKelas = new ArrayList<>();
    }

    public void setData(List<Kelas> data) {
        dataKelas.clear();
        dataKelas.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_kelas, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(dataKelas.get(position));
    }

    @Override
    public int getItemCount() {
        return dataKelas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvClassName, tvTeacherName, tvStudentCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvClassName = itemView.findViewById(R.id.tvClassName);
            tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
            tvStudentCount = itemView.findViewById(R.id.tvStudentCount);
        }

        public void bindView(final Kelas kelas) {
            tvClassName.setText(kelas.getIdKelasJurusan());
            tvTeacherName.setText(kelas.getNama());
            tvStudentCount.setText(kelas.getJumlah() + " Siswa");

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SiswaActivity.class);
                    intent.putExtra(AppParams.IDKELAS, kelas.getIdKelasJurusan());
                    context.startActivity(intent);
                }
            });
        }
    }
}

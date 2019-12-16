package com.muzadev.akisdummy.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.muzadev.akisdummy.R;
import com.muzadev.akisdummy.model.Siswa;
import com.muzadev.akisdummy.view.AllStudentsActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AdpSiswa extends RecyclerView.Adapter<AdpSiswa.ViewHolder> {
    private Context context;
    private List<Siswa> dataSiswa;
    private List<Siswa> tempSiswa;
    private boolean isForShowDetail;

    public AdpSiswa(Context context, boolean isForShowDetail) {
        this.context = context;
        this.isForShowDetail = isForShowDetail;
        dataSiswa = new ArrayList<>();
        tempSiswa = new ArrayList<>();
    }

    public void setData(List<Siswa> data) {
        dataSiswa.clear();
        dataSiswa.addAll(data);
        tempSiswa.clear();
        tempSiswa.addAll(data);
        notifyDataSetChanged();
    }

    public void searchData(final String query) {
        if (query.length() == 0) {
            dataSiswa.clear();
            dataSiswa.addAll(tempSiswa);
        } else {
            Predicate<Siswa> siswaPredicate = new Predicate<Siswa>() {
                @Override
                public boolean test(Siswa siswa) {
                    return siswa.getNamaLengkap().toLowerCase().contains(query.toLowerCase()) || siswa.getNisn().contains(query);
                }
            };

            dataSiswa.clear();
            List<Siswa> filtered = tempSiswa.stream().filter(siswaPredicate).collect(Collectors.<Siswa>toList());
            dataSiswa.addAll(filtered);
        }

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_siswa, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(dataSiswa.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSiswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvClassName, tvTeacherName, tvStudentCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvClassName = itemView.findViewById(R.id.tvStudentName);
            tvTeacherName = itemView.findViewById(R.id.tvStudentNumber);
            tvStudentCount = itemView.findViewById(R.id.tvStudentGender);
        }

        public void bindView(final Siswa siswa) {
            tvClassName.setText(siswa.getNamaLengkap());
            tvTeacherName.setText(siswa.getNisn());

            String gender;
            if (siswa.getJk().equals("P")) {
                gender = "Perempuan";
            } else {
                gender = "Laki-Laki";

            }
            tvStudentCount.setText(gender);
            if (isForShowDetail) {
                /*on clicknya beda*/
                ((ConstraintLayout) tvClassName.getParent()).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "ggwp", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                ((ConstraintLayout) tvClassName.getParent()).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("NAMA", siswa.getNamaLengkap());
                        intent.putExtra("NISN", siswa.getNisn());
                        ((AllStudentsActivity) context).setResult(Activity.RESULT_OK, intent);
                        ((AllStudentsActivity) context).finish();
                    }
                });
            }
        }
    }
}

package com.tuna.finall.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuna.finall.Loai2.Loai2_edit;
import com.tuna.finall.Loai2.SinhVienv2;
import com.tuna.finall.R;
import com.tuna.finall.database.SinhVienv2DAO;

import java.util.List;

public class SinhVienv2Adapter extends BaseAdapter {

    List<SinhVienv2> arrSV;
    public Activity context;
    public LayoutInflater inflater;
    SinhVienv2DAO svDAO;

    public SinhVienv2Adapter(Activity context, List<SinhVienv2> arrSV) {
        super();
        this.context = context;
        this.arrSV = arrSV;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        svDAO = new SinhVienv2DAO(context);
    }

    @Override
    public int getCount() {
        return arrSV.size();
    }

    @Override
    public Object getItem(int position) {
        return arrSV.get(position);
    }

    public static class ViewHolder {
        TextView tvMaSV;
        TextView tvTenSV;
        TextView tvQueQuan;
        ImageView imgEdit, imgDelete;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_sinh_vien, null);
            holder.tvMaSV = convertView.findViewById(R.id.tvMaSV);
            holder.tvTenSV = convertView.findViewById(R.id.tvTenSV);
            holder.tvQueQuan = convertView.findViewById(R.id.tvQueQuan);

            holder.imgEdit = convertView.findViewById(R.id.imgEdit);
            holder.imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, Loai2_edit.class);
                    Bundle b = new Bundle();
                    b.putString("ID", arrSV.get(position).getmMaSV());
                    b.putString("Name", arrSV.get(position).getmName());
                    b.putString("QueQuan", arrSV.get(position).getmQueQuan());
                    intent.putExtras(b);
                    context.startActivity(intent);
                }
            });

            holder.imgDelete = convertView.findViewById(R.id.imgDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Message");
                    builder.setMessage("Do you want delete this item ?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            svDAO.deleteSinhVien(arrSV.get(position).getmMaSV());
                            arrSV.remove(position);
                            notifyDataSetChanged();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.show();
                }
            });
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        SinhVienv2 _entry = (SinhVienv2) arrSV.get(position);
        holder.tvMaSV.setText(_entry.getmMaSV());
        holder.tvTenSV.setText(_entry.getmName());
        holder.tvQueQuan.setText(_entry.getmQueQuan());
        return convertView;
    }



    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDatasetSinhVien(List<SinhVienv2> items) {
        this.arrSV = items;
        notifyDataSetChanged();
    }
}

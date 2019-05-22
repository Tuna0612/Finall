package com.tuna.finall.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuna.finall.Loai1.Loai1;
import com.tuna.finall.Loai1.SinhVienv1;
import com.tuna.finall.R;
import com.tuna.finall.database.SinhVienv1Dao;

import java.util.List;

public class SinhVienv1Adapter extends ArrayAdapter<SinhVienv1> {

    private Context context;
    private int resoure;
    private List<SinhVienv1> listStudent;

    public SinhVienv1Adapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<SinhVienv1> objects) {
        super(context, resource, objects);
        this.context= context;
        this.resoure=resource;
        this.listStudent=objects;
    }

    public class ViewHolder{

        private TextView tvMaSV;
        private TextView tvName;
        private TextView tvAddress;
        private ImageView imgDelete;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_sinh_vien,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvMaSV = (TextView)convertView.findViewById(R.id.tvMaSV);
            viewHolder.tvName = (TextView)convertView.findViewById(R.id.tvTenSV);
            viewHolder.tvAddress = (TextView)convertView.findViewById(R.id.tvQueQuan);


            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SinhVienv1 student = listStudent.get(position);
        viewHolder.tvMaSV.setText(String.valueOf(student.getmMaSV()));
        viewHolder.tvName.setText(student.getmName());
        viewHolder.tvAddress.setText(student.getmQueQuan());

        return convertView;
    }
}

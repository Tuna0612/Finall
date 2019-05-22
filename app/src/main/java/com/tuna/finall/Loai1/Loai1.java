package com.tuna.finall.Loai1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.tuna.finall.Loai2.Loai2;
import com.tuna.finall.Loai2.Loai2_list;
import com.tuna.finall.Loai2.SinhVienv2;
import com.tuna.finall.R;
import com.tuna.finall.adapter.SinhVienv1Adapter;
import com.tuna.finall.database.DatabaseManager;
import com.tuna.finall.database.SinhVienv1Dao;
import com.tuna.finall.database.SinhVienv2DAO;

import java.util.ArrayList;
import java.util.List;

public class Loai1 extends AppCompatActivity {
    private EditText maSV;
    private EditText tenSV;
    private EditText quequan;
    private ListView lvStudent;
    private SinhVienv1Dao svDAO;
    private SinhVienv1Adapter adapter;
    private DatabaseManager db;
    private List<SinhVienv1> svList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai1);
        db = new DatabaseManager(this);
        initView();

        svList = svDAO.getAllSinhVien();
        setAdapter();

        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SinhVienv1 student = svList.get(position);
                maSV.setText(String.valueOf(student.getmMaSV()));
                tenSV.setText(student.getmName());
                quequan.setText(student.getmQueQuan());
                maSV.setEnabled(false);
            }
        });

        lvStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SinhVienv1 student = svList.get(position);
                int result = svDAO.deleteSinhVien(student.getmMaSV());
                if (result > 0) {
                    Toast.makeText(Loai1.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    updateListStudent();
                } else {
                    Toast.makeText(Loai1.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    private void initView() {
        maSV = (EditText) findViewById(R.id.maSV);
        tenSV = (EditText) findViewById(R.id.tenSV);
        quequan = (EditText) findViewById(R.id.quequan);
        lvStudent = (ListView) findViewById(R.id.lvStudent);
        svDAO = new SinhVienv1Dao(this);
    }

    public void add(View view) {
        svDAO = new SinhVienv1Dao(this);
        SinhVienv1 user = new SinhVienv1(maSV.getText().toString(), tenSV.getText().toString(), quequan.getText().toString());
        try {
            if (validateForm() > 0) {
                if (svDAO.insertSV(user) > 0) {
                    svList.add(user);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "Thêm thành công",
                            Toast.LENGTH_SHORT).show();
                    updateListStudent();
                    maSV.setText("");
                    tenSV.setText("");
                    quequan.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại",
                            Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }

    public void update(View view) {
        if (svDAO.updateSinhVien(maSV.getText().toString(), tenSV.getText().toString(), quequan.getText().toString()) > 0) {
            Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
            updateListStudent();
        }
        maSV.setText("");
        tenSV.setText("");
        quequan.setText("");
        maSV.setEnabled(true);

    }

    public void cancel(View view) {
    }

    private int validateForm() {
        int check = 1;
        if (maSV.getText().length() == 0 || tenSV.getText().length() == 0 || quequan.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }

    private void setAdapter() {
        if (adapter == null) {
            adapter = new SinhVienv1Adapter(this, R.layout.item_sinh_vien, svList);
            lvStudent.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
            lvStudent.setSelection(adapter.getCount() - 1);
        }
    }

    public void updateListStudent() {
        svList.clear();
        svList.addAll(svDAO.getAllSinhVien());
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}

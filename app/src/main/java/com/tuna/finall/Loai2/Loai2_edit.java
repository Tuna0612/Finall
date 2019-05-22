package com.tuna.finall.Loai2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tuna.finall.R;
import com.tuna.finall.database.SinhVienv2DAO;

public class Loai2_edit extends AppCompatActivity {

    EditText edMaSV, edTenSV, edQueQuan;
    SinhVienv2DAO svDAO;
    String maSV, tenSV, QueQuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai2_edit);
        initView();
        svDAO = new SinhVienv2DAO(this);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        maSV = b.getString("ID");
        tenSV = b.getString("Name");
        QueQuan = b.getString("QueQuan");
        edMaSV.setText(maSV);
        edTenSV.setText(tenSV);
        edQueQuan.setText(QueQuan);
    }

    private void initView() {
        edMaSV = findViewById(R.id.maSV);
        edTenSV = findViewById(R.id.tenSV);
        edQueQuan = findViewById(R.id.quequan);
    }

    public void update(View view) {
        if (svDAO.updateSinhVien(edMaSV.getText().toString(), edTenSV.getText().toString(), edQueQuan.getText().toString()) > 0) {
            Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void cancel(View view) {
    }
}

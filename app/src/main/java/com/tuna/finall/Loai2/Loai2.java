package com.tuna.finall.Loai2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tuna.finall.R;
import com.tuna.finall.database.SinhVienv2DAO;

public class Loai2 extends AppCompatActivity {
    SinhVienv2DAO sinhVienv2DAO;
    private EditText edMaSV, edTenSV, edQueQuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai2);
        initView();
    }

    private void initView() {
        edMaSV = findViewById(R.id.maSV);
        edTenSV = findViewById(R.id.tenSV);
        edQueQuan = findViewById(R.id.quequan);
    }

    public void add(View view) {
        sinhVienv2DAO = new SinhVienv2DAO(this);
        SinhVienv2 user = new SinhVienv2(edMaSV.getText().toString(), edTenSV.getText().toString(), edQueQuan.getText().toString());
        try {
            if (validateForm() > 0) {
                if (sinhVienv2DAO.insertSV(user) > 0) {
                    Toast.makeText(getApplicationContext(), "Thêm thành công",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Loai2.this,Loai2_list.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại",
                            Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }

    public void cancel(View view) {
        finish();
    }
    private int validateForm() {
        int check = 1;
        if (edMaSV.getText().length() == 0 || edTenSV.getText().length() == 0 || edQueQuan.getText().length() == 0 ) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            startActivity(new Intent(Loai2.this, Loai2_list.class));
        }

        return super.onOptionsItemSelected(item);
    }

}

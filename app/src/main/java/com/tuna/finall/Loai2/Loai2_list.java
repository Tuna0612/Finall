package com.tuna.finall.Loai2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.tuna.finall.R;
import com.tuna.finall.adapter.SinhVienv2Adapter;
import com.tuna.finall.database.SinhVienv2DAO;

import java.util.ArrayList;
import java.util.List;

public class Loai2_list extends AppCompatActivity {

    public static List<SinhVienv2> dsSV = new ArrayList<>();
    ListView lvSV;
    SinhVienv2Adapter adapter = null;
    SinhVienv2DAO svDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai2_list);

        lvSV = findViewById(R.id.lvStudent);
        registerForContextMenu(lvSV);
        svDAO = new SinhVienv2DAO(Loai2_list.this);
        dsSV = svDAO.getAllSinhVien();
        adapter = new SinhVienv2Adapter(this,dsSV);
        lvSV.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dsSV.clear();
        dsSV = svDAO.getAllSinhVien();
        adapter.changeDatasetSinhVien(dsSV);
    }
}

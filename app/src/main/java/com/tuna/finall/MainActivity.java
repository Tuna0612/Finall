package com.tuna.finall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tuna.finall.Loai1.Loai1;
import com.tuna.finall.Loai2.Loai2;
import com.tuna.finall.Loai3.Loai3;
import com.tuna.finall.Loai4.Loai4;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1(View view) {
        startActivity(new Intent(MainActivity.this, Loai1.class));
    }

    public void btn2(View view) {
        startActivity(new Intent(MainActivity.this, Loai2.class));
    }

    public void btn3(View view) {
        startActivity(new Intent(MainActivity.this, Loai3.class));
    }

    public void btn4(View view) {
        startActivity(new Intent(MainActivity.this, Loai4.class));
    }
}

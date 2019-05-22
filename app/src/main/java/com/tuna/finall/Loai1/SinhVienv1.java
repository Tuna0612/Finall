package com.tuna.finall.Loai1;

public class SinhVienv1 {

    String mMaSV, mName, mQueQuan;

    public SinhVienv1() {
    }

    public SinhVienv1(String mName, String mQueQuan) {
        this.mName = mName;
        this.mQueQuan = mQueQuan;
    }

    public SinhVienv1(String mMaSV, String mName, String mQueQuan) {
        this.mMaSV = mMaSV;
        this.mName = mName;
        this.mQueQuan = mQueQuan;
    }

    public String getmMaSV() {
        return mMaSV;
    }

    public void setmMaSV(String mMaSV) {
        this.mMaSV = mMaSV;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmQueQuan() {
        return mQueQuan;
    }

    public void setmQueQuan(String mQueQuan) {
        this.mQueQuan = mQueQuan;
    }
}

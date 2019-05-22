package com.tuna.finall.Loai2;

public class SinhVienv2 {
    String mMaSV, mName, mQueQuan;

    public SinhVienv2() {
    }

    public SinhVienv2(String mName, String mQueQuan) {
        this.mName = mName;
        this.mQueQuan = mQueQuan;
    }

    public SinhVienv2(String mMaSV, String mName, String mQueQuan) {
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

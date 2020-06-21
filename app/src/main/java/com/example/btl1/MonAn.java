package com.example.btl1;
//class luu tru thong tin mon an
public class MonAn {
    private String Ten;//ten mon an
    private String Mota;//
    private int Hinh;

    public MonAn(String ten, String moTa, int hinh){
        Ten=ten;
        Mota=moTa;
        Hinh=hinh;

    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}

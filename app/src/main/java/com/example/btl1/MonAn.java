package com.example.btl1;
//class luu tru thong tin mon an
public class MonAn {
    private String Ten;//ten mon an
    private int Mota;//
    private int Hinh;
    private String fooddetail;

    public MonAn(String ten, int mota, int hinh, String fooddetail) {
        Ten = ten;
        Mota = mota;
        Hinh = hinh;
        this.fooddetail = fooddetail;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getMota() {
        return Mota;
    }

    public void setMota(int mota) {
        Mota = mota;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getFooddetail() {
        return fooddetail;
    }

    public void setFooddetail(String fooddetail) {
        this.fooddetail = fooddetail;
    }
}

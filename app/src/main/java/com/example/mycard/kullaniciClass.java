package com.example.mycard;

public class kullaniciClass {
    String kullaniciadi;
    int puan;



    public kullaniciClass( String kullaniciadi , int puan ) {
        this.kullaniciadi = kullaniciadi;
        this.puan=puan;
    }
    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }


    public String getKullaniciAdi() {
        return kullaniciadi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciadi = kullaniciAdi;
    }

}

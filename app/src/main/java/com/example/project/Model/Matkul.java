package com.example.project.Model;

public class Matkul {
    private String kodeMatkul;
    private String namaMatkul;
    private String hari;
    private String sesi;
    private String jumlahSKS;

    public Matkul(String kodeMatkul, String namaMatkul, String hari, String sesi, String jumlahSKS) {
        this.kodeMatkul = kodeMatkul;
        this.namaMatkul = namaMatkul;
        this.hari = hari;
        this.sesi = sesi;
        this.jumlahSKS = jumlahSKS;
    }

    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public void setKodeMatkul(String kodeMatkul) {
        this.kodeMatkul = kodeMatkul;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getSesi() {
        return sesi;
    }

    public void setSesi(String sesi) {
        this.sesi = sesi;
    }

    public String getJumlahSKS() {
        return jumlahSKS;
    }

    public void setJumlahSKS(String jumlahSKS) {
        this.jumlahSKS = jumlahSKS;
    }
}

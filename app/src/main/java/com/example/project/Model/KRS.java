package com.example.project.Model;

public class KRS {
    private String kodeMatkul;
    private String namaMatkul;
    private String hari;
    private String sesi;
    private String jumlahSKS;
    private String dosenPengampu;
    private String jumlahMhs;

    public KRS(String kodeMatkul, String namaMatkul, String hari, String sesi, String jumlahSKS, String dosenPengampu, String jumlahMhs) {
        this.kodeMatkul = kodeMatkul;
        this.namaMatkul = namaMatkul;
        this.hari = hari;
        this.sesi = sesi;
        this.jumlahSKS = jumlahSKS;
        this.dosenPengampu = dosenPengampu;
        this.jumlahMhs = jumlahMhs;
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

    public String getDosenPengampu() {
        return dosenPengampu;
    }

    public void setDosenPengampu(String dosenPengampu) {
        this.dosenPengampu = dosenPengampu;
    }

    public String getJumlahMhs() {
        return jumlahMhs;
    }

    public void setJumlahMhs(String jumlahMhs) {
        this.jumlahMhs = jumlahMhs;
    }
}


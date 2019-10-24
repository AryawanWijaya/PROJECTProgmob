package com.example.project.Model;

public class LihatKelas {
    private String kodeMatkulKls;
    private String matkulKls;
    private String hariKls;
    private String sesiKLs;
    private String dosenPengampuKls;
    private String jmlMhsKls;

    public LihatKelas(String kodeMatkulKls, String matkulKls, String hariKls, String sesiKLs, String dosenPengampuKls, String jmlMhsKls) {
        this.kodeMatkulKls = kodeMatkulKls;
        this.matkulKls = matkulKls;
        this.hariKls = hariKls;
        this.sesiKLs = sesiKLs;
        this.dosenPengampuKls = dosenPengampuKls;
        this.jmlMhsKls = jmlMhsKls;
    }

    public String getKodeMatkulKls() {
        return kodeMatkulKls;
    }

    public void setKodeMatkulKls(String kodeMatkulKls) {
        this.kodeMatkulKls = kodeMatkulKls;
    }

    public String getMatkulKls() {
        return matkulKls;
    }

    public void setMatkulKls(String matkulKls) {
        this.matkulKls = matkulKls;
    }

    public String getHariKls() {
        return hariKls;
    }

    public void setHariKls(String hariKls) {
        this.hariKls = hariKls;
    }

    public String getSesiKLs() {
        return sesiKLs;
    }

    public void setSesiKLs(String sesiKLs) {
        this.sesiKLs = sesiKLs;
    }

    public String getDosenPengampuKls() {
        return dosenPengampuKls;
    }

    public void setDosenPengampuKls(String dosenPengampuKls) {
        this.dosenPengampuKls = dosenPengampuKls;
    }

    public String getJmlMhsKls() {
        return jmlMhsKls;
    }

    public void setJmlMhsKls(String jmlMhsKls) {
        this.jmlMhsKls = jmlMhsKls;
    }
}

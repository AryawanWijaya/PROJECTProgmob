package com.example.project.Model;

public class Dosen {
    private int fotoDosen;
    private String NIDN;
    private String namaDosen;
    private String gelar;
    private String email;
    private String alamat;

    public Dosen(int fotoDosen, String NIDN, String namaDosen, String gelar, String email, String alamat) {
        this.fotoDosen = fotoDosen;
        this.NIDN = NIDN;
        this.namaDosen = namaDosen;
        this.gelar = gelar;
        this.email = email;
        this.alamat = alamat;
    }

    public int getFotoDosen() {
        return fotoDosen;
    }

    public void setFotoDosen(int fotoDosen) {
        this.fotoDosen = fotoDosen;
    }

    public String getNIDN() {
        return NIDN;
    }

    public void setNIDN(String NIDN) {
        this.NIDN = NIDN;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public String getGelar() {
        return gelar;
    }

    public void setGelar(String gelar) {
        this.gelar = gelar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}

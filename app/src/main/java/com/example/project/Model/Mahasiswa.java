package com.example.project.Model;

public class Mahasiswa {
    private int imgMhs;
    private String NIM;
    private String namaMhs;
    private String emailMhs;
    private String alamaMhs;


    public Mahasiswa(int imgMhs, String NIM, String namaMhs, String emailMhs, String alamaMhs) {
        this.imgMhs = imgMhs;
        this.NIM = NIM;
        this.namaMhs = namaMhs;
        this.emailMhs = emailMhs;
        this.alamaMhs = alamaMhs;
    }

    public int getImgMhs() {
        return imgMhs;
    }

    public void setImgMhs(int imgMhs) {
        this.imgMhs = imgMhs;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getNamaMhs() {
        return namaMhs;
    }

    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }

    public String getEmailMhs() {
        return emailMhs;
    }

    public void setEmailMhs(String emailMhs) {
        this.emailMhs = emailMhs;
    }

    public String getAlamaMhs() {
        return alamaMhs;
    }

    public void setAlamaMhs(String alamaMhs) {
        this.alamaMhs = alamaMhs;
    }
}

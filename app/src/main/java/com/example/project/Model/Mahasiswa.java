package com.example.project.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mahasiswa {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("foto")
    @Expose
    private String imgMhs;

    @SerializedName("nim")
    @Expose
    private String NIM;

    @SerializedName("nama")
    @Expose
    private String namaMhs;

    @SerializedName("email")
    @Expose
    private String emailMhs;

    @SerializedName("alamat")
    @Expose
    private String alamaMhs;

    public Mahasiswa(String id, String imgMhs, String NIM, String namaMhs, String emailMhs, String alamaMhs) {
        this.id = id;
        this.imgMhs = imgMhs;
        this.NIM = NIM;
        this.namaMhs = namaMhs;
        this.emailMhs = emailMhs;
        this.alamaMhs = alamaMhs;
    }

    public Mahasiswa(String imgMhs, String NIM, String namaMhs, String emailMhs, String alamaMhs) {
        this.imgMhs = imgMhs;
        this.NIM = NIM;
        this.namaMhs = namaMhs;
        this.emailMhs = emailMhs;
        this.alamaMhs = alamaMhs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgMhs() {
        return imgMhs;
    }

    public void setImgMhs(String imgMhs) {
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

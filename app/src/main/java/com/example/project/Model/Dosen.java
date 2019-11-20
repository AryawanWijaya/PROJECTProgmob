package com.example.project.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dosen {
    @SerializedName("id")// dari attribute yang ada di API
    @Expose
    private String id;

    @SerializedName("nama")
    @Expose
    private String namaDosen;

    @SerializedName("nidn")
    @Expose
    private String NIDN;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("gelar")
    @Expose
    private String gelar;

    @SerializedName("foto")
    @Expose
    private String fotoDosen;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dosen(String fotoDosen, String NIDN, String namaDosen, String gelar, String email, String alamat, String id) {
        this.fotoDosen = fotoDosen;
        this.NIDN = NIDN;
        this.namaDosen = namaDosen;
        this.gelar = gelar;
        this.email = email;
        this.alamat = alamat;
        this.id = id;
    }

    public Dosen(String fotoDosen, String NIDN, String namaDosen, String gelar, String email, String alamat) {
        this.fotoDosen = fotoDosen;
        this.NIDN = NIDN;
        this.namaDosen = namaDosen;
        this.gelar = gelar;
        this.email = email;
        this.alamat = alamat;
    }

    public String getFotoDosen() {
        return fotoDosen;
    }

    public void setFotoDosen(String fotoDosen) {
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

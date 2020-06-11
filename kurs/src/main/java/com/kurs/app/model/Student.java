package com.kurs.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    private String ad;
    @NotEmpty
    private String soyad;
    @NotEmpty
    @Size(min = 11, max = 11)
    private String telno;

    private String tarih;

    private Float kayittutar;

    private Integer taksitsayisi;

    private Float aylik;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public Float getKayittutar() {
        return kayittutar;
    }

    public void setKayittutar(Float kayittutar) {
        this.kayittutar = kayittutar;
    }

    public Integer getTaksitsayisi() {
        return taksitsayisi;
    }

    public void setTaksitsayisi(Integer taksitsayisi) {
        this.taksitsayisi = taksitsayisi;
    }

    public Float getAylik() {
        return aylik;
    }

    public void setAylik(Float aylik) {
        this.aylik = aylik;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
}

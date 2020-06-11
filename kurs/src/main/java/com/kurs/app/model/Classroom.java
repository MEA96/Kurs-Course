package com.kurs.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    private String sinifadi;
    @NotEmpty
    private String tarih;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSinifadi() {
        return sinifadi;
    }

    public void setSinifadi(String sinifadi) {
        this.sinifadi = sinifadi;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
}
package com.example.Dva.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Data {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    private String name, fame, otch;
    private int place;
    private double zp;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFame() {
        return fame;
    }

    public void setFame(String fame) {
        this.fame = fame;
    }

    public String getOtch() {
        return otch;
    }

    public void setOtch(String otch) {
        this.otch = otch;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public double getZp() {
        return zp;
    }

    public void setZp(double zp) {
        this.zp = zp;
    }
    public Data(){}
    public Data(String name, String fame, String otch, int place, double zp) {
        this.name = name;
        this.fame = fame;
        this.otch = otch;
        this.place = place;
        this.zp = zp;
    }
}

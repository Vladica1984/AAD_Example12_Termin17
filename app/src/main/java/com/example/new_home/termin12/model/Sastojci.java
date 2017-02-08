package com.example.new_home.termin12.model;

/**
 * Created by New_home on 2.2.2017.
 */

public class Sastojci {

    private int id;
    private String ime;
    private Jelo jelo;

    public Sastojci() {}

    public Sastojci(int id, String ime) {
        this.id = id;
        this.ime = ime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Jelo getJelo() {
        return jelo;
    }

    public void setJelo(Jelo jelo) {
        this.jelo = jelo;
    }
}

package com.example.new_home.termin12.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by New_home on 2.2.2017.
 */

public class Kategorija {

    private int id;
    private String ime;
    private List<Jelo> jela;

    public Kategorija(){
         jela = new ArrayList<>();
    }

    public Kategorija(int id, String ime) {
        this.id = id;
        this.ime = ime;
        jela = new ArrayList<>();
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

    public List<Jelo> getJela() { return jela; }

    public void setJela(List<Jelo> jela) {
        this.jela = jela;
    }
}

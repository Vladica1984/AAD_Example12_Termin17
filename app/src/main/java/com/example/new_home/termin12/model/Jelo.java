package com.example.new_home.termin12.model;

import java.util.ArrayList;

/**
 * Created by New_home on 31.1.2017.
 */

public class Jelo {

    private int id;
    private String slika,ime,opis;
    private Kategorija kategorija;
    private ArrayList<Sastojci> sastojci;
    private int kalorije;
    private int cena;

    public void Jelo(){
        sastojci = new ArrayList<>();
    }

    public Jelo(int id, String slika, String ime, String opis, int kalorije, int cena, Kategorija kategorija) {

        this.id=id;
        this.slika = slika;
        this.ime = ime;
        this.opis = opis;
        this.kalorije = kalorije;
        this.cena = cena;
        this.kategorija=kategorija;
        sastojci = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public ArrayList<Sastojci> getSastojci() {
        return sastojci;
    }

    public void setSastojci(ArrayList<Sastojci> sastojci) {
        this.sastojci = sastojci;
    }

    public int getKalorije() {
        return kalorije;
    }

    public void setKalorije(int kalorije) {
        this.kalorije = kalorije;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}

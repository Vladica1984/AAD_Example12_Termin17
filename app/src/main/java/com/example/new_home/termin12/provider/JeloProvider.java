package com.example.new_home.termin12.provider;

import com.example.new_home.termin12.model.Jelo;
import com.example.new_home.termin12.model.Kategorija;
import com.example.new_home.termin12.model.Sastojci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by New_home on 2.2.2017.
 */

public class JeloProvider {

    public static List<String> getNazivJela() {

        List<String> naziv = new ArrayList<>();
        naziv.add("Jelo 1");
        naziv.add("Jelo 2");
        naziv.add("Jelo 3");
        naziv.add("Jelo 4");
        naziv.add("Jelo 5");
        return naziv;
    }

    public static Jelo getJeloById(int id) {

        Kategorija k1 = new Kategorija(0, "Glavno jelo");
        Kategorija k2 = new Kategorija(1, "Desert");
        Kategorija k3 = new Kategorija(2, "Predjelo");

        Sastojci s1 = new Sastojci(0,"Krompir na kolutice");
        Sastojci s2 = new Sastojci(1,"Mleveno meso");
        Sastojci s3 = new Sastojci(2,"Crni luk");
        Sastojci s4 = new Sastojci(3,"So");
        Sastojci s5 = new Sastojci(4,"Biber");

        Jelo j;
        switch (id) {
            case 0: {
                j = new Jelo(0, "Paprika_punjena.jpg", "Punjena paprika", "Opis 1", 200, 405, k1);
                j.getSastojci().add(s1);
                j.getSastojci().add(s2);
                j.getSastojci().add(s3);
                break;
            }
            case 1: {
                j = new Jelo(1, "Jagnjetina.jpg", "Jagnjici", "Opis 2", 300, 100, k2);
                j.getSastojci().add(s1);
                j.getSastojci().add(s3);
                j.getSastojci().add(s4);
                break;
            }
            case 2: {
                j = new Jelo(2, "Musaka.jpg", "Musaka", "Opis 3", 250, 500, k2);
                j.getSastojci().add(s1);
                j.getSastojci().add(s2);
                j.getSastojci().add(s5);
                break;
            }
            case 3: {
                j = new Jelo(3, "Rebarca.jpg", "Rebarca", "Opis 4", 400, 200, k3);
                j.getSastojci().add(s2);
                j.getSastojci().add(s1);
                j.getSastojci().add(s4);
                break;
            }
            case 4:{
                j = new Jelo(4, "Kolenica.jpg", "Kolenica", "Opis 5", 280, 150, k3);
                j.getSastojci().add(s2);
                j.getSastojci().add(s3);
                j.getSastojci().add(s4);
                break;
            }
            default: j = null;
        }
        return j;
    }
}

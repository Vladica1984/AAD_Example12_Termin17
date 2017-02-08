package com.example.new_home.termin12.provider;

import com.example.new_home.termin12.model.Jelo;
import com.example.new_home.termin12.model.Sastojci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by New_home on 2.2.2017.
 */

public class SastojciProvider {
    public static List<String> getSastojciNaziv(Jelo jeloById) {
        List<String> naziv = new ArrayList<>();
        for (Sastojci s: jeloById.getSastojci()) {
            naziv.add(s.getIme());
        }
        return naziv;
    }

}

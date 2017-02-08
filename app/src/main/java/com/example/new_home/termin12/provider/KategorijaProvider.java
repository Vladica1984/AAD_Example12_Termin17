package com.example.new_home.termin12.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by New_home on 2.2.2017.
 */

public class KategorijaProvider {
    public static List<String> getKategorijaNaziv() {
        List<String> naziv = new ArrayList<>();
        naziv.add("Glavno jelo");
        naziv.add("Desert");
        naziv.add("Predjelo");
        return naziv;
    }
}

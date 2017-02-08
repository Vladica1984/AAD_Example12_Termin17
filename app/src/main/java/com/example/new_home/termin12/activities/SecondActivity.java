/*package com.example.new_home.termin12.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.new_home.termin12.R;
import com.example.new_home.termin12.provider.JeloProvider;
import com.example.new_home.termin12.provider.KategorijaProvider;
import com.example.new_home.termin12.provider.SastojciProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final int position = getIntent().getIntExtra("position",0);

        ImageView ivImage = (ImageView) findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getAssets().open(JeloProvider.getJeloById(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvIme = (TextView) findViewById(R.id.tv_ime);
        tvIme.setText(JeloProvider.getJeloById(position).getIme());

        TextView tvOpis = (TextView) findViewById(R.id.tv_opis);
        tvOpis.setText(JeloProvider.getJeloById(position).getOpis());

        TextView tvKalorije = (TextView) findViewById(R.id.tv_kalorije);
        tvKalorije.setText(Integer.toString(JeloProvider.getJeloById(position).getKalorije()));

        TextView tvCena = (TextView) findViewById(R.id.tv_cena);
        tvCena.setText(Integer.toString(JeloProvider.getJeloById(position).getCena()));

        Spinner kategorija = (Spinner) findViewById(R.id.sp_kategorija);
        List<String> kategorije = KategorijaProvider.getKategorijaNaziv();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, kategorije);
        kategorija.setAdapter(adapter);
        kategorija.setSelection(JeloProvider.getJeloById(position).getKategorija().getId());

        List<String> sastojci = SastojciProvider.getSastojciNaziv(JeloProvider.getJeloById(position));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, R.layout.list_item, sastojci);
        ListView listView = (ListView) findViewById(R.id.lv_sastojci);
        listView.setAdapter(dataAdapter);
    }
}
*/
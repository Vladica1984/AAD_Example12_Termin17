package com.example.new_home.termin12.fragments;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.new_home.termin12.R;
import com.example.new_home.termin12.provider.JeloProvider;
import com.example.new_home.termin12.provider.KategorijaProvider;
import com.example.new_home.termin12.provider.SastojciProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Alen on 07-Feb-17.
 */

public class DetailFragment extends Fragment {


    private int position = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(JeloProvider.getJeloById(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvIme = (TextView) getView().findViewById(R.id.tv_ime);
        tvIme.setText(JeloProvider.getJeloById(position).getIme());

        TextView tvOpis = (TextView) getView().findViewById(R.id.tv_opis);
        tvOpis.setText(JeloProvider.getJeloById(position).getOpis());

        TextView tvKalorije = (TextView) getView().findViewById(R.id.tv_kalorije);
        tvKalorije.setText(Integer.toString(JeloProvider.getJeloById(position).getKalorije()));

        TextView tvCena = (TextView) getView().findViewById(R.id.tv_cena);
        tvCena.setText(Integer.toString(JeloProvider.getJeloById(position).getCena()));

        Spinner kategorija = (Spinner) getView().findViewById(R.id.sp_kategorija);
        List<String> kategorije = KategorijaProvider.getKategorijaNaziv();

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (getActivity(), R.layout.support_simple_spinner_dropdown_item, kategorije);
        kategorija.setAdapter(adapter);
        kategorija.setSelection(JeloProvider.getJeloById(position).getKategorija().getId());

        List<String> sastojci = SastojciProvider.getSastojciNaziv(JeloProvider.getJeloById(position));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, sastojci);
        ListView listView = (ListView) getView().findViewById(R.id.lv_sastojci);
        listView.setAdapter(dataAdapter);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("position", position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }

    public void setContent(final int position) {
        this.position = position;

        Log.v("DetailFragment", "setContent() sets position to " + position);
    }

    public void updateContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "updateContent() sets position to " + position);

        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(JeloProvider.getJeloById(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvIme = (TextView) getView().findViewById(R.id.tv_ime);
        tvIme.setText(JeloProvider.getJeloById(position).getIme());

        TextView tvOpis = (TextView) getView().findViewById(R.id.tv_opis);
        tvOpis.setText(JeloProvider.getJeloById(position).getOpis());

        TextView tvKalorije = (TextView) getView().findViewById(R.id.tv_kalorije);
        tvKalorije.setText(Integer.toString(JeloProvider.getJeloById(position).getKalorije()));

        TextView tvCena = (TextView) getView().findViewById(R.id.tv_cena);
        tvCena.setText(Integer.toString(JeloProvider.getJeloById(position).getCena()));

        Spinner kategorija = (Spinner) getView().findViewById(R.id.sp_kategorija);
        List<String> kategorije = KategorijaProvider.getKategorijaNaziv();

        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, kategorije);
        kategorija.setAdapter(adapter);
        kategorija.setSelection(JeloProvider.getJeloById(position).getKategorija().getId());

        List<String> sastojci = SastojciProvider.getSastojciNaziv(JeloProvider.getJeloById(position));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, sastojci);
        ListView listView = (ListView) getView().findViewById(R.id.lv_sastojci);
        listView.setAdapter(dataAdapter);
    }
}

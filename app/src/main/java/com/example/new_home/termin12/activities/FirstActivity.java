package com.example.new_home.termin12.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.new_home.termin12.R;
import com.example.new_home.termin12.fragments.DetailFragment;
import com.example.new_home.termin12.fragments.MasterFragment;

public class FirstActivity extends Activity implements MasterFragment.OnItemSelectedListener {

        boolean landscape = false;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_master);

        setContentView(R.layout.activity_first);

        if (savedInstanceState == null) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                MasterFragment masterFragment = new MasterFragment();
                ft.add(R.id.master_view, masterFragment, "Master_Fragment_1");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
        }

        if (findViewById(R.id.detail_view) != null) {
                landscape = true;
                getFragmentManager().popBackStack();

                DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
                if (detailFragment == null) {
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        detailFragment = new DetailFragment();
                        ft.replace(R.id.detail_view, detailFragment, "Detail_Fragment_1");
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        ft.commit();
                        }
                }
        }

        /*
        List<String> jeloNaziv = JeloProvider.getNazivJela();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, R.layout.list_item, jeloNaziv);
        ListView listView = (ListView) findViewById(R.id.lv_listaJela);
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        intent.putExtra(" ",position);
        startActivity(intent);
        }
        });
        }
        }
        */

        @Override
        public void onItemSelected(int position) {

        if(landscape) {
        DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
        detailFragment.updateContent(position);
        } else {
            DetailFragment detailFragment = new DetailFragment();
                detailFragment.setContent(position);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.master_view, detailFragment, "Detail_Fragment_2");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
        }
        }
}
package com.example.new_home.termin12.activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.new_home.termin12.R;
import com.example.new_home.termin12.adapters.DrawerAdapter;
import com.example.new_home.termin12.dialogs.AboutDialog;
import com.example.new_home.termin12.fragments.DetailFragment;
import com.example.new_home.termin12.fragments.MasterFragment;
import com.example.new_home.termin12.model.NavigationItem;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity implements MasterFragment.OnItemSelectedListener {

        private class DrawerItemClickListener implements ListView.OnItemClickListener {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        selectItemFromDrawer (position);
                }
        }

        private DrawerLayout drawerLayout;
        private ListView drawerList;
        private ActionBarDrawerToggle drawerToggle;
        private RelativeLayout drawerPane;
        private CharSequence drawerTitle;
        private ArrayList<NavigationItem> drawerItems = new ArrayList<NavigationItem>();
        private AlertDialog dialog;

        private boolean landscapeMode = false;
        private boolean masterShown = false;
        private boolean detailShown = false;

        private int itemId = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);
                //setContentView(R.layout.fragment_master);

                setContentView(R.layout.activity_first);

                drawerItems.add(new NavigationItem(getString(R.string.drawer_home), getString(R.string.drawer_home_long), R.drawable.ic_action_product));
                drawerItems.add(new NavigationItem(getString(R.string.drawer_settings), getString(R.string.drawer_settings_long), R.drawable.ic_action_settings));
                drawerItems.add(new NavigationItem(getString(R.string.drawer_about), getString(R.string.drawer_about_long), R.drawable.ic_action_about));

                drawerTitle = getTitle();
                drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
                drawerList = (ListView) findViewById(R.id.navList);

                drawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
                DrawerAdapter adapter = new DrawerAdapter(this, drawerItems);

                drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
                drawerList.setOnItemClickListener(new DrawerItemClickListener());
                drawerList.setAdapter(adapter);

                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

                if (actionBar != null) {
                        actionBar.setDisplayHomeAsUpEnabled(true);
                        actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
                        actionBar.setHomeButtonEnabled(true);
                        actionBar.show();
                }

                drawerToggle = new ActionBarDrawerToggle(
                        this,
                        drawerLayout,
                        toolbar,
                        R.string.drawer_open,
                        R.string.drawer_close
                ) {
                    public void onDrawerClosed(View view) {
                        getSupportActionBar().setTitle(drawerTitle);
                        invalidateOptionsMenu();
                    }

                    public void onDrawerOpened(View drawerView) {
                        getSupportActionBar().setTitle(drawerTitle);
                        invalidateOptionsMenu();
                    }
                };

                if (savedInstanceState == null) {
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        MasterFragment masterFragment = new MasterFragment();
                        ft.add(R.id.master_view, masterFragment, "Master_Fragment_1");
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        ft.commit();
                }

                if (findViewById(R.id.detail_view) != null) {
                        landscapeMode = true;
                        getFragmentManager().popBackStack();

                        DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
                        if (detailFragment == null) {
                                FragmentTransaction ft = getFragmentManager().beginTransaction();
                                detailFragment = new DetailFragment();
                                ft.replace(R.id.detail_view, detailFragment, "Detail_Fragment_1");
                                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                                ft.commit();
                                detailShown = true;
                        }
                }
                masterShown = true;
                detailShown = false;
                itemId = 0;
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
        public void onItemSelected(int id) {

             itemId = id;

        if(landscapeMode) {
        DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
        detailFragment.updateContent(id);
        } else {
            DetailFragment detailFragment = new DetailFragment();
                detailFragment.setContent(id);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.master_view, detailFragment, "detail_fragment_2");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();

                masterShown = false;
                detailShown = true;
            }
        }

        @Override
        public void onBackPressed() {

                if (landscapeMode) {
                        finish();
                } else if (masterShown == true) {
                        finish();
                } else if (detailShown == true) {
                        getFragmentManager().popBackStack();
                        MasterFragment masterFragment = new MasterFragment();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.master_view, masterFragment, "Master_Fragment");
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        ft.commit();
                        masterShown = true;
                        detailShown = false;
                }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
              getMenuInflater().inflate(R.menu.menu, menu);
              return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_create:
                    Toast.makeText(this, "Action Dodaj executed.", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.action_update:
                    Toast.makeText(this, "Action Izmeni executed.", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.action_delete:
                    Toast.makeText(this, "Action Brisi executed.", Toast.LENGTH_SHORT).show();

                    break;
            }

            return super.onOptionsItemSelected(item);
        }

        @Override
        public void setTitle(CharSequence title) { getSupportActionBar().setTitle(title); }


        @Override
        protected void onPostCreate(Bundle savedInstanceState) {
            super.onPostCreate(savedInstanceState);
            drawerToggle.syncState();
        }

        @Override
        public void onConfigurationChanged(Configuration configuration) {
           super.onConfigurationChanged(configuration);
           drawerToggle.onConfigurationChanged(configuration);
        }

        private void selectItemFromDrawer(int position) {

            if (position == 0) {

            } else if (position == 1) {
                Intent settings = new Intent(FirstActivity.this, SettingsActivity.class);
                startActivity(settings);
            } else if (position == 2) {
                if (dialog == null) {
                    dialog = new AboutDialog(FirstActivity.this).prepareDialog();
                } else {
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                }

                dialog.show();
            }

            drawerList.setItemChecked(position, true);
            setTitle(drawerItems.get(position).getTitle());
            drawerLayout.closeDrawer(drawerPane);
        }
}
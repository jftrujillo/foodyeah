package com.example.jhonfredy.foodyeah;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jhonfredy.foodyeah.Adapters.PestanaResMapAdapter;
import com.example.jhonfredy.foodyeah.Models.Restaurantes;
import com.example.jhonfredy.foodyeah.Util.AppUtil;
import com.example.jhonfredy.foodyeah.fragments.DescripcionRestauranteFragment;
import com.example.jhonfredy.foodyeah.fragments.MapaFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


public class RestauranteMapaActivity extends AppCompatActivity implements  ViewPager.OnPageChangeListener, android.support.v7.app.ActionBar.TabListener {

   List<Restaurantes> data = AppUtil.getDataRestaurantes();
    Restaurantes r;


    List<Fragment> fragmentsArray;
    public DescripcionRestauranteFragment desResF;

    public MapaFragment mapaF;


    PestanaResMapAdapter adapter;
    ViewPager pager;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_mapa);
        r = data.get(pos);

        desResF = new DescripcionRestauranteFragment();
        mapaF = new MapaFragment();

        fragmentsArray = new ArrayList<>();
        fragmentsArray.add(desResF);
        fragmentsArray.add(mapaF);


        Bundle bundle = getIntent().getExtras();
        pos = (int) bundle.get("pos");


        android.support.v7.app.ActionBar actionBar= getSupportActionBar();

        actionBar.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setHomeButtonEnabled(false);

        adapter = new PestanaResMapAdapter(getSupportFragmentManager(),fragmentsArray, pos) ;

        pager= (ViewPager) findViewById(R.id.pager2);
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(this);


        for (int i = 0; i < adapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(adapter.getPageTitle(i))
                            .setTabListener(this));
        }

    }


    @Override
    protected void onResume() {
        super.onResume();

        desResF.init(pos);
        mapaF.init(pos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurante_mapa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
          
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }
}

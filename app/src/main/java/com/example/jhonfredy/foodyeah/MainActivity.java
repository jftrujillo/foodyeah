package com.example.jhonfredy.foodyeah;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jhonfredy.foodyeah.Adapters.FoodPagerAdapter;
import com.example.jhonfredy.foodyeah.Models.Comida;
import com.example.jhonfredy.foodyeah.Models.Food;
import com.example.jhonfredy.foodyeah.Models.Restaurantes;
import com.example.jhonfredy.foodyeah.Models.Rutas;
import com.example.jhonfredy.foodyeah.Net.ComidaCon;
import com.example.jhonfredy.foodyeah.Net.RestauranteCon;
import com.example.jhonfredy.foodyeah.Net.RutasCon;
import com.example.jhonfredy.foodyeah.Util.AppUtil;
import com.example.jhonfredy.foodyeah.fragments.ListSelectedI;
import com.example.jhonfredy.foodyeah.fragments.ListaComidasFragment;
import com.example.jhonfredy.foodyeah.fragments.RestaurantesListaFragment;
import com.example.jhonfredy.foodyeah.fragments.RutasListaFragment;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends ActionBarActivity implements ActionBar.TabListener, ComidaCon.ComidaConI, RestauranteCon.RestauranteConI, RutasCon.RutasConI, ViewPager.OnPageChangeListener, ListSelectedI {

    List<Fragment> fragmentsArraya;


    public static ListaComidasFragment comidaF ;
    public static RestaurantesListaFragment restaurantesF;
    public static RutasListaFragment rutasF ;
    RestauranteCon restauranteCon;
    ComidaCon comidaCon;
    RutasCon rutasCon;

    FoodPagerAdapter adapter;
    ViewPager pager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        comidaF = new ListaComidasFragment();

        restaurantesF= new RestaurantesListaFragment();
        rutasF = new RutasListaFragment();
        fragmentsArraya = new ArrayList<>();
        fragmentsArraya.add(comidaF);
        fragmentsArraya.add(restaurantesF);
        fragmentsArraya.add(rutasF);

        comidaCon = new ComidaCon(this,this);
        comidaCon.getAllItems();
        restauranteCon = new RestauranteCon(this,this);
        restauranteCon.getAllItems();
        rutasCon = new RutasCon(this,this);


        setContentView(R.layout.activity_main);
       final android.support.v7.app.ActionBar actionBar= getSupportActionBar();



        actionBar.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setHomeButtonEnabled(false);

        adapter = new FoodPagerAdapter(getSupportFragmentManager(),fragmentsArraya) ;

        pager= (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(this);


        for (int i = 0; i < adapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(adapter.getPageTitle(i))
                            .setTabListener((android.support.v7.app.ActionBar.TabListener) this));
        }


        }

   /* @Override
    protected void onResume() {
        super.onResume();
        rutasF.init(this);

    }*/

    @Override
    protected void onResume() {
        super.onResume();
        rutasF.init(this);
        restaurantesF.init(this);
        comidaF.init(this);
        comidaCon = new ComidaCon(this,this);
        comidaCon.getAllItems();
        restauranteCon = new RestauranteCon(this,this);
        restauranteCon.getAllItems();
        rutasCon = new RutasCon(this,this);
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

    @Override
    public void onCompleted(Comida entity, Exception exception, ServiceFilterResponse response) {

    }

    @Override
    public void onCompleted(Restaurantes entity, Exception exception, ServiceFilterResponse response) {

    }

    @Override
    public void onCompleted(Rutas entity, Exception exception, ServiceFilterResponse response) {

    }

    @Override
    public void onDeleteCompleted(Exception exception, ServiceFilterResponse response) {

    }

    @Override
    public void onReadRutasCompleted(List<Rutas> result, int count, Exception exception, ServiceFilterResponse response) {
        AppUtil.getDataRutas().clear();
        for (int i=0; i<result.size(); i++){
            AppUtil.getDataRutas().add(result.get(i));

        }
        rutasF.notifyDataSet();

    }

    @Override
    public void onReadRestaurantesCompleted(List<Restaurantes> result, int count, Exception exception, ServiceFilterResponse response) {
        AppUtil.getDataRestaurantes().clear();
        for (int i=0; i<result.size(); i++){
            AppUtil.getDataRestaurantes().add(result.get(i));

        }
        restaurantesF.notifyDataSet();
    }

    @Override
    public void onReadCompleted(List<Comida> result, int count, Exception exception, ServiceFilterResponse response) {
        AppUtil.getDataComida().clear();

            for (int i=0; i<result.size(); i++){
                AppUtil.getDataComida().add(result.get(i));

            }

       comidaF.notifyDataSet();


    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.i("pagina","entro a item selected");
    }

    @Override
    public void onPageSelected(int position) {
        getSupportActionBar().setSelectedNavigationItem(position);
        Log.i("pagina","entro onpage");
    if(position == 1){

        rutasCon.getAllItems();


    }

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.i("pagina","entro a scrooll");
    }

    @Override
    public void itemSelected(int pos, int type) {
        switch (type){
            case ListaComidasFragment.TYPE_F:
                Intent intent = new Intent(this,DeascripcionComida.class).putExtra("pos",pos);
                startActivity(intent);
                break;
            case RestaurantesListaFragment.TYPE_F:
                Intent intent1 = new Intent(this,RestauranteMapaActivity.class).putExtra("pos",pos);
                startActivity(intent1);

                break;
            case RutasListaFragment.TYPE_F:
                Intent intent2 = new Intent(this,MapaRutasActivity.class).putExtra("pos",pos);
                startActivity(intent2);

                break;
        }
    }
}




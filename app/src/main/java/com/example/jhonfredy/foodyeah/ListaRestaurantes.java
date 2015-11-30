package com.example.jhonfredy.foodyeah;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.jhonfredy.foodyeah.Adapters.RestaurantesListaAdapter;
import com.example.jhonfredy.foodyeah.Models.Restaurantes;
import com.example.jhonfredy.foodyeah.Net.RestauranteCon;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;

import java.util.ArrayList;
import java.util.List;


public class ListaRestaurantes extends ActionBarActivity implements RestauranteCon.RestauranteConI {

    RestauranteCon restauranteCon;
    ListView list;
    RestaurantesListaAdapter adapter;
    List<Restaurantes> datarestaurantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_restaurantes);
        list = (ListView) findViewById(R.id.list);
        datarestaurantes = new ArrayList<>();
        adapter = new RestaurantesListaAdapter(this, datarestaurantes);
        list.setAdapter(adapter);
        restauranteCon = new RestauranteCon(this, this);
        restauranteCon.getAllItems();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_restaurantes, menu);
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
    public void onCompleted(Restaurantes entity, Exception exception, ServiceFilterResponse response) {

    }

    @Override
    public void onDeleteCompleted(Exception exception, ServiceFilterResponse response) {

    }

    @Override
    public void onReadRestaurantesCompleted(List<Restaurantes> result, int count, Exception exception, ServiceFilterResponse response) {
        datarestaurantes.clear();
        for (int i = 0; i < result.size(); i++) {
            datarestaurantes.add(result.get(i));

        }
        adapter.notifyDataSetChanged();
    }
}



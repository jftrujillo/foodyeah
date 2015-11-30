package com.example.jhonfredy.foodyeah;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jhonfredy.foodyeah.Models.Restaurantes;
import com.example.jhonfredy.foodyeah.Util.AppUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


public class Map extends AppCompatActivity {

    List<Restaurantes> data = AppUtil.getDataRestaurantes();
    String latitud;
    String longitud;
    Double latitudD, longitudD;

    Restaurantes r;



    public GoogleMap googleMap;
    public   void createMap(){

       try {
           if(null == googleMap) {
               SupportMapFragment mapa = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);

               googleMap = mapa.getMap();
               if (null == googleMap){
                   Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_SHORT).show();
               }
           }
       }catch (NullPointerException exception){
           Log.e("mapApp", exception.toString());
       }
    }

    public void addMarker(){

        /*latitud = r.getLatitud();
        longitud = r.getLongitud();
        latitudD = Double.valueOf(latitud);
        longitudD = Double.valueOf(longitud);*/
        LatLng latLng = new LatLng(2.452137,-76.597651);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(14));
        googleMap.addMarker(new MarkerOptions().position(latLng).title("afdasdf").snippet("dsfsadfa"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        createMap();
        addMarker();
    }


    //region Description

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
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
    //endregion
}

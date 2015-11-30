package com.example.jhonfredy.foodyeah.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jhonfredy.foodyeah.Models.Restaurantes;
import com.example.jhonfredy.foodyeah.R;
import com.example.jhonfredy.foodyeah.Util.AppUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * Created by MobileLab 16 on 28/05/2015.
 */
public class MapaFragment extends Fragment implements OnMapReadyCallback {

    int pos;

    public void init(int pos){
        this.pos = pos;

    }




    private GoogleMap googleMap;


    Restaurantes r;
    String latitud;
    String longitud;
    Double latitudD, longitudD;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View

        View v = inflater.inflate(R.layout.fragment_mapa, container, false);

       setUpMapIfNeeded();

        return v;
    }







    private void addMarks() {
        r = AppUtil.getDataRestaurantes().get(pos);
        latitud = r.getLatitud();
        longitud = r.getLongitud();
        latitudD = Double.valueOf(latitud);
        longitudD = Double.valueOf(longitud);
        LatLng latLng = new LatLng(latitudD,longitudD);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(14));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(latitudD,longitudD)).title(r.getNombre()).snippet(r.getDireccion()));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        addMarks();
    }

    @Override
         public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
             super.onViewCreated(view, savedInstanceState);

        super.onActivityCreated(savedInstanceState);

        if(googleMap == null){
            ((SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.mapa)).getMapAsync(this);
        }

    }


    public void  setUpMapIfNeeded(){
        if(googleMap == null){
            ((SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.mapa)).getMapAsync(this);

        }

    }
}

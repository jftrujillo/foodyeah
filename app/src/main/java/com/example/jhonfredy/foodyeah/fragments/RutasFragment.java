package com.example.jhonfredy.foodyeah.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jhonfredy.foodyeah.Models.Rutas;
import com.example.jhonfredy.foodyeah.R;
import com.example.jhonfredy.foodyeah.Util.AppUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class RutasFragment extends android.support.v4.app.Fragment implements OnMapReadyCallback {


    int pos;

    public void init (int pos) {
        this.pos = pos;
    }

   private GoogleMap rutagooglemap;

    Rutas r;
    String latitud, longitud;
    double latituD, longituD;









    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_rutas,container,false);

        setUpMapIfNeeded();
        // Inflate the layout for this fragment
        return v;
    }



    public void  setUpMapIfNeeded(){
        if(rutagooglemap == null){
            ((SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.rutas)).getMapAsync(this);

        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        super.onActivityCreated(savedInstanceState);

        if (rutagooglemap == null){

            ((SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.rutas)).getMapAsync(this);



        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.rutagooglemap = googleMap;
        addMark1();
        addMark2();
        addMark3();
        addMark4();
    }

    private void addMark1() {
        r = AppUtil.getDataRutas().get(pos);
        latitud = r.getLatitud1();
        longitud= r.getLongitud1();
        latituD = Double.valueOf(latitud);
        longituD = Double.valueOf(longituD);
        LatLng latLng = new LatLng(latituD,longituD);
        rutagooglemap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        rutagooglemap.moveCamera(CameraUpdateFactory.zoomTo(14));
        rutagooglemap.addMarker(new MarkerOptions().position(new LatLng(latituD, longituD)).title(r.getLocal1()));


    }

    private void addMark2() {
        r = AppUtil.getDataRutas().get(pos);
        latitud = r.getLatitud2();
        longitud= r.getLongitud2();
        latituD = Double.valueOf(latitud);
        longituD = Double.valueOf(longituD);
        LatLng latLng = new LatLng(latituD,longituD);
        rutagooglemap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        rutagooglemap.moveCamera(CameraUpdateFactory.zoomTo(14));
        rutagooglemap.addMarker(new MarkerOptions().position(new LatLng(latituD,longituD)).title(r.getLocal2()));


    }

    private void addMark3() {
        r = AppUtil.getDataRutas().get(pos);
        latitud = r.getLatitud3();
        longitud= r.getLongitud3();
        latituD = Double.valueOf(latitud);
        longituD = Double.valueOf(longituD);
        LatLng latLng = new LatLng(latituD,longituD);
        rutagooglemap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        rutagooglemap.moveCamera(CameraUpdateFactory.zoomTo(14));
        rutagooglemap.addMarker(new MarkerOptions().position(new LatLng(latituD,longituD)).title(r.getLocal3()));


    }

    private void addMark4() {
        r = AppUtil.getDataRutas().get(pos);
        latitud = r.getLatitud4();
        longitud= r.getLongitud4();
        latituD = Double.valueOf(latitud);
        longituD = Double.valueOf(longituD);
        LatLng latLng = new LatLng(latituD,longituD);
        rutagooglemap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        rutagooglemap.moveCamera(CameraUpdateFactory.zoomTo(14));
        rutagooglemap.addMarker(new MarkerOptions().position(new LatLng(latituD,longituD)).title(r.getLocal4()));


    }
}

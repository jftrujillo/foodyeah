package com.example.jhonfredy.foodyeah.fragments;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jhonfredy.foodyeah.Models.Restaurantes;
import com.example.jhonfredy.foodyeah.R;
import com.example.jhonfredy.foodyeah.Util.AppUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescripcionRestauranteFragment extends android.support.v4.app.Fragment{


    int pos;

    List<Restaurantes> data = AppUtil.getDataRestaurantes();
    Restaurantes r;
    int widhtImg,heightImg;



    public DescripcionRestauranteFragment() {
        // Required empty public constructor
    }

    public void init(int pos){
        this.pos = pos;

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_descripcion_restaurante, container,false);
       WindowManager wM = (WindowManager) getActivity().getSystemService(getActivity().WINDOW_SERVICE);
        Display display = wM.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        widhtImg = display.getWidth();
        heightImg = getActivity().getResources().getDimensionPixelSize(R.dimen.template_img_height);
        r = data.get(pos);
        ImageView img = (ImageView) v.findViewById(R.id.portada);
        Picasso.with(getActivity()).load(r.getImagen()).into(img);
         img= (ImageView) v.findViewById(R.id.logo);
        Picasso.with(getActivity()).load(r.getLogotipo()).into(img);

        TextView txt = (TextView) v.findViewById(R.id.nombre);
        txt.setText(r.getNombre());
         txt = (TextView) v.findViewById(R.id.direccion);
        txt.setText(r.getDireccion());
        txt = (TextView) v.findViewById(R.id.telefono);
        txt.setText(r.getTelefono());
        txt = (TextView) v.findViewById(R.id.platos);
        txt.setText(r.getPlatos_imp());
        txt= (TextView) v.findViewById(R.id.descripcion);
        txt.setText(r.getDescripcion());
        return v;
    }


}

package com.example.jhonfredy.foodyeah.fragments;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jhonfredy.foodyeah.Adapters.RutasListaAdapter;
import com.example.jhonfredy.foodyeah.Models.Restaurantes;
import com.example.jhonfredy.foodyeah.R;
import com.example.jhonfredy.foodyeah.Util.AppUtil;

public class RutasListaFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener {

    public static final int TYPE_F=2;
    static RutasListaAdapter adapter;
    ListView list;
    ListSelectedI listaRutasI;

    public RutasListaFragment() {

    }

    public void init(ListSelectedI listaRutasI) {
        this.listaRutasI = listaRutasI;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_rutas_lista, container, false);
        list = (ListView) v.findViewById(R.id.list);
        adapter = new RutasListaAdapter(getActivity(), AppUtil.getDataRutas());
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        return v;


    }


  public void notifyDataSet(){
      adapter.notifyDataSetChanged();
  }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        listaRutasI.itemSelected(position,TYPE_F);
    }
}

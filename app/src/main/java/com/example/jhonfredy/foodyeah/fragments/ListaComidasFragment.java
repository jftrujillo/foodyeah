package com.example.jhonfredy.foodyeah.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jhonfredy.foodyeah.Adapters.ComidaListaAdapter;
import com.example.jhonfredy.foodyeah.DeascripcionComida;
import com.example.jhonfredy.foodyeah.Models.Comida;
import com.example.jhonfredy.foodyeah.Net.ComidaCon;
import com.example.jhonfredy.foodyeah.R;
import com.example.jhonfredy.foodyeah.Util.AppUtil;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaComidasFragment extends Fragment implements AdapterView.OnItemClickListener {


    public static final int TYPE_F=0;

    ComidaListaAdapter adapter;
    ListView list;
    static ListSelectedI listaComidaI;
    Context context;

    public ListaComidasFragment() {
        // Required empty public constructor
    }

    public void init(ListSelectedI listaComidaI){
        this.listaComidaI = listaComidaI;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_lista_comidas, container, false);
        list = (ListView) v.findViewById(R.id.list);

        adapter = new ComidaListaAdapter(getActivity(), AppUtil.getDataComida());

        list.setAdapter(adapter);

        list.setOnItemClickListener(this);

        return v;
    }


    public void notifyDataSet() {
        if (adapter != null) {

            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        listaComidaI.itemSelected(position, TYPE_F);

    }
}

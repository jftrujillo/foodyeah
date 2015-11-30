package com.example.jhonfredy.foodyeah.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jhonfredy.foodyeah.Adapters.RestaurantesListaAdapter;
import com.example.jhonfredy.foodyeah.R;
import com.example.jhonfredy.foodyeah.Util.AppUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantesListaFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener {


    public static final int TYPE_F=1;

    RestaurantesListaAdapter adapter;
    ListView list;
    ListSelectedI listaRestaurantesI;

    public RestaurantesListaFragment() {
        // Required empty public constructor
    }

    public void init (ListSelectedI listaRestaurantesI){
        this.listaRestaurantesI = listaRestaurantesI;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_restaurantes_lista2,container,false);
        list = (ListView) v.findViewById(R.id.list);
        adapter = new RestaurantesListaAdapter(getActivity(), AppUtil.getDataRestaurantes());
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
        listaRestaurantesI.itemSelected(position,TYPE_F);

    }





}

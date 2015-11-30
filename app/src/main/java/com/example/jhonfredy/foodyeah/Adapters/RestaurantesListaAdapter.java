package com.example.jhonfredy.foodyeah.Adapters;

import android.content.Context;
import android.media.Image;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jhonfredy.foodyeah.ListaRestaurantes;
import com.example.jhonfredy.foodyeah.Models.Restaurantes;
import com.example.jhonfredy.foodyeah.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jhonfredy on 24/05/2015.
 */
public class RestaurantesListaAdapter extends BaseAdapter {

    Context context;
    List<Restaurantes> data;

    int widhtImg, heightImg;

    public RestaurantesListaAdapter(Context context, List<Restaurantes> data) {
        this.context = context;
        this.data = data;
        WindowManager wM = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        Display display = wM.getDefaultDisplay();

        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        widhtImg = display.getWidth();
        heightImg = context.getResources().getDimensionPixelSize(R.dimen.template_img_height);

    }




    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if(convertView != null)
            v = convertView;
        else

        v= View.inflate(context,R.layout.template_restauarntes,null);
        Restaurantes r= (Restaurantes) getItem(position);

        TextView txt = (TextView) v.findViewById(R.id.nombre);
        txt.setText(r.getNombre());
        txt = (TextView) v.findViewById(R.id.descripcion);
        txt.setText(r.getDescripcion());

        txt = (TextView) v.findViewById(R.id.telefono);
        txt.setText(r.getTelefono());

        ImageView img = (ImageView) v.findViewById(R.id.logotipo);
        Picasso.with(context).load(r.getLogotipo()).resize(widhtImg,heightImg).into(img);

        img = (ImageView) v.findViewById(R.id.portada);
        Picasso.with(context).load(r.getImagen()).resize(widhtImg,heightImg).into(img);

        return v;





    }
}

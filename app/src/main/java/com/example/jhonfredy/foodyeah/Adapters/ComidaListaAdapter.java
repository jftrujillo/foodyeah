package com.example.jhonfredy.foodyeah.Adapters;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jhonfredy.foodyeah.Models.Comida;
import com.example.jhonfredy.foodyeah.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jhonfredy on 23/05/2015.
 */
public class ComidaListaAdapter extends BaseAdapter {
    Context context;
    List<Comida> data;

    int widtImg, heightImg;

    public ComidaListaAdapter(Context context, List<Comida> data) {
        this.context = context;
        this.data = data;

        WindowManager wM = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        Display display = wM.getDefaultDisplay();

        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        widtImg = display.getWidth();
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
        if (convertView != null )
            v=convertView;
        else
        v = View.inflate(context, R.layout.template_comida,null);

        Comida c = (Comida) getItem(position);
        TextView txt = (TextView) v.findViewById(R.id.title);
        txt.setText(c.getNombre());

        txt = (TextView) v.findViewById(R.id.description);
        txt.setText(c.getDescripcion());


        txt = (TextView) v.findViewById(R.id.restaurantes);
        txt.setText(c.getRestaurantes());



        ImageView img = (ImageView) v.findViewById(R.id.img);
        Picasso.with(context).load(c.getImgurl()).resize(widtImg,heightImg).into(img);




        return v;
    }
}

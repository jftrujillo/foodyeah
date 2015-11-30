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

import com.example.jhonfredy.foodyeah.Models.Rutas;
import com.example.jhonfredy.foodyeah.R;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by jhonfredy on 26/05/2015.
 */
public class RutasListaAdapter extends BaseAdapter {
    Context context;
    List<Rutas> data;
    int widhtImg, heightImg;

    public RutasListaAdapter(Context context, List<Rutas> data) {
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
        return  data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if(convertView != null)
            v=convertView;
        else

        v= View.inflate(context, R.layout.template_rutas,null);
        Rutas r = (Rutas) getItem(position);
        TextView txt = (TextView) v.findViewById(R.id.nombre);
        txt.setText(r.getNombre());
        txt = (TextView) v.findViewById(R.id.lugares);
        txt.setText(r.getLocal1() + ", "+ r.getLocal2()+ ", "+ r.getLocal3() + ", "+  r.getLocal4() + ", "+ r.getLocal5() );
       ImageView img = (ImageView) v.findViewById(R.id.logo);
       Picasso.with(context).load(r.getImgprevia()).into(img);
        return v;

    }
}

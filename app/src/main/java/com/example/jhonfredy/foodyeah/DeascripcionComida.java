package com.example.jhonfredy.foodyeah;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jhonfredy.foodyeah.Models.Comida;
import com.example.jhonfredy.foodyeah.Net.ComidaCon;
import com.example.jhonfredy.foodyeah.Util.AppUtil;
import com.squareup.picasso.Picasso;

import java.util.List;


public class DeascripcionComida extends ActionBarActivity {

    List<Comida> data = AppUtil.getDataComida();
    Comida c;
    Button favoritos;
    ImageView img;
    TextView nombre;
    TextView descripcion;
    TextView restaurantes;
    TextView txt;
    int widtImg, heightImg,pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        pos = (int) bundle.get("pos");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deascripcion_comida);
        WindowManager wM = (WindowManager) this.getSystemService(this.WINDOW_SERVICE);
        Display display = wM.getDefaultDisplay();

        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        widtImg = display.getWidth();
        heightImg = this.getResources().getDimensionPixelSize(R.dimen.template_img_height);
        c= data.get(pos);

        img = (ImageView) findViewById(R.id.portada);
        nombre = (TextView) findViewById(R.id.nombre);
        descripcion = (TextView) findViewById(R.id.descripcion);
        restaurantes = (TextView) findViewById(R.id.restaurantes);
        Picasso.with(this).load(c.getImgurl()).into(img);
        nombre.setText(c.getNombre());
        descripcion.setText(c.getDescripcion());
        restaurantes.setText(c.getRestaurantes());
        txt = (TextView) findViewById(R.id.ingredientes);
        txt.setText(c.getIngredientes());

        txt= (TextView) findViewById(R.id.preparacion);
        txt.setText(c.getPreparacion());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_deascripcion_comida, menu);
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


}

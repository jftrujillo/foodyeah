package com.example.jhonfredy.foodyeah;

import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jhonfredy.foodyeah.Models.Rutas;
import com.example.jhonfredy.foodyeah.Util.AppUtil;
import com.example.jhonfredy.foodyeah.fragments.RutasFragment;

import java.util.List;


public class MapaRutasActivity extends AppCompatActivity {

    List<Rutas> data = AppUtil.getDataRutas();
    Rutas r;
    int pos;
    RutasFragment rutasF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        pos = (int) bundle.get("pos");
        r= data.get(pos);


        rutasF = new RutasFragment();
        rutasF.init(pos);

        android.support.v4.app.FragmentTransaction ft= getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.container2,rutasF);
        ft.commit();

        setContentView(R.layout.activity_mapa_rutas);
    }

    @Override
    protected void onResume() {
        super.onResume();
        rutasF.init(pos);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mapa_rutas, menu);
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

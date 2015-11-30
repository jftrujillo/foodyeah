/*package com.example.jhonfredy.foodyeah;

import android.os.Environment;

import com.example.jhonfredy.foodyeah.Models.Comida;
import com.example.jhonfredy.foodyeah.Util.AppUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * Created by MobileLab18 on 29/05/2015.
 */
/*public class Favoritos implements Serializable {
    List<Comida> data = AppUtil.getDataComida();
    Comida c;

    public void init (int pos){
        c = data.get(pos);
    }

    File favoritos = new File(Environment.getExternalStorageDirectory(),"Favoritos/favoritos");
    FileOutputStream fileStream = new FileOutputStream(favoritos);
    ObjectOutputStream salida = new ObjectOutputStream(fileStream);

    public void setSalida(ObjectOutputStream salida) throws IOException {
        this.salida = salida;
        salida.write(c);
        salida.close();
    }
}
*/
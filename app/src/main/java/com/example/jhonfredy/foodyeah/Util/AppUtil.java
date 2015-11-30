package com.example.jhonfredy.foodyeah.Util;

import com.example.jhonfredy.foodyeah.Models.Comida;
import com.example.jhonfredy.foodyeah.Models.Restaurantes;
import com.example.jhonfredy.foodyeah.Models.Rutas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DarioFernando on 25/05/2015.
 */
    public class AppUtil {

        public static List<Comida> dataComida;

        public static List<Comida> getDataComida(){
            if(dataComida==null)
                dataComida = new ArrayList<>();
            return  dataComida;
        }

    public static List<Restaurantes> dataRestaurantes;
    public static List<Restaurantes> getDataRestaurantes(){
        if(dataRestaurantes == null)
            dataRestaurantes = new ArrayList<>();
        return dataRestaurantes;

    }
    public static List<Rutas> dataRutas;
    public static List<Rutas> getDataRutas(){
        if(dataRutas == null)
            dataRutas = new ArrayList<>();
        return dataRutas;

    }

}

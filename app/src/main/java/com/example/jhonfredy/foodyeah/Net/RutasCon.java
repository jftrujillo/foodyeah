package com.example.jhonfredy.foodyeah.Net;

import android.content.Context;

import com.example.jhonfredy.foodyeah.Models.Rutas;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;

import java.util.List;

/**
 * Created by jhonfredy on 26/05/2015.
 */
public class RutasCon extends AzureClient<Rutas> {
    public interface RutasConI{
        void onCompleted(Rutas entity, Exception exception, ServiceFilterResponse response);
        void onDeleteCompleted(Exception exception, ServiceFilterResponse response);
        void onReadRutasCompleted(List<Rutas> result, int count, Exception exception, ServiceFilterResponse response);

    };
    RutasConI rutasConI;


    public RutasCon(Context context, RutasConI rutasConI) {
        super(context);
        this.rutasConI = rutasConI;
    }

    @Override
    public Class<Rutas> getClassModel() {
        return Rutas.class;
    }

    @Override
    public void onCompleted(Rutas entity, Exception exception, ServiceFilterResponse response) {
    rutasConI.onCompleted(entity,exception,response);
    }

    @Override
    public void onCompleted(Exception exception, ServiceFilterResponse response) {
  rutasConI.onDeleteCompleted(exception,response);
    }

    @Override
    public void onCompleted(List<Rutas> result, int count, Exception exception, ServiceFilterResponse response) {
    rutasConI.onReadRutasCompleted(result,count,exception,response);
    }
}

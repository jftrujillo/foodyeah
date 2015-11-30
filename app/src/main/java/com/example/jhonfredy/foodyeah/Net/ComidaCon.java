package com.example.jhonfredy.foodyeah.Net;

import android.content.Context;

import com.example.jhonfredy.foodyeah.Models.Comida;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableQueryCallback;

import java.util.List;

/**
 * Created by jhonfredy on 23/05/2015.
 */
public class ComidaCon extends AzureClient<Comida> implements TableQueryCallback<Comida> {
    public interface  ComidaConI{
        void onCompleted(Comida entity, Exception exception, ServiceFilterResponse response);
        void onDeleteCompleted(Exception exception, ServiceFilterResponse response);
        void onReadCompleted(List<Comida> result, int count, Exception exception, ServiceFilterResponse response);

    }

    ComidaConI comidaConI;

    public ComidaCon(Context context, ComidaConI comidaConI) {
        super(context);
        this.comidaConI= comidaConI;

    }

    @Override
    public Class<Comida> getClassModel() {
        return Comida.class;
    }
      @Override
    public void onCompleted(Exception exception, ServiceFilterResponse response) {
        comidaConI.onDeleteCompleted(exception, response);
    }

    @Override
    public void onCompleted(Comida entity, Exception exception, ServiceFilterResponse response) {
        comidaConI.onCompleted(entity, exception,response);
    }

    @Override
    public void onCompleted(List<Comida> result, int count, Exception exception, ServiceFilterResponse response) {
        comidaConI.onReadCompleted(result,count,exception,response);
    }
}

package com.example.jhonfredy.foodyeah.Net;

import android.content.Context;

import com.example.jhonfredy.foodyeah.Models.Restaurantes;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;

import java.util.List;

/**
 * Created by jhonfredy on 24/05/2015.
 */
public class RestauranteCon extends AzureClient<Restaurantes> {


    public interface RestauranteConI{
        void onCompleted(Restaurantes entity, Exception exception, ServiceFilterResponse response);
        void onDeleteCompleted(Exception exception, ServiceFilterResponse response);
        void onReadRestaurantesCompleted(List<Restaurantes> result, int count, Exception exception, ServiceFilterResponse response);

    }

    RestauranteConI restauranteConI;

    public RestauranteCon(Context context, RestauranteConI restauranteConI) {
        super(context);
        this.restauranteConI = restauranteConI;
    }


    @Override
    public Class<Restaurantes> getClassModel() {
        return Restaurantes.class;
    }

    @Override
    public void onCompleted(Restaurantes entity, Exception exception, ServiceFilterResponse response) {
        restauranteConI.onCompleted(entity, exception,response);

    }

    @Override
    public void onCompleted(Exception exception, ServiceFilterResponse response) {
        restauranteConI.onDeleteCompleted(exception, response);
    }

    @Override
    public void onCompleted(List<Restaurantes> result, int count, Exception exception, ServiceFilterResponse response) {
restauranteConI.onReadRestaurantesCompleted(result,count,exception,response);
    }
}

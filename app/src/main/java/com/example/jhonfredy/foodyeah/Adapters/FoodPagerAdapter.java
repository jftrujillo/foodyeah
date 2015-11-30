package com.example.jhonfredy.foodyeah.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


/**
 * Created by jhonfredy on 17/05/2015.
 */
public class FoodPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> data;

    public FoodPagerAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data = data;
    }

   
  
    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0: return "Platos Tipicos";
            case 1: return "Restaurantes";
            case 2: return "Rutas";
            default: return "";
        }

    }



    @Override
    public Fragment getItem(int i) {

        //crear fragmento con el nombre como argumento

        return data.get(i);


    }

    @Override
    public int getCount() {
        return 3;
    }
}

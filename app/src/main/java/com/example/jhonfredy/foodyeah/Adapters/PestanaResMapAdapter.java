package com.example.jhonfredy.foodyeah.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Switch;

import com.example.jhonfredy.foodyeah.fragments.DescripcionRestauranteFragment;

import java.util.List;

/**
 * Created by jhonfredy on 27/05/2015.
 */
public class PestanaResMapAdapter extends FragmentPagerAdapter {
    List<Fragment> data;

   static int pos;
    public PestanaResMapAdapter(FragmentManager fm,List<Fragment> data, int pos) {
        super(fm);
       this.data = data;
        this.pos = pos;

    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0: return "Restaurante";
            case 1: return "Mapa";
            default: return "";

        }
    }

    @Override
    public Fragment getItem(int i) {

return  data.get(i);

    }

    @Override
    public int getCount() {
        return 2;
    }
}

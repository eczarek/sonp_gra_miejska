package myapp.mycom.com.gra_miejska;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

/**
 * Created by Czarek on 11.11.2015.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    public int id;

    public FragmentManager fm;

    public PagerAdapter(FragmentManager fm, int id) {
        super(fm);
        this.fm = fm;
        this.id = id;
    }



    public int getCount() {
        return 2;
    }

   /* public Object instantiateItem(View collection, int position) {

        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int resId = 0;
        View view = null;
        switch (position) {
            case 0:
                resId = R.layout.game_hint_fragment;
                view = inflater.inflate(resId, null);
<<<<<<< HEAD
                new HintFragment(view, id, collection);
               //activity();
=======
                new HintFragment(view, id);
>>>>>>> 9b87f7c255d17398db2562133376bd44f49ebde9
                break;
            case 1:
                resId= R.layout.game_map_fragment;
                view = inflater.inflate(resId, null);
<<<<<<< HEAD
                new MapFragment(view,fm , collection);
=======
                new MapFragment(view);
>>>>>>> 9b87f7c255d17398db2562133376bd44f49ebde9
                break;

        }



        ((ViewPager) collection).addView(view, 0);

        return view;
    }*/




    @Override
    public Fragment getItem(int position) {
        Fragment fragment =null;
        switch (position) {
            case 0:
                //fragment = FirstFragment.newInstance(0, "Page # 1");
                break;
            case 1:
                //fragment = SecendFragment.newInstance(1, "Page # 2");
                break;       }
        return fragment;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);

    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}

package myapp.mycom.com.gra_miejska;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Czarek on 11.11.2015.
 */
public class GameFragment extends Fragment {

    public final int id;

    public GameFragment(int id) {
        this.id=id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.game_fragment, container, false);

        PagerAdapter adapter = new PagerAdapter(((FragmentActivity) getActivity()).getSupportFragmentManager(), id);
        ViewPager myPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        myPager.setAdapter(adapter);

        //myPager.setCurrentItem(0);
        

        myPager.setCurrentItem(0);


        return rootView;
    }


}


package myapp.mycom.com.gra_miejska;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Czarek on 2015-11-11.
 */
public class AboutFragment extends android.app.Fragment {

    public AboutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.about_fragment, container, false);
        return rootView;
    }



}
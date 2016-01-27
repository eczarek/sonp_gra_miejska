package myapp.mycom.com.gra_miejska;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Czarek on 2015-11-11.
 */
public class MenuFragment extends Fragment {

    public MenuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.menu_fragment, container, false);

        Button buttonlistgame = (Button) rootView.findViewById(R.id.button);
        buttonlistgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(new ListGameFragment());
            }
        });

        Button buttonabout = (Button) rootView.findViewById(R.id.button2);
        buttonabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(new AboutFragment());
            }
        });

        Button buttonexit = (Button) rootView.findViewById(R.id.button3);
        buttonexit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).exit();
            }
        });
        return rootView;
    }



}

package myapp.mycom.com.gra_miejska;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.ArrayList;
import java.util.List;

import myapp.mycom.com.gra_miejska.json.Game;

import static java.lang.Math.abs;
import static myapp.mycom.com.gra_miejska.json.Game.downloadGame;
import static myapp.mycom.com.gra_miejska.json.Game.getGame;
import static myapp.mycom.com.gra_miejska.json.Game.getReady;

/**
 * Created by Czarek on 16.11.2015.
 */
public class HintFragment extends Fragment implements OnMapReadyCallback {

    public List<String> answers = new ArrayList<String>();

    private TextView texthint;

    private EditText hintanswer;

    private Button checkanswer;

    private Button next;

    private Button map;

    private Double lat;

    private Double lng;

    private Double thislat;

    private Double thislng;

    GPSTracker gps;

    int a;

    int id;


    public HintFragment (int id){
        this.id = id;
    }


    private void nextDescription() {
        texthint.setText(getGame().get(a).getDescription());
        answers = getGame().get(a).getAnswers();
        lat = getGame().get(a).getPoint().getLat();
        lng = getGame().get(a).getPoint().getLng();

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.game_hint_fragment, container, false);

        a=0;

        texthint =(TextView) rootView.findViewById(R.id.gamehint);
        hintanswer = (EditText) rootView.findViewById(R.id.hintanswer);
        checkanswer = (Button)rootView.findViewById(R.id.checkanswer);
        next = (Button)rootView.findViewById(R.id.next);

        map = (Button)rootView.findViewById(R.id.map);

        gps = new GPSTracker(rootView.getContext());

        downloadGame(id);


        if(getReady())
        { nextDescription();}

        checkanswer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gps = new GPSTracker(rootView.getContext());
                nextDescription();

                if (gps.canGetLocation()) {
                    thislat = gps.getLatitude();
                    thislng = gps.getLongitude();

                    if (abs(lat - thislat) < 0.001 && abs(lng - thislng) < 0.001) {

                        for (int i = 0; i < answers.size(); ++i) {
                            if (hintanswer.getText().toString().equals(answers.get(i))) {
                                Toast.makeText(rootView.getContext().getApplicationContext(),
                                        "Gratulation!!!", Toast.LENGTH_SHORT)
                                        .show();
                                a++;
                                next.setEnabled(true);
                            } else {
                                Toast.makeText(rootView.getContext().getApplicationContext(),
                                        "Wrong answer", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                    } else {
                        Toast.makeText(rootView.getContext().getApplicationContext(),
                                "You are to far from point!", Toast.LENGTH_SHORT)
                                .show();
                    }
                } else {
                    Toast.makeText(rootView.getContext().getApplicationContext(),
                            " gps wrong", Toast.LENGTH_SHORT)
                            .show();
                }

            }

        });

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(a >= Game.hints.size()-1){
                    ((MainActivity) getActivity()).replaceFragment(new WinFragment());

                } else {
                    nextDescription();
                    next.setEnabled(false);

                }
            }

        });

        map.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //((MainActivity) getActivity()).replaceFragment(new MapFragment());
                Toast.makeText(rootView.getContext().getApplicationContext(),
                        " Map in Premium", Toast.LENGTH_SHORT)
                        .show();

            }



        });

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}

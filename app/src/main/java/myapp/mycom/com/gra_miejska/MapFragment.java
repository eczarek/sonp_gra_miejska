package myapp.mycom.com.gra_miejska;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by Czarek on 16.11.2015.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {


    public MapFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.game_map_fragment, container, false);

        /*SupportMapFragment mapFragment = (SupportMapFragment) ((MainActivity) getActivity()).getSupportFragmentManager()
                .findFragmentById(R.id.map);


        mapFragment.getMapAsync(this);*/

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        /*map.moveCamera(CameraUpdateFactory.zoomTo(16));
        LatLng lodz1 = new LatLng(51.7466045, 19.4503513);
        map.addMarker(new MarkerOptions().position(lodz1).title("4DS"));
        map.moveCamera(CameraUpdateFactory.newLatLng(lodz1));


        LatLng lodz2 = new LatLng(51.7469644, 19.4554446);
        map.addMarker(new MarkerOptions().position(lodz2).title("CTI"));
        map.moveCamera(CameraUpdateFactory.newLatLng(lodz2));*/
    }


}

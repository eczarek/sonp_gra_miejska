package myapp.mycom.com.gra_miejska;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Czarek on 02.12.2015.
 */
public class Map extends FragmentActivity implements OnMapReadyCallback {

    //private GoogleMap map;

    public Map() {
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_map_fragment);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney, Australia, and move the camera.
        //  LatLng sydney = new LatLng(-34, 151);
        //  map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //  map.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        map.moveCamera(CameraUpdateFactory.zoomTo(16));
        LatLng lodz1 = new LatLng(51.7466045, 19.4503513);
        map.addMarker(new MarkerOptions().position(lodz1).title("4DS"));
        map.moveCamera(CameraUpdateFactory.newLatLng(lodz1));


        LatLng lodz2 = new LatLng(51.7469644, 19.4554446);
        map.addMarker(new MarkerOptions().position(lodz2).title("CTI"));
        map.moveCamera(CameraUpdateFactory.newLatLng(lodz2));
    }
}

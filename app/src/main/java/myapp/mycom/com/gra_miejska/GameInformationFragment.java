package myapp.mycom.com.gra_miejska;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static myapp.mycom.com.gra_miejska.json.Game.downloadGame;
import static myapp.mycom.com.gra_miejska.json.GameInfo.downloadGameInfo;
import static myapp.mycom.com.gra_miejska.json.GameInfo.getDescription;
import static myapp.mycom.com.gra_miejska.json.GameInfo.getExpectedTime;
import static myapp.mycom.com.gra_miejska.json.GameInfo.getLevel;
import static myapp.mycom.com.gra_miejska.json.GameInfo.getTitle;

/**
 * Created by Czarek on 2015-11-11.
 */
public class GameInformationFragment extends Fragment {

    public int id;

    public GameInformationFragment(int ID) {
        this.id = ID;
        downloadGameInfo(ID);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.game_information_fragment, container, false);

        TextView title = (TextView)rootView.findViewById(R.id.title);

        title.setText(getTitle());

        TextView description = (TextView)rootView.findViewById(R.id.description);

        description.setText(getDescription());

        TextView time = (TextView)rootView.findViewById(R.id.time_game);

        time.setText(Integer.toString(getExpectedTime()) + " h");

        ImageView level = (ImageView)rootView.findViewById(R.id.level);


        switch (getLevel()) {
            case 1:
                level.setImageResource(R.drawable.level1_76);
                break;
            case 2:
                level.setImageResource(R.drawable.level2_76);
                break;
            case 3:
                level.setImageResource(R.drawable.level3_76);
                break;
            case 4:
                level.setImageResource(R.drawable.level4_76);
                break;
            default:
                level.setImageResource(R.drawable.level4_76);
                break;
        }


        Button buttonstart = (Button) rootView.findViewById(R.id.buttonstart);
        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadGame(id);
                ((MainActivity) getActivity()).replaceFragment(new HintFragment(id));


                //downloadGame(id);
                //((MainActivity) getActivity()).replaceFragment(new GameFragment(id));

            }
        });

        return rootView;
    }




}
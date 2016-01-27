package myapp.mycom.com.gra_miejska;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static myapp.mycom.com.gra_miejska.json.GameList.getGameList;

/**
 * Created by Czarek on 2015-11-11.
 */
public class ListGameFragment extends Fragment {


    public ListGameFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.list_game_fragment, container, false);

        final ListView listview = (ListView) rootView.findViewById(R.id.list);

        /*String[] values = new String[] { "game 1", "game 2", "game 3",
                "game 4", "game 5"};*/

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < getGameList().size(); ++i) {
            list.add(getGameList().get(i).getTitle());
        }
        /*for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }*/



        final StableArrayAdapter adapter = new StableArrayAdapter(getActivity().getApplicationContext(),
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            int ID;
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                for (int i = 0; i < getGameList().size(); ++i) {
                   if(getGameList().get(i).getTitle().equals(item))
                   {
                       ID = getGameList().get(i).getId();
                   }
                }
                ((MainActivity) getActivity()).replaceFragment(new GameInformationFragment(ID));
            }

        });

        return rootView;
    }

    private void getname(List list,int id) {
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  ArrayList<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }

}
